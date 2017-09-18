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

import org.md2k.mcerebrum.core.access.MCerebrumStatus;

public class AppInfo implements Parcelable{
    public static final String USE_AS_REQUIRED="REQUIRED";
    public static final String USE_AS_OPTIONAL="OPTIONAL";
    public static final String USE_AS_NOT_IN_USE="NOT_IN_USE";

    public static final String TYPE_STUDY="STUDY";
    public static final String TYPE_MCEREBRUM="MCEREBRUM";
    public static final String TYPE_DATAKIT="DATAKIT";

    private AppBasicInfo appBasicInfo;
    private InstallInfo installInfo;
    private MCerebrumStatus mCerebrumStatus;

    public AppInfo(AppBasicInfo appBasicInfo, InstallInfo installInfo, MCerebrumStatus mCerebrumStatus) {
        this.appBasicInfo = appBasicInfo;
        this.installInfo = installInfo;
        this.mCerebrumStatus = mCerebrumStatus;
    }

    protected AppInfo(Parcel in) {
        mCerebrumStatus = in.readParcelable(MCerebrumStatus.class.getClassLoader());
    }

    public static final Creator<AppInfo> CREATOR = new Creator<AppInfo>() {
        @Override
        public AppInfo createFromParcel(Parcel in) {
            return new AppInfo(in);
        }

        @Override
        public AppInfo[] newArray(int size) {
            return new AppInfo[size];
        }
    };

    public AppBasicInfo getAppBasicInfo() {
        return appBasicInfo;
    }

    public InstallInfo getInstallInfo() {
        return installInfo;
    }

    public MCerebrumStatus getmCerebrumStatus() {
        return mCerebrumStatus;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(mCerebrumStatus, flags);
    }
}
