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

public class AppBasicInfo implements Parcelable{
    public static final String USE_AS_REQUIRED = "REQUIRED";
    public static final String USE_AS_OPTIONAL = "OPTIONAL";
    public static final String USE_AS_NOT_IN_USE = "NOT_IN_USE";
    private String id;
    private String type;
    private String title;
    private String summary;
    private String description;
    private String packageName;
    private String icon;
    private String useAs;
    public AppBasicInfo(){
        id=null;type=null;title=null;summary=null;description=null;packageName=null;icon=null;useAs=null;
    }

    protected AppBasicInfo(Parcel in) {
        id = in.readString();
        type = in.readString();
        title = in.readString();
        summary = in.readString();
        description = in.readString();
        packageName = in.readString();
        icon = in.readString();
        useAs = in.readString();
    }

    public static final Creator<AppBasicInfo> CREATOR = new Creator<AppBasicInfo>() {
        @Override
        public AppBasicInfo createFromParcel(Parcel in) {
            return new AppBasicInfo(in);
        }

        @Override
        public AppBasicInfo[] newArray(int size) {
            return new AppBasicInfo[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUseAs() {
        return useAs;
    }

    public void setUseAs(String useAs) {
        this.useAs = useAs;
    }
    public boolean isUseAs(String u){
        if(useAs==null) useAs=USE_AS_OPTIONAL;
        return u.equalsIgnoreCase(useAs);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(type);
        dest.writeString(title);
        dest.writeString(summary);
        dest.writeString(description);
        dest.writeString(packageName);
        dest.writeString(icon);
        dest.writeString(useAs);
    }
}
