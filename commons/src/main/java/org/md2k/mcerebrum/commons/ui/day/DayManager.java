/*
 * Copyright (c) 2018, The University of Memphis, MD2K Center of Excellence
 *
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

package org.md2k.mcerebrum.commons.ui.day;

import android.content.Context;

import com.google.gson.Gson;

import org.md2k.datakitapi.DataKitAPI;
import org.md2k.datakitapi.datatype.DataType;
import org.md2k.datakitapi.datatype.DataTypeJSONObject;
import org.md2k.datakitapi.datatype.DataTypeLong;
import org.md2k.datakitapi.datatype.DataTypeLongArray;
import org.md2k.datakitapi.exception.DataKitException;
import org.md2k.datakitapi.source.datasource.DataSourceBuilder;
import org.md2k.datakitapi.source.datasource.DataSourceClient;
import org.md2k.datakitapi.source.datasource.DataSourceType;
import org.md2k.datakitapi.time.DateTime;
import org.md2k.mcerebrum.core.data_format.privacy.PrivacyData;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 */
class DayManager {
    private long dayStarted;
    private long dayEnded;
    private long[] wakeupTime;
    private long[] sleepTime;

    /**
     * Constructor
     */
    DayManager() {
        dayStarted = -1;
        dayEnded = -1;
        wakeupTime = null;
        sleepTime = null;
    }

    /**
     * @param context
     */
    public void set(Context context) {
        sleepTime = readWS(context, new DataSourceBuilder().setType(DataSourceType.SLEEP));
        dayStarted = readDay(context, new DataSourceBuilder().setType(DataSourceType.DAY_START));
        dayEnded = readDay(context, new DataSourceBuilder().setType(DataSourceType.DAY_END));
    }

    /**
     * @return
     */
    public long getDayStarted() {
        return dayStarted;
    }

    /**
     * @return
     */
    public long getDayEnded() {
        return dayEnded;
    }

    /**
     * @param context
     * @return
     */
    public long getWakeupTimeCurrent(Context context){
        long[] wakeupTime;
        long curTime = DateTime.getDateTime();
        wakeupTime = readWS(context, new DataSourceBuilder().setType(DataSourceType.WAKEUP));
        if(wakeupTime == null)
            return -1;
        long curWakeUpTime = getTime(curTime, wakeupTime);
        if(curTime > curWakeUpTime)
            return curWakeUpTime;
        return getTime(curTime - 24 * 60 * 60 * 1000, wakeupTime);
    }

    /**
     * @param context
     * @return
     */
    public long getWakeupTimeNext(Context context){
        long[] wakeupTime;
        long curTime = DateTime.getDateTime();
        wakeupTime = readWS(context, new DataSourceBuilder().setType(DataSourceType.WAKEUP));
        if(wakeupTime == null)
            return -1;
        long curWakeUpTime = getTime(curTime, wakeupTime);
        if(curTime < curWakeUpTime)
            return curWakeUpTime;
        return getTime(curTime + 24 * 60 * 60 * 1000, wakeupTime);
    }

    /**
     * @param context
     * @return
     */
    public long getSleepTimeCurrent(Context context){
        long[] offset;
        long curTime = DateTime.getDateTime();
        offset = readWS(context, new DataSourceBuilder().setType(DataSourceType.SLEEP));
        if(offset == null)
            return -1;
        long curSleepTime = getTime(curTime, offset);
        if(curTime < curSleepTime)
            return curSleepTime;
        return getTime(curTime + 24 * 60 * 60 * 1000, offset);
    }

    /**
     * @param time
     * @param offsets
     * @return
     */
    private long getTime(long time, long[] offsets){
        long offset;
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        int index = c.get(Calendar.DAY_OF_WEEK);
        offset = offsets[index] / (60 * 1000);
        c.set(Calendar.MILLISECOND, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MINUTE, (int) (offset % 60));
        c.set(Calendar.HOUR_OF_DAY, (int) (offset / 60));
        return c.getTimeInMillis();
    }

    /**
     * @return
     */
    public long[] getWakeupTime() {
        return wakeupTime;
    }

    /**
     * @return
     */
    public long[] getSleepTime() {
        return sleepTime;
    }

    /**
     *
     */
    public void clear() {}

    /**
     * @param context
     * @param dataSourceBuilder
     * @return
     */
    private long readDay(Context context, DataSourceBuilder dataSourceBuilder) {
        try {
            DataKitAPI dataKitAPI = DataKitAPI.getInstance(context);
            ArrayList<DataSourceClient> dataSourceClients = dataKitAPI.find(dataSourceBuilder);
            if (dataSourceClients.size() > 0) {
                ArrayList<DataType> dataTypes = dataKitAPI.query(dataSourceClients.get(0), 1);
                if (dataTypes.size() != 0) {
                    try {
                        DataTypeLong d = (DataTypeLong) dataTypes.get(0);
                        return d.getSample();
                    } catch (Exception ignored) {
                    }
                }
            }
        } catch (Exception ignored) {}
        return -1;
    }

    /**
     * @param context
     * @param dataSourceBuilder
     * @return
     */
    private long[] readWS(Context context, DataSourceBuilder dataSourceBuilder) {
        try {
            DataKitAPI dataKitAPI = DataKitAPI.getInstance(context);
            ArrayList<DataSourceClient> dataSourceClients = dataKitAPI.find(dataSourceBuilder);
            if (dataSourceClients.size() > 0) {
                ArrayList<DataType> dataTypes = dataKitAPI.query(dataSourceClients.get(0), 1);
                if (dataTypes.size() != 0) {
                    try {
                        DataTypeLongArray d = (DataTypeLongArray) dataTypes.get(0);
                        return d.getSample();
                    } catch (Exception ignored) {
                    }
                }
            }
        } catch (Exception ignored) {}
        return null;
    }
}
