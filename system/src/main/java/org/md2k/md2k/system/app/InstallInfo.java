package org.md2k.md2k.system.app;
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

import android.os.Parcel;
import android.os.Parcelable;

public class InstallInfo implements Parcelable{
    private String downloadLink;
    private String expectedVersion;
    private String updateOption;
    private String updateVersionName;
    private String currentVersionName;
    private int currentVersionCode;
    private boolean installed;
    public InstallInfo(){
        downloadLink=null;downloadLink=null;expectedVersion=null;updateOption=null;updateVersionName=null;currentVersionCode=-1;currentVersionName=null;
    }


    protected InstallInfo(Parcel in) {
        downloadLink = in.readString();
        expectedVersion = in.readString();
        updateOption = in.readString();
        updateVersionName = in.readString();
        currentVersionName = in.readString();
        currentVersionCode = in.readInt();
        installed = in.readByte() != 0;
    }

    public static final Creator<InstallInfo> CREATOR = new Creator<InstallInfo>() {
        @Override
        public InstallInfo createFromParcel(Parcel in) {
            return new InstallInfo(in);
        }

        @Override
        public InstallInfo[] newArray(int size) {
            return new InstallInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(downloadLink);
        dest.writeString(expectedVersion);
        dest.writeString(updateOption);
        dest.writeString(updateVersionName);
        dest.writeString(currentVersionName);
        dest.writeInt(currentVersionCode);
        dest.writeByte((byte) (installed ? 1 : 0));
    }

    public enum TYPE_DOWNLOAD {
        GITHUB, PLAYSTORE, URL, JSON, UNKNOWN
    };
    public TYPE_DOWNLOAD getDownloadType(){
        if(downloadLink==null) return TYPE_DOWNLOAD.UNKNOWN;
        if(downloadLink.toLowerCase().startsWith("market://"))
            return TYPE_DOWNLOAD.PLAYSTORE;
        if(downloadLink.toLowerCase().endsWith(".json"))
            return TYPE_DOWNLOAD.JSON;
        if(downloadLink.toLowerCase().endsWith(".apk"))
            return TYPE_DOWNLOAD.URL;
        if(downloadLink.split("/").length==2) return TYPE_DOWNLOAD.GITHUB;
        return TYPE_DOWNLOAD.UNKNOWN;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    public String getExpectedVersion() {
        return expectedVersion;
    }

    public void setExpectedVersion(String expectedVersion) {
        this.expectedVersion = expectedVersion;
    }

    public String getUpdateOption() {
        return updateOption;
    }

    public void setUpdateOption(String updateOption) {
        this.updateOption = updateOption;
    }

    public String getUpdateVersionName() {
        return updateVersionName;
    }

    public void setUpdateVersionName(String updateVersionName) {
        this.updateVersionName = updateVersionName;
    }

    public String getCurrentVersionName() {
        return currentVersionName;
    }

    public void setCurrentVersionName(String currentVersionName) {
        this.currentVersionName = currentVersionName;
    }

    public int getCurrentVersionCode() {
        return currentVersionCode;
    }

    public void setCurrentVersionCode(int currentVersionCode) {
        this.currentVersionCode = currentVersionCode;
    }

    public boolean isInstalled() {
        return installed;
    }

    public void setInstalled(boolean installed) {
        this.installed = installed;
    }
}
