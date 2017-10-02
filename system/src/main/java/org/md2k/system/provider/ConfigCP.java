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

import org.md2k.system.provider.configinfo.ConfigInfoBean;
import org.md2k.system.provider.configinfo.ConfigInfoContentValues;
import org.md2k.system.provider.configinfo.ConfigInfoCursor;
import org.md2k.system.provider.configinfo.ConfigInfoSelection;

public class ConfigCP {
    private ConfigInfoBean configInfoBean;

    public ConfigCP() {
        configInfoBean = new ConfigInfoBean();
    }

    public void set(Context context, String cid, String type, String title, String summary, String description, String version, String update, String expectedVersion, String latestVersion, String downloadLink, long lastUpdated) {
        configInfoBean.setCid(cid);
        configInfoBean.setType(type);
        configInfoBean.setTitle(title);
        configInfoBean.setSummary(summary);
        configInfoBean.setDescription(description);
        configInfoBean.setVersions(version);
        configInfoBean.setUpdates(update);
        configInfoBean.setExpectedVersion(expectedVersion);
        configInfoBean.setLatestVersion(latestVersion);
        configInfoBean.setDownloadLink(downloadLink);
        configInfoBean.setLastUpdated(lastUpdated);
        insertOrUpdate(context);
    }

    public void delete(Context context) {
        ConfigInfoSelection configInfoSelection = new ConfigInfoSelection();
        configInfoSelection.delete(context);
    }

    public void insertOrUpdate(Context context) {
        ConfigInfoContentValues values = prepare();
        if (isEmpty(context))
            values.insert(context);
        else
            values.update(context, new ConfigInfoSelection().cid(configInfoBean.getCid()));
    }

    public boolean read(Context context) {
        try {
            ConfigInfoSelection configInfoSelection = new ConfigInfoSelection();
            ConfigInfoCursor c = configInfoSelection.query(context);
            if (c.moveToNext()) {
                setFromCP(c);
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

    private void setFromCP(ConfigInfoCursor configInfoCursor) {
        configInfoBean.setCid(configInfoCursor.getCid());
        configInfoBean.setType(configInfoCursor.getType());
        configInfoBean.setTitle(configInfoCursor.getTitle());
        configInfoBean.setSummary(configInfoCursor.getSummary());
        configInfoBean.setDescription(configInfoCursor.getDescription());
        configInfoBean.setVersions(configInfoCursor.getVersions());
        configInfoBean.setUpdates(configInfoCursor.getUpdates());
        configInfoBean.setExpectedVersion(configInfoCursor.getExpectedVersion());
        configInfoBean.setLatestVersion(configInfoCursor.getLatestVersion());
        configInfoBean.setDownloadLink(configInfoCursor.getDownloadLink());
        configInfoBean.setLastUpdated(configInfoCursor.getLastUpdated());
    }

    public boolean isEmpty(Context context) {
        int count = 0;
        ConfigInfoSelection configInfoSelection = new ConfigInfoSelection();
        ConfigInfoCursor c = configInfoSelection.query(context);
        while (c.moveToNext()) {
            count++;
        }
        c.close();
        return count == 0;
    }

    private ConfigInfoContentValues prepare() {
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
        values.putLastUpdated(configInfoBean.getLastUpdated());
        return values;
    }

    public ConfigInfoBean getConfigInfoBean() {
        return configInfoBean;
    }

    public String getType() {
        return configInfoBean.getType();
    }

    public void setLatestVersion(Context context, String o) {
        configInfoBean.setLatestVersion(o);
        insertOrUpdate(context);
    }

    public void setDownloadLink(Context context, String server) {
        configInfoBean.setDownloadLink(server);
        insertOrUpdate(context);
    }

    public String getDownloadLink() {
        return configInfoBean.getDownloadLink();
    }

    public void set(ConfigInfoCursor c) {
        configInfoBean.setId(c.getId());
        configInfoBean.setCid(c.getCid());
        configInfoBean.setType(c.getType());
        configInfoBean.setExpectedVersion(c.getExpectedVersion());
        configInfoBean.setUpdates(c.getUpdates());
        configInfoBean.setVersions(c.getVersions());
        configInfoBean.setTitle(c.getTitle());
        configInfoBean.setSummary(c.getSummary());
        configInfoBean.setDescription(c.getDescription());
        configInfoBean.setLatestVersion(c.getLatestVersion());
        configInfoBean.setDownloadLink(c.getDownloadLink());
        configInfoBean.setLastUpdated(c.getLastUpdated());
    }
}
