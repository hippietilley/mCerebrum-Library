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

package org.md2k.mcerebrum.commons.ui.data_quality;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import org.md2k.datakitapi.DataKitAPI;
import org.md2k.datakitapi.datatype.DataType;
import org.md2k.datakitapi.datatype.DataTypeInt;
import org.md2k.datakitapi.exception.DataKitException;
import org.md2k.datakitapi.messagehandler.OnReceiveListener;
import org.md2k.datakitapi.source.datasource.DataSource;
import org.md2k.datakitapi.source.datasource.DataSourceBuilder;
import org.md2k.datakitapi.source.datasource.DataSourceClient;
import org.md2k.datakitapi.time.DateTime;
import org.md2k.mcerebrum.core.data_format.DATA_QUALITY;

import java.util.ArrayList;

/**
 *
 */
class DataQuality {
    /** Constant used for logging. <p>Uses <code>class.getSimpleName()</code>.</p> */
    private static final String TAG = DataQuality.class.getSimpleName();

    /** Time delay constant <p>Default is 3500 milliseconds.</p> */
    private static final long DELAY_TIME = 3500;
    private DataSource dataSource;
    private ReceiveCallBack receiveCallBack;
    private Context context;
    private DataSourceClient dataSourceClient;
    private Handler handlerSubscribe;
    private Handler handlerNoData;

    /**
     * Constructor
     * @param context Android context
     * @param dataSource
     */
    DataQuality(Context context, DataSource dataSource) {
        this.dataSource = dataSource;
        this.context = context;
        handlerSubscribe = new Handler();
        handlerNoData = new Handler();
    }

    /**
     * Creates a new data source from the given data source.
     * @param dataSource Given data source.
     * @return The new data source object.
     */
    private DataSource createDataSource(DataSource dataSource) {
        DataSourceBuilder dataSourceBuilder = new DataSourceBuilder(dataSource);
        return dataSourceBuilder.build();
    }

    /**
     *
     * @param receiveCallBack
     */
    public void start(ReceiveCallBack receiveCallBack) {
        this.receiveCallBack = receiveCallBack;
        Log.d(TAG, "DataQuality start()..." + dataSource.getType() + " " + dataSource.getId());
        handlerSubscribe.removeCallbacks(runnableSubscribe);
        handlerSubscribe.post(runnableSubscribe);
        handlerNoData.postDelayed(runnableNoData,DELAY_TIME);
    }

    /**
     *
     */
    private Runnable runnableNoData = new Runnable() {
        /**
         *
         */
        @Override
        public void run() {
            DataTypeInt sample = new DataTypeInt(DateTime.getDateTime(), DATA_QUALITY.BAND_OFF);
            receiveCallBack.onReceive(sample);
            handlerNoData.postDelayed(this, DELAY_TIME);
        }
    };

    /**
     *
     */
    private Runnable runnableSubscribe = new Runnable() {
        /**
         *
         */
        @Override
        public void run() {
            try {
                ArrayList<DataSourceClient> dataSourceClientArrayList = DataKitAPI.getInstance(context)
                        .find(new DataSourceBuilder(createDataSource(dataSource)));
                if (dataSourceClientArrayList.size() == 0)
                    handlerSubscribe.postDelayed(this, 1000);
                else {
                    dataSourceClient = dataSourceClientArrayList.get(dataSourceClientArrayList.size() - 1);
                    ArrayList<DataType> d = DataKitAPI.getInstance(context).query(dataSourceClient, 1);

                    if(d.size() == 1)
                        prepare(d.get(0));
                    DataKitAPI.getInstance(context).subscribe(dataSourceClient, new OnReceiveListener() {
                        /**
                         * @param dataType
                         */
                        @Override
                        public void onReceived(final DataType dataType) {
                            prepare(dataType);
                        }
                    });
                }
            } catch (DataKitException e) {}
        }
    };

    /**
     * @param dataType
     */
    void prepare(DataType dataType){
        if(dataType instanceof DataTypeInt) {
            handlerNoData.removeCallbacks(runnableNoData);
            DataTypeInt sample = ((DataTypeInt) dataType);
            receiveCallBack.onReceive(sample);
            handlerNoData.postDelayed(runnableNoData, DELAY_TIME);
        }
    }

    /**
     *
     */
    void stop() {
        try {
            handlerSubscribe.removeCallbacks(runnableSubscribe);
            handlerNoData.removeCallbacks(runnableNoData);

            if (dataSourceClient != null && DataKitAPI.getInstance(context).isConnected()) {
                DataKitAPI.getInstance(context).unsubscribe(dataSourceClient);
                dataSourceClient = null;
            }
        } catch (DataKitException e) {}
    }
}
