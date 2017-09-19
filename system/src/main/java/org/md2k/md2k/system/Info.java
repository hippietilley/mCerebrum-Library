package org.md2k.md2k.system;
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

import org.md2k.md2k.system.app.AppInfo;
import org.md2k.md2k.system.study.StudyInfo;
import org.md2k.md2k.system.user.UserInfo;

public class Info implements Parcelable{
    private UserInfo userInfo;
    private StudyInfo studyInfo;
    private AppInfo[] appInfo;

    public Info(UserInfo userInfo, StudyInfo studyInfo, AppInfo[] appInfo) {
        this.userInfo = userInfo;
        this.studyInfo = studyInfo;
        this.appInfo = appInfo;
    }

    protected Info(Parcel in) {
        userInfo = in.readParcelable(UserInfo.class.getClassLoader());
        studyInfo = in.readParcelable(StudyInfo.class.getClassLoader());
        appInfo = in.createTypedArray(AppInfo.CREATOR);
    }

    public static final Creator<Info> CREATOR = new Creator<Info>() {
        @Override
        public Info createFromParcel(Parcel in) {
            return new Info(in);
        }

        @Override
        public Info[] newArray(int size) {
            return new Info[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(userInfo, flags);
        dest.writeParcelable(studyInfo, flags);
        dest.writeTypedArray(appInfo, flags);
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public StudyInfo getStudyInfo() {
        return studyInfo;
    }

    public AppInfo[] getAppInfo() {
        return appInfo;
    }
}
