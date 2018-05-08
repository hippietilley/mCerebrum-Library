package org.md2k.mcerebrum.commons.ui.data_quality;

import android.content.Context;

import org.md2k.datakitapi.datatype.DataTypeInt;
import org.md2k.datakitapi.source.datasource.DataSource;
import org.md2k.datakitapi.source.datasource.DataSourceBuilder;
import org.md2k.datakitapi.source.datasource.DataSourceType;
import org.md2k.datakitapi.source.platform.Platform;
import org.md2k.datakitapi.source.platform.PlatformBuilder;
import org.md2k.datakitapi.source.platform.PlatformId;
import org.md2k.mcerebrum.commons.permission.ResultCallback;

import java.util.ArrayList;

/**
 * Copyright (c) 2015, The University of Memphis, MD2K Center
 * - Syed Monowar Hossain <monowar.hossain@gmail.com>
 * All rights reserved.
 * <p/>
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * <p/>
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * <p/>
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * <p/>
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
public class DataQualityManager {
    private static final String TAG = DataQualityManager.class.getSimpleName();
    private ArrayList<DataQuality> dataQualities;
    ArrayList<DataQualityInfo> dataQualityInfos;

    public DataQualityManager(){
        dataQualities=new ArrayList<>();
        dataQualityInfos=new ArrayList<>();
    }
    public void set(Context context, ArrayList<DataSource> dataSources) {
        if(dataQualityInfos.size()!=0 || dataQualities.size()!=0) clear();
        for (int i = 0; i < dataSources.size(); i++) {
            dataQualities.add(new DataQuality(context, dataSources.get(i)));
            if(dataSources.get(i).getId().equals(DataSourceType.RESPIRATION) || dataSources.get(i).getId().equals(DataSourceType.ECG) || dataSources.get(i).getId().equals(DataSourceType.ACCELEROMETER))
                dataQualityInfos.add(new DataQualityInfo(30*1000));
            else
                dataQualityInfos.add(new DataQualityInfo());
        }
        for (int i = 0; i < dataSources.size(); i++) {
            final int finalI = i;
            dataQualities.get(i).start(new ReceiveCallBack() {
                @Override
                public void onReceive(DataTypeInt sample) {
                    dataQualityInfos.get(finalI).set(sample);
                }
            });
        }
    }

    public void clear() {
        if (dataQualities != null && dataQualities.size()!=0) {
            for (int i = 0; i < dataQualities.size(); i++) {
                try {
                    dataQualities.get(i).stop();
                }catch (Exception ignored){}
            }
        }
        dataQualityInfos.clear();
        dataQualities.clear();
    }
}
