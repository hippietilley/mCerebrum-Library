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

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.md2k.system.constant.MCEREBRUM;
import org.md2k.system.provider.AppCP;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;
import rx.Observable;

public class ApplicationManager {
    protected ArrayList<AppInfoController> appInfoControllers;
    protected Context context;
    public ApplicationManager(Context context, ArrayList<AppCP> appCPs){
        this.context = context;
        appInfoControllers = new ArrayList<>();
        for(int i=0;i<appCPs.size();i++) {
            Log.d("abc","i="+i+" "+appCPs.get(i).getPackageName());
            appInfoControllers.add(new AppInfoController(context, appCPs.get(i)));
        }
    }
    public void startMCerebrumService() {
        for (AppInfoController appInfoController : appInfoControllers) {
            appInfoController.getmCerebrumController().startService();
        }
    }
    public void startMCerebrumService(AppInfoController appInfoController){
        appInfoController.getmCerebrumController().startService();
    }
    public void stopMCerebrumService(AppInfoController appInfoController){
        appInfoController.getmCerebrumController().stopService();
    }
    public void stopBackground(){
        for(int i=0;i<appInfoControllers.size();i++) {
            try {
                appInfoControllers.get(i).getmCerebrumController().stopBackground(null);
            }catch (Exception e){

            }
        }
    }

    public void stopMCerebrumService() {
        for (AppInfoController appInfoController : appInfoControllers) {
            try {
                appInfoController.getmCerebrumController().stopService();
            } catch (Exception ignored) {

            }
        }
    }

    public boolean isRequiredAppInstalled() {
        for (AppInfoController appInfoController : appInfoControllers)
            if (appInfoController.getAppBasicInfoController().isUseAs(MCEREBRUM.APP.USE_AS_REQUIRED)) {
                if (!appInfoController.getInstallInfoController().isInstalled())
                    return false;
            }
        return true;
    }

    public ArrayList<AppInfoController> get() {
        return appInfoControllers;
    }
    public AppInfoController get(int i){
        return appInfoControllers.get(i);
    }

    public ArrayList<AppInfoController> getByType(String type) {
        ArrayList<AppInfoController> acs = new ArrayList<>();
        for (AppInfoController appInfoController : appInfoControllers) {
            if (appInfoController.getAppBasicInfoController().isType(type))
                acs.add(appInfoController);
        }
        return acs;
    }

    public void setmCerebrumInfo() {
        for (AppInfoController appInfoController : appInfoControllers) {
            if (!appInfoController.getmCerebrumController().isServiceRunning())
                appInfoController.getmCerebrumController().startService();
            else appInfoController.getmCerebrumController().setStatus();
        }
    }

    public boolean isCoreInstalled() {
        ArrayList<AppInfoController> apps = getByType(MCEREBRUM.APP.TYPE_STUDY);
        if (apps.size() != 0 && !apps.get(0).getInstallInfoController().isInstalled()) return false;
        apps = getByType(MCEREBRUM.APP.TYPE_DATAKIT);
        if (apps.size() != 0 && !apps.get(0).getInstallInfoController().isInstalled()) return false;
        return true;
    }

    public boolean isRequiredInstalled() {
        return getRequiredAppNotInstalled().size() == 0;
    }

    public ArrayList<AppInfoController> getRequiredAppNotInstalled() {
        ArrayList<AppInfoController> appInfos = new ArrayList<>();
//        if (this.appCPs == null) return appInfos;
        for (AppInfoController appInfo : this.appInfoControllers) {
            if (appInfo.getAppBasicInfoController().isUseAs(MCEREBRUM.APP.USE_AS_REQUIRED) && !appInfo.getInstallInfoController().isInstalled()) {
                appInfos.add(appInfo);
            }
        }
        return appInfos;
    }

    public ArrayList<AppInfoController> getRequiredAppNotConfigured() {
        ArrayList<AppInfoController> appInfos = new ArrayList<>();
//        if (this.appCPs == null) return appInfos;
        for (AppInfoController appInfo : this.appInfoControllers) {
            if (!appInfo.getAppBasicInfoController().isUseAs(MCEREBRUM.APP.USE_AS_REQUIRED)) continue;
            if (!appInfo.getInstallInfoController().isInstalled()) appInfos.add(appInfo);

            else if (appInfo.getmCerebrumController().isServiceRunning()
                    && appInfo.getmCerebrumController().isConfigurable()
                    && !appInfo.getmCerebrumController().isEqualDefault()) {
                appInfos.add(appInfo);
            }
        }
        return appInfos;
    }

    public ArrayList<AppInfoController> getRequiredAppConfigured() {
        ArrayList<AppInfoController> appInfos = new ArrayList<>();
//        if (this.appCPs == null) return appInfos;
        for (AppInfoController appInfo : this.appInfoControllers) {
            if (!appInfo.getAppBasicInfoController().isUseAs(MCEREBRUM.APP.USE_AS_REQUIRED)
                    || !appInfo.getInstallInfoController().isInstalled())
                continue;
            if (appInfo.getmCerebrumController().isServiceRunning()
                    && appInfo.getmCerebrumController().isConfigurable()
                    && !appInfo.getmCerebrumController().isEqualDefault()) {
                continue;
            }
            appInfos.add(appInfo);

        }
        return appInfos;
    }

    public int[] getInstallStatus() {
        int result[] = new int[3];
        result[0] = 0;
        result[1] = 0;
        result[2] = 0;
//        if (appCPs == null) return result;
        for (int i = 0; i < appInfoControllers.size(); i++) {
            if (!appInfoControllers.get(i).getInstallInfoController().isInstalled())
                result[2]++;
            else if (appInfoControllers.get(i).getInstallInfoController().hasUpdate())
                result[1]++;
            else result[0]++;
        }
        return result;
    }

    public void reset(String packageName) {
        AppInfoController appInfoController = getAppInfoController(packageName);
        if(appInfoController==null) return;
        boolean lastResult = appInfoController.getInstallInfoController().isInstalled();
        appInfoController.getInstallInfoController().reset();
        appInfoController.getmCerebrumController().reset();
//                appInfoControllers[i].getInstallInfoController().setInstalled();
        if (appInfoController.getInstallInfoController().isInstalled() != lastResult) {
            if (appInfoController.getInstallInfoController().isInstalled())
                appInfoController.getmCerebrumController().startService();
            else appInfoController.getmCerebrumController().stopService();
        }
    }

    Observable hasUpdate(String packageName) {
        AppInfoController appInfoController = getAppInfoController(packageName);
        if (appInfoController == null) return Observable.just(false);
        return appInfoController.getInstallInfoController().checkUpdate();
    }


    public Observable<Boolean> hasUpdate() {
        if (appInfoControllers == null || appInfoControllers.size() == 0)
            return Observable.just(false);
        ArrayList<Observable<Boolean>> observables=new ArrayList<>();
//        Observable[] observables = new Observable[getAppInfoControllers().length];
        for (int i = 0; i < appInfoControllers.size(); i++) {
            observables.add(appInfoControllers.get(i).getInstallInfoController().checkUpdate());
        }
        return Observable.merge(observables);
    }

    private AppInfoController getAppInfoController(String packageName) {
        for (AppInfoController appInfoController : appInfoControllers) {
            if (appInfoController.getPackageName().equals(packageName)) return appInfoController;
        }
        return null;
    }
}
