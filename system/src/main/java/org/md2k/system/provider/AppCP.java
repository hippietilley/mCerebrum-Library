package org.md2k.system.provider;
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

import org.md2k.system.provider.appinfo.AppInfoBean;
import org.md2k.system.provider.appinfo.AppInfoContentValues;
import org.md2k.system.provider.appinfo.AppInfoCursor;
import org.md2k.system.provider.appinfo.AppInfoSelection;

public class AppCP{
    private AppInfoBean appInfoBean;

    public AppCP() {
        appInfoBean = new AppInfoBean();
    }

    public void set(Context context, String aid, String type, String title, String summary, String description, String packageName, String downloadLink, String update, String use_as, String expectedVersion, String icon, String currentVersion, String latestVersion, boolean installed, boolean mCerebrumSupported, boolean initialized) {
        appInfoBean.setAid(aid);
        appInfoBean.setType(type);
        appInfoBean.setTitle(title);
        appInfoBean.setSummary(summary);
        appInfoBean.setDescription(description);
        appInfoBean.setPackageName(packageName);
        appInfoBean.setDownloadLink(downloadLink);
        appInfoBean.setUpdates(update);
        appInfoBean.setUseAs(use_as);
        appInfoBean.setExpectedVersion(expectedVersion);
        appInfoBean.setIcon(icon);
        appInfoBean.setCurrentVersion(currentVersion);
        appInfoBean.setLatestVersion(latestVersion);
        appInfoBean.setInstalled(installed);
        appInfoBean.setMcerebrumSupported(mCerebrumSupported);
        appInfoBean.setInitialized(initialized);
        insertOrUpdate(context);
    }

    public void delete(Context context) {
        AppInfoSelection appInfoSelection = new AppInfoSelection().packageName(appInfoBean.getPackageName());
        appInfoSelection.delete(context);
    }

    private void insertOrUpdate(Context context) {
        AppInfoContentValues values = prepare();
        if(isEmpty(context))
            values.insert(context);
        else
            values.update(context, new AppInfoSelection().packageName(appInfoBean.getPackageName()));
    }

    public boolean read(Context context) {
        AppInfoSelection appInfoSelection = new AppInfoSelection();
        AppInfoCursor c = appInfoSelection.query(context);
        if (c.moveToNext()) {
            setFromCP(c);
            c.close();
            return true;
        } else {
            c.close();
            return false;
        }
    }

    public void setFromCP(AppInfoCursor appInfoCursor) {
        appInfoBean.setAid(appInfoCursor.getAid());
        appInfoBean.setType(appInfoCursor.getType());
        appInfoBean.setTitle(appInfoCursor.getTitle());
        appInfoBean.setSummary(appInfoCursor.getSummary());
        appInfoBean.setDescription(appInfoCursor.getDescription());
        appInfoBean.setPackageName(appInfoCursor.getPackageName());
        appInfoBean.setDownloadLink(appInfoCursor.getDownloadLink());
        appInfoBean.setUpdates(appInfoCursor.getUpdates());
        appInfoBean.setUseAs(appInfoCursor.getUseAs());
        appInfoBean.setExpectedVersion(appInfoCursor.getExpectedVersion());
        appInfoBean.setCurrentVersion(appInfoCursor.getCurrentVersion());
        appInfoBean.setLatestVersion(appInfoCursor.getLatestVersion());
        appInfoBean.setInstalled(appInfoCursor.getInstalled());
        appInfoBean.setInitialized(appInfoCursor.getInitialized());
        appInfoBean.setMcerebrumSupported(appInfoCursor.getMcerebrumSupported());
    }

    public boolean isEmpty(Context context) {
        int count = 0;
        AppInfoSelection appInfoSelection = new AppInfoSelection().packageName(appInfoBean.getPackageName());
        AppInfoCursor c = appInfoSelection.query(context);
        while (c.moveToNext()) {
            count++;
        }
        c.close();
        return count == 0;
    }

    private AppInfoContentValues prepare() {
        AppInfoContentValues values = new AppInfoContentValues();
        values.putAid(appInfoBean.getAid());
        values.putType(appInfoBean.getType());
        values.putTitle(appInfoBean.getTitle());
        values.putSummary(appInfoBean.getSummary());
        values.putDescription(appInfoBean.getDescription());
        values.putPackageName(appInfoBean.getPackageName());
        values.putDownloadLink(appInfoBean.getDownloadLink());
        values.putUpdates(appInfoBean.getUpdates());
        values.putUseAs(appInfoBean.getUseAs());
        values.putExpectedVersion(appInfoBean.getExpectedVersion());
        values.putCurrentVersion(appInfoBean.getCurrentVersion());
        values.putLatestVersion(appInfoBean.getLatestVersion());
        values.putInstalled(appInfoBean.getInstalled());
        values.putInitialized(appInfoBean.getInitialized());
        values.putMcerebrumSupported(appInfoBean.getMcerebrumSupported());
        return values;
    }

    public boolean isEqual(String packageName) {
        if(appInfoBean.getPackageName().equals(packageName)) return true;
        return false;
    }
    public String getPackageName(){
        return appInfoBean.getPackageName();
    }
    public String getIcon(){
        return appInfoBean.getIcon();
    }
    public String getType(){
        return appInfoBean.getType();
    }
    public String getTitle(){
        return appInfoBean.getTitle();
    }
    public String getSummary(){
        return appInfoBean.getSummary();
    }
    public String getDescription(){
        return appInfoBean.getDescription();
    }
    public String getUseAs(){
        return appInfoBean.getUseAs();
    }
    public String getDownloadLink(){
        return appInfoBean.getDownloadLink();
    }
    public boolean getInstalled(){
        return appInfoBean.getInstalled();
    }
    public String getCurrentVersion(){
        return appInfoBean.getCurrentVersion();
    }
    public String getExpectedVersion(){
        return appInfoBean.getExpectedVersion();
    }
    public String getLatestVersion(){
        return appInfoBean.getLatestVersion();
    }
    public void setLatestVersion(Context context, String version){
        appInfoBean.setLatestVersion(version);
        insertOrUpdate(context);
    }
    public String getUpdate(){
        return appInfoBean.getUpdates();
    }
    public void setInstalled(Context context, boolean installed, String currentVersion){
        appInfoBean.setInstalled(installed);
        appInfoBean.setCurrentVersion(currentVersion);
        insertOrUpdate(context);
    }

    public void setMCerebrumSupported(Context context, boolean mCerebrumSupported) {
        appInfoBean.setMcerebrumSupported(mCerebrumSupported);
        insertOrUpdate(context);
    }
    public boolean getMCerebrumSupported(){
        return appInfoBean.getMcerebrumSupported();
    }
    public boolean getInitialized(){
        return appInfoBean.getInitialized();
    }
    public void setInitialized(Context context, boolean initialized) {
        appInfoBean.setInitialized(initialized);
        insertOrUpdate(context);
    }

}
