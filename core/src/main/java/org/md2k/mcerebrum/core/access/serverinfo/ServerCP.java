package org.md2k.mcerebrum.core.access.serverinfo;
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
import org.md2k.mcerebrum.core.access.serverinfo.ServerInfoBean;
import org.md2k.mcerebrum.core.access.serverinfo.ServerInfoColumns;
import org.md2k.mcerebrum.core.access.serverinfo.ServerInfoContentValues;
import org.md2k.mcerebrum.core.access.serverinfo.ServerInfoCursor;
import org.md2k.mcerebrum.core.access.serverinfo.ServerInfoSelection;

public class ServerCP {

    private static void insertOrUpdate(Context context, ServerInfoBean serverInfoBean) {
        try {
            ServerInfoContentValues values = prepare(serverInfoBean);
            if (isEmpty(context))
                values.insert(context);
            else values.update(context, new ServerInfoSelection().id(serverInfoBean.getId()));
        }catch (Exception e){
            deleteTable(context);
            ServerInfoContentValues values = prepare(serverInfoBean);
            values.insert(context);
        }
    }

    public static void deleteTable(Context context) {
        SampleProviderSQLiteOpenHelper s = SampleProviderSQLiteOpenHelper.getInstance(context);
        try {
            SQLiteDatabase db = s.getWritableDatabase();
            db.execSQL("DROP TABLE IF EXISTS " + ServerInfoColumns.TABLE_NAME);
        }catch (Exception e){

        }
        try{
            SQLiteDatabase db = s.getWritableDatabase();
            db.execSQL(SampleProviderSQLiteOpenHelper.SQL_CREATE_TABLE_SERVER_INFO);
        }catch (Exception e){

        }
    }

    private static boolean isEmpty(Context context) {
        int count = 0;
        ServerInfoSelection serverInfoSelection = new ServerInfoSelection();
        ServerInfoCursor c = serverInfoSelection.query(context);
        while (c.moveToNext()) {
            count++;
        }
        c.close();
        return count == 0;
    }

    private static ServerInfoContentValues prepare(ServerInfoBean serverInfoBean) {
        ServerInfoContentValues values = new ServerInfoContentValues();
        values.putServerAddress(serverInfoBean.getServerAddress());
        values.putUsername(serverInfoBean.getUsername());
        values.putUuid(serverInfoBean.getUuid());
        values.putPasswordHash(serverInfoBean.getPasswordHash());
        values.putToken(serverInfoBean.getToken());
        values.putFileName(serverInfoBean.getFileName());
        values.putCurrentVersion(serverInfoBean.getCurrentVersion());
        values.putLatestVersion(serverInfoBean.getLatestVersion());
        return values;
    }

    public static ServerInfoBean read(Context context) {
        ServerInfoBean serverInfoBean = null;
        try {
            ServerInfoSelection serverInfoSelection = new ServerInfoSelection();
            ServerInfoCursor c = serverInfoSelection.query(context);
            if (c.moveToNext())
                serverInfoBean = ServerInfoBean.newInstance(c.getId(), c.getServerAddress(), c.getUsername(), c.getUuid(), c.getPasswordHash(), c.getToken(), c.getFileName(), c.getCurrentVersion(), c.getLatestVersion());
            c.close();
        } catch (Exception ignored) {
        }
        return serverInfoBean;
    }

    public static String getServerAddress(Context context) {
        ServerInfoBean serverInfoBean = read(context);
        if (serverInfoBean == null) return null;
        return serverInfoBean.getServerAddress();
    }
    public static String getUserName(Context context) {
        ServerInfoBean serverInfoBean = read(context);
        if (serverInfoBean == null) return null;
        return serverInfoBean.getUsername();
    }
    public static String getUuid(Context context) {
        ServerInfoBean serverInfoBean = read(context);
        if (serverInfoBean == null) return null;
        return serverInfoBean.getUuid();
    }

    public static String getPasswordHash(Context context) {
        ServerInfoBean serverInfoBean = read(context);
        if (serverInfoBean == null) return null;
        return serverInfoBean.getPasswordHash();
    }

    public static String getToken(Context context) {
        ServerInfoBean serverInfoBean = read(context);
        if (serverInfoBean == null) return null;
        return serverInfoBean.getToken();
    }
    public static String getFileName(Context context) {
        ServerInfoBean serverInfoBean = read(context);
        if (serverInfoBean == null) return null;
        return serverInfoBean.getFileName();
    }

    public static String getCurrentVersion(Context context) {
        ServerInfoBean serverInfoBean = read(context);
        if (serverInfoBean == null) return null;
        return serverInfoBean.getCurrentVersion();
    }
    public static String getLatestVersion(Context context) {
        ServerInfoBean serverInfoBean = read(context);
        if (serverInfoBean == null) return null;
        return serverInfoBean.getLatestVersion();
    }

    public static void set(Context context, String serverName, String userName, String uuid, String password, String token, String fileName, String currentVersion, String latestVersion) {
        ServerInfoBean serverInfoBean = read(context);
        if (serverInfoBean == null) serverInfoBean = new ServerInfoBean();
        serverInfoBean.setServerAddress(serverName);
        serverInfoBean.setUsername(userName);
        serverInfoBean.setUuid(uuid);
        serverInfoBean.setPasswordHash(password);
        serverInfoBean.setToken(token);
        serverInfoBean.setFileName(fileName);
        serverInfoBean.setCurrentVersion(currentVersion);
        serverInfoBean.setLatestVersion(latestVersion);
        insertOrUpdate(context, serverInfoBean);
    }


    public static void setLatestVersion(Context context, String version) {
        ServerInfoBean serverInfoBean = read(context);
        if (serverInfoBean == null) return;
        if(serverInfoBean.getLatestVersion()!=null && serverInfoBean.getLatestVersion().equals(version)) return;
        serverInfoBean.setLatestVersion(version);
        insertOrUpdate(context, serverInfoBean);
    }

    public static void setCurrentVersion(Context context, String currentVersion) {
        ServerInfoBean serverInfoBean = read(context);
        if (serverInfoBean == null) return;
        if(serverInfoBean.getCurrentVersion()!=null && serverInfoBean.getCurrentVersion().equals(currentVersion)) return;
        serverInfoBean.setCurrentVersion(currentVersion);
        insertOrUpdate(context, serverInfoBean);
    }

    public static boolean hasUpdate(Context context) {
        String l=getLatestVersion(context);
        String c=getCurrentVersion(context);
        if(c==null || l==null) return false;
        if(c.equalsIgnoreCase(l)) return false;
        return true;
    }
}
