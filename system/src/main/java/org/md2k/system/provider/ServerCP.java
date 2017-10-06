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

import org.md2k.system.provider.serverinfo.ServerInfoBean;
import org.md2k.system.provider.serverinfo.ServerInfoContentValues;
import org.md2k.system.provider.serverinfo.ServerInfoCursor;
import org.md2k.system.provider.serverinfo.ServerInfoSelection;

public class ServerCP {
    private ServerInfoBean serverInfoBean;

    public ServerCP() {
        serverInfoBean = new ServerInfoBean();
    }

    public void delete(Context context) {
        ServerInfoSelection serverInfoSelection = new ServerInfoSelection();
        serverInfoSelection.delete(context);
    }

    public void insertOrUpdate(Context context) {
        ServerInfoContentValues values = prepare();
        if (isEmpty(context))
            values.insert(context);
        else
            values.update(context, new ServerInfoSelection().id(serverInfoBean.getId()));
    }

    public boolean read(Context context) {
        try {
            ServerInfoSelection serverInfoSelection = new ServerInfoSelection();
            ServerInfoCursor c = serverInfoSelection.query(context);
            if (c.moveToNext()) {
                set(c);
                c.close();
                return true;
            } else {
                c.close();
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    public void set(ServerInfoCursor serverInfoCursor) {
        serverInfoBean.setId(serverInfoCursor.getId());
        serverInfoBean.setServerAddress(serverInfoCursor.getServerAddress());
        serverInfoBean.setUsername(serverInfoCursor.getUsername());
        serverInfoBean.setPasswordHash(serverInfoCursor.getPasswordHash());
        serverInfoBean.setToken(serverInfoCursor.getToken());
        serverInfoBean.setFileName(serverInfoCursor.getFileName());
        serverInfoBean.setCurrentVersion(serverInfoCursor.getCurrentVersion());
        serverInfoBean.setLatestVersion(serverInfoCursor.getLatestVersion());
    }

    public boolean isEmpty(Context context) {
        int count = 0;
        ServerInfoSelection serverInfoSelection = new ServerInfoSelection();
        ServerInfoCursor c = serverInfoSelection.query(context);
        while (c.moveToNext()) {
            count++;
        }
        c.close();
        return count == 0;
    }


    private ServerInfoContentValues prepare() {
        ServerInfoContentValues values = new ServerInfoContentValues();
        values.putServerAddress(serverInfoBean.getServerAddress());
        values.putUsername(serverInfoBean.getUsername());
        values.putPasswordHash(serverInfoBean.getPasswordHash());
        values.putToken(serverInfoBean.getToken());
        values.putFileName(serverInfoBean.getFileName());
        values.putCurrentVersion(serverInfoBean.getCurrentVersion());
        values.putLatestVersion(serverInfoBean.getLatestVersion());
        return values;
    }

    public String getPasswordHash() {
        return serverInfoBean.getPasswordHash();
    }

    public String getToken() {
        return serverInfoBean.getToken();
    }

    public String getUserName() {
        return serverInfoBean.getUsername();
    }

    public String getServerAddress() {
        return serverInfoBean.getServerAddress();
    }

    public void set(Context context, String serverName, String userName, String uuid, String password, String token, String fileName, String currentVersion, String latestVersion) {
        serverInfoBean.setServerAddress(serverName);
        serverInfoBean.setUsername(userName);
        serverInfoBean.setUuid(uuid);
        serverInfoBean.setPasswordHash(password);
        serverInfoBean.setToken(token);
        serverInfoBean.setFileName(fileName);
        serverInfoBean.setCurrentVersion(currentVersion);
        serverInfoBean.setLatestVersion(latestVersion);
        insertOrUpdate(context);
    }

    public String getCurrentVersion() {
        return serverInfoBean.getCurrentVersion();
    }

    public void setLatestVersion(Context context, String version) {
        serverInfoBean.setLatestVersion(version);
        insertOrUpdate(context);
    }

    public String getFileName() {
        return serverInfoBean.getFileName();
    }

    public void setCurrentVersion(Context context, String lastModified) {
        serverInfoBean.setCurrentVersion(lastModified);
        insertOrUpdate(context);
    }
}
