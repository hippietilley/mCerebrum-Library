package org.md2k.md2k.system.study;
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

import java.io.Serializable;

public class StudyInfo implements Parcelable {
    private String id;
    private String type;
    private String title;
    private String summary;
    private String description;
    private String icon;
    private String coverImage;
    private String version;
    private String download_link;
    private boolean startAtBoot;

    public static final String FREEBIE="FREEBIE";
    public static final String SERVER="SERVER";
    public static final String CONFIGURED="CONFIGURED";

    public StudyInfo(){}

    protected StudyInfo(Parcel in) {
        id = in.readString();
        type = in.readString();
        title = in.readString();
        summary = in.readString();
        description = in.readString();
        icon = in.readString();
        coverImage = in.readString();
        version = in.readString();
        download_link = in.readString();
        startAtBoot = in.readByte() != 0;
    }

    public static final Creator<StudyInfo> CREATOR = new Creator<StudyInfo>() {
        @Override
        public StudyInfo createFromParcel(Parcel in) {
            return new StudyInfo(in);
        }

        @Override
        public StudyInfo[] newArray(int size) {
            return new StudyInfo[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public String getVersion() {
        return version;
    }

    public boolean isStartAtBoot() {
        return startAtBoot;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setStartAtBoot(boolean startAtBoot) {
        this.startAtBoot = startAtBoot;
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
        dest.writeString(icon);
        dest.writeString(coverImage);
        dest.writeString(version);
        dest.writeString(download_link);
        dest.writeByte((byte) (startAtBoot ? 1 : 0));
    }
}
