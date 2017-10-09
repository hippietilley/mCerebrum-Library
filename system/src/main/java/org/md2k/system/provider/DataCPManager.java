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
import android.database.sqlite.SQLiteDatabase;

import org.md2k.system.provider.appinfo.AppInfoColumns;
import org.md2k.system.provider.appinfo.AppInfoCursor;
import org.md2k.system.provider.appinfo.AppInfoSelection;

import java.util.ArrayList;

public class DataCPManager {
    private Context context;
    private ConfigCP configCP;
    private StudyCP studyCP;
    private UserCP userCP;
    private ServerCP serverCP;
    private ArrayList<AppCP> appCPs;
    public DataCPManager(Context context){
        this.context = context;
        configCP =new ConfigCP();
        studyCP =new StudyCP();
        userCP=new UserCP();
        serverCP=new ServerCP();
        appCPs=new ArrayList<>();
        read();
    }
    private void read(){
        configCP.read(context);
        studyCP.read(context);
        userCP.read(context);
        serverCP.read(context);
        readApp();
    }
    private void deleteConfigCP(){
        configCP.delete(context);
        configCP=new ConfigCP();
    }
    private void deleteStudyCP(){
        studyCP.delete(context);
        studyCP=new StudyCP();
    }
    private void deleteUserCP(){
        userCP.delete(context);
        userCP=new UserCP();
    }
    private void deleteServerCP(){
        serverCP.delete(context);
        serverCP=new ServerCP();
    }
    private void deleteAppCP(){
        SampleProviderSQLiteOpenHelper s= SampleProviderSQLiteOpenHelper.getInstance(context);
        SQLiteDatabase db=s.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+ AppInfoColumns.TABLE_NAME);
        db.execSQL(SampleProviderSQLiteOpenHelper.SQL_CREATE_TABLE_APP_INFO);
        appCPs.clear();
    }
    public void deleteAll(){
        deleteConfigCP();
        deleteStudyCP();
        deleteAppCP();
        deleteUserCP();
        deleteServerCP();
    }
    public void deleteForUpdate(){
        deleteConfigCP();
        deleteStudyCP();
        deleteAppCP();
    }

    public boolean isNew(String id, String type) {
        if(configCP.getConfigInfoBean().getCid()==null) return true;
        if(configCP.getConfigInfoBean().getType()==null) return true;
        if(!configCP.getConfigInfoBean().getCid().equals(id)) return true;
        if(!configCP.getConfigInfoBean().getType().equals(type)) return true;
        return false;
    }

    public void setConfigCP(String cid, String type, String title, String summary, String description, String version, String update, String expectedVersion, String downloadLink, String fileName){
        configCP.set(context, cid,  type,  title,  summary,  description,  version,  update,  expectedVersion,  downloadLink, fileName);
    }
    public void setStudyCP(String sid, String type, String title, String summary, String description, String version,String icon, String coverImage, boolean startAtBoot){
        studyCP.set( context, sid,  type,  title,  summary,  description,  version,  icon,  coverImage,  startAtBoot);
    }

    public void setAppCPs(String aid, String type, String title, String summary, String description, String packageName, String downloadLink, String update, String useAs, String expectedVersion, String icon){
        AppCP appCP = getApp(packageName);
        if(appCP==null) {
            appCP = new AppCP();
            appCPs.add(appCP);
        }
        appCP.set(context, aid, type, title, summary, description, packageName, downloadLink, update, useAs, expectedVersion, icon);
    }


    public ConfigCP getConfigCP() {
        return configCP;
    }

    public StudyCP getStudyCP() {
        return studyCP;
    }

    public UserCP getUserCP() {
        return userCP;
    }
    public ServerCP getServerCP() {
        return serverCP;
    }

    public ArrayList<AppCP> getAppCPs() {
        return appCPs;
    }
    private void readApp() {
        try {
            AppInfoSelection appInfoSelection = new AppInfoSelection();
            AppInfoCursor c = appInfoSelection.query(context);
            appCPs.clear();
            while (c.moveToNext()) {
                AppCP appCP = new AppCP();
                appCP.setFromCP(c);
                appCPs.add(appCP);
            }
            c.close();
        }catch (Exception e){

        }
    }
    private AppCP getApp(String packageName){
        for(int i=0;i<appCPs.size();i++)
            if(appCPs.get(i).getPackageName().equals(packageName))
                return appCPs.get(i);
        return null;
    }
}
