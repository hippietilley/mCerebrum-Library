package org.md2k.mcerebrum.core.access;
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

public class MCerebrumStatus implements Parcelable{
    private String packageName;
    private boolean configurable;
    private boolean configured;
    private boolean running;
    private long runningTime;
    private boolean runInBackground;
    private boolean report;
    private boolean clear;
    private boolean initialize;
    private boolean equalDefault;
    public MCerebrumStatus(){
        packageName=null;configurable=false;configured=false;running=false;runningTime=-1;runInBackground=false;report=false;clear=false;initialize=false;equalDefault=false;
    }

    protected MCerebrumStatus(Parcel in) {
        packageName = in.readString();
        configurable = in.readByte() != 0;
        configured = in.readByte() != 0;
        running = in.readByte() != 0;
        runningTime = in.readLong();
        runInBackground = in.readByte() != 0;
        report = in.readByte() != 0;
        clear = in.readByte() != 0;
        initialize = in.readByte() != 0;
        equalDefault = in.readByte() != 0;
    }

    public static final Creator<MCerebrumStatus> CREATOR = new Creator<MCerebrumStatus>() {
        @Override
        public MCerebrumStatus createFromParcel(Parcel in) {
            return new MCerebrumStatus(in);
        }

        @Override
        public MCerebrumStatus[] newArray(int size) {
            return new MCerebrumStatus[size];
        }
    };

    public MCerebrumStatus(String packageName, boolean configurable, boolean configured, boolean running, long runningTime, boolean runInBackground, boolean report, boolean clear, boolean initialize, boolean equalDefault) {
        this.packageName=packageName;
        this.configurable=configurable;
        this.configured=configured;
        this.running=running;
        this.runningTime=runningTime;
        this.runInBackground=runInBackground;
        this.report=report;
        this.clear=clear;
        this.initialize=initialize;
        this.equalDefault=equalDefault;
    }

    public boolean isConfigurable() {
        return configurable;
    }

    public boolean isConfigured() {
        return configured;
    }

    public boolean isRunning() {
        return running;
    }

    public long getRunningTime() {
        return runningTime;
    }

    public boolean isRunInBackground() {
        return runInBackground;
    }

    public boolean isReport() {
        return report;
    }

    public boolean hasClear() {
        return clear;
    }

    public boolean isInitialize() {
        return initialize;
    }

    public boolean isEqualDefault() {
        return equalDefault;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(packageName);
        dest.writeByte((byte) (configurable ? 1 : 0));
        dest.writeByte((byte) (configured ? 1 : 0));
        dest.writeByte((byte) (running ? 1 : 0));
        dest.writeLong(runningTime);
        dest.writeByte((byte) (runInBackground ? 1 : 0));
        dest.writeByte((byte) (report ? 1 : 0));
        dest.writeByte((byte) (clear ? 1 : 0));
        dest.writeByte((byte) (initialize ? 1 : 0));
        dest.writeByte((byte) (equalDefault ? 1 : 0));
    }
}
