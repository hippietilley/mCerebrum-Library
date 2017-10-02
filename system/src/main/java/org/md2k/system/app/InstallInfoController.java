package org.md2k.system.app;
/*
 * Copyright (c) 2016, The University of Memphis, MD2K Center
 * - Syed Monowar Hossain <monowar.hossain@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.blankj.utilcode.util.AppUtils;

import org.md2k.mcerebrum.commons.app_info.AppInfo;
import org.md2k.mcerebrum.commons.storage.Storage;
import org.md2k.mcerebrum.commons.storage.StorageType;
import org.md2k.system.internet.download.DownloadFile;
import org.md2k.system.internet.download.DownloadInfo;
import org.md2k.system.constant.MCEREBRUM;
import org.md2k.system.provider.AppCP;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public  class InstallInfoController {
    private AppCP appCP;
    private Context context;
    private static final int REQUEST_CODE = 2000;
    public MCEREBRUM.APP.TYPE_DOWNLOAD getDownloadType(){
        if(appCP.getDownloadLink()==null) return MCEREBRUM.APP.TYPE_DOWNLOAD.UNKNOWN;
        if(appCP.getDownloadLink().toLowerCase().startsWith("market://"))
            return MCEREBRUM.APP.TYPE_DOWNLOAD.PLAYSTORE;
        if(appCP.getDownloadLink().toLowerCase().endsWith(".json"))
            return MCEREBRUM.APP.TYPE_DOWNLOAD.JSON;
        if(appCP.getDownloadLink().toLowerCase().endsWith(".apk"))
            return MCEREBRUM.APP.TYPE_DOWNLOAD.URL;
        if(appCP.getDownloadLink().split("/").length==2) return MCEREBRUM.APP.TYPE_DOWNLOAD.GITHUB;
        return MCEREBRUM.APP.TYPE_DOWNLOAD.UNKNOWN;
    }

    InstallInfoController(Context context, AppCP appCP) {
        this.appCP = appCP;
        this.context = context;
        setInfoInstalled();
        initInfoUpdate();
    }
    private void initInfoUpdate(){
        if(appCP.getExpectedVersion()!=null)
            appCP.setLatestVersion(context, appCP.getExpectedVersion());
//        else appCP.setLatestVersion(context,null);
    }
    void reset(){
        setInfoInstalled();
        initInfoUpdate();
    }

    private void setInfoInstalled() {
        boolean isInstalled = AppInfo.isPackageInstalled(context, appCP.getPackageName());
//        boolean isInstalled = AppUtils.isInstallApp(appCP.getPackageName());
        String currentVersion = null;
        if(isInstalled){
            currentVersion = AppInfo.getVersionName(context, appCP.getPackageName());
        }
        appCP.setInstalled(context, isInstalled, currentVersion);
    }
    public boolean hasUpdate(){
        //never update app
        if(appCP.getUpdate().equalsIgnoreCase(MCEREBRUM.APP.UPDATE_TYPE_NEVER)) return false;
        //App not installed
        if(appCP.getCurrentVersion()==null || appCP.getCurrentVersion().length()==0) return false;
        //Use specific version
        if(appCP.getExpectedVersion()!=null)
            return appCP.getCurrentVersion().equalsIgnoreCase(appCP.getExpectedVersion());
        // No update information
        if(appCP.getLatestVersion()==null) return false;
        //Compare update and current
        if(appCP.getCurrentVersion().equalsIgnoreCase(appCP.getLatestVersion()))
            return false;
        return true;
    }
    public Observable<Boolean> checkUpdate() {
        Observable<VersionInfo> observable = null;
        if(appCP.getExpectedVersion()!=null) return Observable.just(false);
        switch (getDownloadType()) {
            case GITHUB:
                observable = new AppFromGithub().getVersion(appCP.getDownloadLink(), appCP.getExpectedVersion());
                break;
            case JSON:
                observable = new AppFromJson().getVersion(context, appCP.getDownloadLink());
                break;
        }
        if (observable != null) {
            return observable.map(new Func1<VersionInfo, Boolean>() {
                @Override
                public Boolean call(VersionInfo versionInfo) {
                    appCP.setLatestVersion(context, versionInfo.versionName);
                    return hasUpdate();
                }
            });
        }
        else return Observable.just(false);
    }

    public Observable<DownloadInfo> install(final Activity activity) {
        final String dirName = Storage.getRootDirectory(activity, StorageType.SDCARD_INTERNAL) + "/mCerebrum/temp";
        final String fileName = "temp.apk";
        Observable<VersionInfo> observable = null;
        switch (getDownloadType()) {
            case PLAYSTORE:
                Intent goToMarket = new Intent(Intent.ACTION_VIEW)
                        .setData(Uri.parse(appCP.getDownloadLink()));
                goToMarket.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                activity.startActivityForResult(goToMarket, REQUEST_CODE);
                return Observable.just(new DownloadInfo(0,0,true));
            case GITHUB:
                observable = new AppFromGithub().getVersion(appCP.getDownloadLink(), appCP.getExpectedVersion());
                break;
            case JSON:
                observable = new AppFromJson().getVersion(context, appCP.getDownloadLink());
                break;
            case URL:
                VersionInfo versionInfo = new VersionInfo();
                versionInfo.downloadURL = appCP.getDownloadLink();
                observable = Observable.just(versionInfo);
                break;
        }
        if (observable != null) {
            return observable.flatMap(new Func1<VersionInfo, Observable<DownloadInfo>>() {
                @Override
                public Observable<DownloadInfo> call(VersionInfo versionInfo) {
                    if (versionInfo == null) return Observable.error(new Throwable("File can't be downloaded"));
                    return new DownloadFile().download(versionInfo.downloadURL, dirName, fileName).subscribeOn(Schedulers.computation());
                }
            }).map(new Func1<DownloadInfo, DownloadInfo>() {
                @Override
                public DownloadInfo call(DownloadInfo downloadInfo) {
                    if(downloadInfo.isCompleted())
                        AppUtils.installApp(activity, dirName+"/"+fileName, "org.md2k.mcerebrum.provider_file", REQUEST_CODE);
                    return downloadInfo;
                }
            });
        }
        else return Observable.error(new Throwable("File can't be downloaded"));
    }


    public void uninstall(Activity activity, int requestCode) {
        AppUtils.uninstallApp(activity, appCP.getPackageName(), requestCode);
    }
    public String getCurrentVersionName() {
        return appCP.getCurrentVersion();
    }

    public boolean isInstalled() {
        return appCP.getInstalled();
    }

    public String getLastVersionName() {
        return appCP.getLatestVersion();
    }
}
