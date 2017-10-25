package org.md2k.mcerebrum.core.access.configinfo;
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

import org.md2k.mcerebrum.core.access.SampleProviderSQLiteOpenHelper;
import org.md2k.mcerebrum.core.access.configinfo.ConfigInfoBean;
import org.md2k.mcerebrum.core.access.configinfo.ConfigInfoColumns;
import org.md2k.mcerebrum.core.access.configinfo.ConfigInfoContentValues;
import org.md2k.mcerebrum.core.access.configinfo.ConfigInfoCursor;
import org.md2k.mcerebrum.core.access.configinfo.ConfigInfoSelection;

public class ConfigCP {
    public static void set(Context context, String cid, String type, String title, String summary, String description, String version, String update, String expectedVersion, String downloadLink, String fileName) {
        ConfigInfoBean configInfoBean=read(context);
        if(configInfoBean==null) configInfoBean=new ConfigInfoBean();
        configInfoBean.setCid(cid);
        configInfoBean.setType(type);
        configInfoBean.setTitle(title);
        configInfoBean.setSummary(summary);
        configInfoBean.setDescription(description);
        configInfoBean.setVersions(version);
        configInfoBean.setUpdates(update);
        configInfoBean.setExpectedVersion(expectedVersion);
        configInfoBean.setDownloadLink(downloadLink);
        insertOrUpdate(context, configInfoBean);
    }

    public static void deleteTable(Context context) {
        try {
            SampleProviderSQLiteOpenHelper s = SampleProviderSQLiteOpenHelper.getInstance(context);
            SQLiteDatabase db = s.getWritableDatabase();
            db.execSQL("DROP TABLE IF EXISTS " + ConfigInfoColumns.TABLE_NAME);
            db.execSQL(SampleProviderSQLiteOpenHelper.SQL_CREATE_TABLE_CONFIG_INFO);
        }catch (Exception e){

        }
    }

    private static void insertOrUpdate(Context context, ConfigInfoBean configInfoBean) {
        try {
            ConfigInfoContentValues values = prepare(configInfoBean);
            if (isEmpty(context))
                values.insert(context);
            else
                values.update(context, new ConfigInfoSelection().cid(configInfoBean.getCid()));
        }catch (Exception e){
            deleteTable(context);
            ConfigInfoContentValues values = prepare(configInfoBean);
            values.insert(context);
        }
    }

    private static ConfigInfoBean read(Context context) {
        ConfigInfoBean configInfoBean=null;
        try {
            ConfigInfoSelection configInfoSelection = new ConfigInfoSelection();
            ConfigInfoCursor c = configInfoSelection.query(context);
            if (c.moveToNext())
                configInfoBean =  ConfigInfoBean.newInstance(c.getId(),c.getCid(),c.getType(),c.getTitle(),c.getSummary(),c.getDescription(),c.getVersions(),c.getUpdates(),c.getExpectedVersion(),c.getLatestVersion(),c.getDownloadFrom(),c.getDownloadLink());
            c.close();
        }catch (Exception ignored){
        }
        return configInfoBean;
    }

    private static boolean isEmpty(Context context) {
        try {
            int count = 0;
            ConfigInfoSelection configInfoSelection = new ConfigInfoSelection();
            ConfigInfoCursor c = configInfoSelection.query(context);
            while (c.moveToNext()) {
                count++;
            }
            c.close();
            return count == 0;
        }catch (Exception e){
            return false;
        }
    }

    private static ConfigInfoContentValues prepare(ConfigInfoBean configInfoBean) {
        ConfigInfoContentValues values = new ConfigInfoContentValues();
        values.putCid(configInfoBean.getCid());
        values.putType(configInfoBean.getType());
        values.putTitle(configInfoBean.getTitle());
        values.putSummary(configInfoBean.getSummary());
        values.putDescription(configInfoBean.getDescription());
        values.putVersions(configInfoBean.getVersions());
        values.putUpdates(configInfoBean.getUpdates());
        values.putExpectedVersion(configInfoBean.getExpectedVersion());
        values.putLatestVersion(configInfoBean.getLatestVersion());
        values.putDownloadLink(configInfoBean.getDownloadLink());
        values.putDownloadFrom(configInfoBean.getDownloadFrom());
        return values;
    }


    public void setLatestVersion(Context context, String latestVersion) {
        ConfigInfoBean configInfoBean=read(context);
        if(configInfoBean==null) return;
        if(configInfoBean.getLatestVersion()!=null && configInfoBean.getLatestVersion().equals(latestVersion)) return ;
        configInfoBean.setLatestVersion(latestVersion);
        insertOrUpdate(context, configInfoBean);
    }
    public static void setDownloadFrom(Context context, String downloadFrom) {
        ConfigInfoBean configInfoBean=read(context);
        if(configInfoBean==null) return;
        if(configInfoBean.getDownloadFrom()!=null && configInfoBean.getDownloadFrom().equals(downloadFrom)) return ;
        configInfoBean.setDownloadFrom(downloadFrom);
        insertOrUpdate(context, configInfoBean);
    }


    public static String getCid(Context context) {
        ConfigInfoBean configInfoBean=read(context);
        if(configInfoBean==null) return null;
        return configInfoBean.getCid();
    }
    public static String getType(Context context) {
        ConfigInfoBean configInfoBean=read(context);
        if(configInfoBean==null) return null;
        return configInfoBean.getType();
    }
    public static String getTitle(Context context) {
        ConfigInfoBean configInfoBean=read(context);
        if(configInfoBean==null) return null;
        return configInfoBean.getType();
    }
    public static String getSummary(Context context) {
        ConfigInfoBean configInfoBean=read(context);
        if(configInfoBean==null) return null;
        return configInfoBean.getSummary();
    }
    public static String getDescription(Context context) {
        ConfigInfoBean configInfoBean=read(context);
        if(configInfoBean==null) return null;
        return configInfoBean.getDescription();
    }
    public static String getVersion(Context context) {
        ConfigInfoBean configInfoBean=read(context);
        if(configInfoBean==null) return null;
        return configInfoBean.getVersions();
    }
    public static String getUpdate(Context context) {
        ConfigInfoBean configInfoBean=read(context);
        if(configInfoBean==null) return null;
        return configInfoBean.getUpdates();
    }
    public static String getExpectedVersion(Context context) {
        ConfigInfoBean configInfoBean=read(context);
        if(configInfoBean==null) return null;
        return configInfoBean.getExpectedVersion();
    }
    public static String getLatestVersion(Context context) {
        ConfigInfoBean configInfoBean=read(context);
        if(configInfoBean==null) return null;
        return configInfoBean.getLatestVersion();
    }
    public static String getDownloadFrom(Context context) {
        ConfigInfoBean configInfoBean=read(context);
        if(configInfoBean==null) return null;
        return configInfoBean.getDownloadFrom();
    }
    public static String getDownloadLink(Context context) {
        ConfigInfoBean configInfoBean=read(context);
        if(configInfoBean==null) return null;
        return configInfoBean.getDownloadLink();
    }
}
