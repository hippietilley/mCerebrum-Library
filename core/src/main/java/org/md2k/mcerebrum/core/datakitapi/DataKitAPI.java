package org.md2k.mcerebrum.core.datakitapi;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;

import org.md2k.mcerebrum.core.datakitapi.Constants;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataType;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeDoubleArray;
import org.md2k.mcerebrum.core.datakitapi.datatype.DataTypeLong;
import org.md2k.mcerebrum.core.datakitapi.datatype.RowObject;
import org.md2k.mcerebrum.core.datakitapi.exception.DataKitException;
import org.md2k.mcerebrum.core.datakitapi.exception.DataKitNotFoundException;
import org.md2k.mcerebrum.core.datakitapi.messagehandler.OnConnectionListener;
import org.md2k.mcerebrum.core.datakitapi.messagehandler.OnReceiveListener;
import org.md2k.mcerebrum.core.datakitapi.source.datasource.DataSourceBuilder;
import org.md2k.mcerebrum.core.datakitapi.source.datasource.DataSourceClient;
import org.md2k.mcerebrum.core.datakitapi.status.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * Copyright (c) 2016, The University of Memphis, MD2K Center
 * - Syed Monowar Hossain <monowar.hossain@gmail.com>
 * - Timothy W. Hnat <twhnat@memphis.edu>
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
public class DataKitAPI {
    private static final String TAG = org.md2k.mcerebrum.core.datakitapi.DataKitAPI.class.getSimpleName();
    private static final int BUFFER_SIZE = 1<<13; //8 KB
    private static org.md2k.mcerebrum.core.datakitapi.DataKitAPI instance = null;
    DataKitAPIExecute dataKitAPIExecute;
    Context context;
    Handler handler;
    private static final long SYNC_TIME_HF = 1000;
    HashMap<Integer, HFBuffer> hmHFBuffer;

    class HFBuffer {
        ArrayList<DataTypeDoubleArray> data;
        int size;

        HFBuffer() {
            data = new ArrayList<>();
            size = 0;
        }
    }


    private DataKitAPI(Context context) {
        this.context = context;
        dataKitAPIExecute = new DataKitAPIExecute(context);
        handler = new Handler();
        hmHFBuffer = new HashMap<>();
    }

    public static org.md2k.mcerebrum.core.datakitapi.DataKitAPI getInstance(Context context) {
        if (instance == null) {
            synchronized (org.md2k.mcerebrum.core.datakitapi.DataKitAPI.class) {
                if (instance == null)
                    instance = new org.md2k.mcerebrum.core.datakitapi.DataKitAPI(context.getApplicationContext());
            }
        }
        return instance;
    }

    public boolean isConnected() {
        return !(dataKitAPIExecute == null || !dataKitAPIExecute.isConnected());
    }

    public synchronized void connect(OnConnectionListener callerOnConnectionListener) throws DataKitException {
        if (!isInstalled(context, Constants.PACKAGE_NAME)) {
            throw new DataKitNotFoundException(new Status(Status.ERROR_NOT_INSTALLED));
        } else if (isConnected()) callerOnConnectionListener.onConnected();
        else {
            dataKitAPIExecute.connect(callerOnConnectionListener);
            handler.postDelayed(runnableSyncHF,SYNC_TIME_HF);
        }
    }

    public synchronized ArrayList<DataSourceClient> find(DataSourceBuilder dataSourceBuilder) throws DataKitException {
        if (!dataKitAPIExecute.isConnected())
            throw new DataKitNotFoundException(new Status(Status.ERROR_BOUND));
        if (dataSourceBuilder == null)
            throw new DataKitException(new Status(Status.DATA_INVALID).getStatusMessage());
        ArrayList<DataSourceClient> dataSourceClients = dataKitAPIExecute.find(dataSourceBuilder).await();
        if (dataSourceClients == null || !dataKitAPIExecute.isConnected())
            throw new DataKitNotFoundException(new Status(Status.ERROR_BOUND));
        else return dataSourceClients;
    }

    public synchronized void insert(DataSourceClient dataSourceClient, DataType dataType) throws DataKitException {
        if (!dataKitAPIExecute.isConnected())
            throw new DataKitNotFoundException(new Status(Status.ERROR_BOUND));
        if (dataSourceClient == null || dataType == null)
            throw new DataKitException(new Status(Status.DATA_INVALID).getStatusMessage());
        else {
            DataType[] dataTypes=new DataType[]{dataType};
            dataKitAPIExecute.insert(dataSourceClient, dataTypes);
        }
    }
    public synchronized void setSummary(DataSourceClient dataSourceClient, DataType dataType) throws DataKitException {
        if (!dataKitAPIExecute.isConnected())
            throw new DataKitNotFoundException(new Status(Status.ERROR_BOUND));
        if (dataSourceClient == null || dataType == null)
            throw new DataKitException(new Status(Status.DATA_INVALID).getStatusMessage());
        else {
            dataKitAPIExecute.setSummary(dataSourceClient, dataType);
        }
    }

    public synchronized void insert(DataSourceClient dataSourceClient, DataType[] dataTypes) throws DataKitException {
        if (!dataKitAPIExecute.isConnected())
            throw new DataKitNotFoundException(new Status(Status.ERROR_BOUND));
        if (dataSourceClient == null || dataTypes == null)
            throw new DataKitException(new Status(Status.DATA_INVALID).getStatusMessage());
        else dataKitAPIExecute.insert(dataSourceClient, dataTypes);
    }
    public synchronized void insertHighFrequency(final DataSourceClient dataSourceClient, final DataTypeDoubleArray[] dataType) throws DataKitException {
        if (!dataKitAPIExecute.isConnected())
            throw new DataKitNotFoundException(new Status(Status.ERROR_BOUND));
        if (dataSourceClient == null || dataType == null)
            throw new DataKitException(new Status(Status.DATA_INVALID).getStatusMessage());
        else {
            for (DataTypeDoubleArray aDataType : dataType)
                addToBuffer(dataSourceClient.getDs_id(), aDataType);
        }
    }

    public synchronized void insertHighFrequency(final DataSourceClient dataSourceClient, final DataTypeDoubleArray dataType) throws DataKitException {
        if (!dataKitAPIExecute.isConnected())
            throw new DataKitNotFoundException(new Status(Status.ERROR_BOUND));
        if (dataSourceClient == null || dataType == null)
            throw new DataKitException(new Status(Status.DATA_INVALID).getStatusMessage());
        else
            addToBuffer(dataSourceClient.getDs_id(), dataType);
    }

    synchronized void addToBuffer(int ds_id, DataTypeDoubleArray dataTypeDoubleArray) {
        HFBuffer hfBuffer;
        if (hmHFBuffer.containsKey(ds_id))
            hfBuffer = hmHFBuffer.get(ds_id);
        else
            hfBuffer = new HFBuffer();

        if(hfBuffer.size+dataTypeDoubleArray.getSample().length*8>=BUFFER_SIZE){
            syncHFData(ds_id);
            hfBuffer=hmHFBuffer.get(ds_id);
        }
        hfBuffer.data.add(dataTypeDoubleArray);
        hfBuffer.size += dataTypeDoubleArray.getSample().length * 8;
        hmHFBuffer.put(ds_id, hfBuffer);
    }

    synchronized void syncHFData(int ds_id) {
        HFBuffer hfBuffer = hmHFBuffer.get(ds_id);
        if (hfBuffer.size == 0) return;
        DataTypeDoubleArray[] dataTypeDoubleArrays = new DataTypeDoubleArray[hfBuffer.data.size()];
        for (int i = 0; i < hfBuffer.data.size(); i++)
            dataTypeDoubleArrays[i] = hfBuffer.data.get(i);
        hfBuffer.data.clear();
        hfBuffer.size = 0;
        hmHFBuffer.put(ds_id, hfBuffer);
        try {
            dataKitAPIExecute.insertHighFrequency(ds_id, dataTypeDoubleArrays);
        } catch (DataKitException ignored) {
        }
    }

    synchronized void syncHFDataAll() {
        for (Map.Entry<Integer, HFBuffer> entry : hmHFBuffer.entrySet())
            syncHFData(entry.getKey());
    }

    public synchronized DataSourceClient register(final DataSourceBuilder dataSourceBuilder) throws DataKitException {
        if (!dataKitAPIExecute.isConnected())
            throw new DataKitNotFoundException(new Status(Status.ERROR_BOUND));
        if (dataSourceBuilder == null)
            throw new DataKitException(new Status(Status.DATA_INVALID).getStatusMessage());
        DataSourceClient dataSourceClient = dataKitAPIExecute.register(dataSourceBuilder).await();
        if (dataSourceClient == null || !dataKitAPIExecute.isConnected())
            throw new DataKitNotFoundException(new Status(Status.ERROR_BOUND));
        else return dataSourceClient;
    }

    public synchronized Status unregister(final DataSourceClient dataSourceClient) throws DataKitException {
        if (!dataKitAPIExecute.isConnected())
            throw new DataKitNotFoundException(new Status(Status.ERROR_BOUND));
        if (dataSourceClient == null)
            throw new DataKitException(new Status(Status.DATA_INVALID).getStatusMessage());
        Status status = dataKitAPIExecute.unregister(dataSourceClient).await();
        if (status == null || !dataKitAPIExecute.isConnected())
            throw new DataKitNotFoundException(new Status(Status.ERROR_BOUND));
        else return status;
    }

    public synchronized ArrayList<DataType> query(final DataSourceClient dataSourceClient, final int last_n_sample) throws DataKitException {
        if (!dataKitAPIExecute.isConnected())
            throw new DataKitNotFoundException(new Status(Status.ERROR_BOUND));
        if (dataSourceClient == null || last_n_sample == 0)
            throw new DataKitException(new Status(Status.DATA_INVALID).getStatusMessage());
        ArrayList<DataType> dataTypes = dataKitAPIExecute.query(dataSourceClient, last_n_sample).await();
        if (dataTypes == null || !dataKitAPIExecute.isConnected())
            throw new DataKitNotFoundException(new Status(Status.ERROR_BOUND));
        else return dataTypes;
    }

    public synchronized ArrayList<DataType> query(DataSourceClient dataSourceClient, long starttimestamp, long endtimestamp) throws DataKitException {
        if (!dataKitAPIExecute.isConnected())
            throw new DataKitNotFoundException(new Status(Status.ERROR_BOUND));
        if (dataSourceClient == null || starttimestamp > endtimestamp)
            throw new DataKitException(new Status(Status.DATA_INVALID).getStatusMessage());
        ArrayList<DataType> dataTypes = dataKitAPIExecute.query(dataSourceClient, starttimestamp, endtimestamp).await();
        if (dataTypes == null || !dataKitAPIExecute.isConnected())
            throw new DataKitNotFoundException(new Status(Status.ERROR_BOUND));
        else return dataTypes;
    }

    public synchronized ArrayList<RowObject> queryFromPrimaryKey(DataSourceClient dataSourceClient, long lastSyncedKey, int limit) throws DataKitException {
        if (!dataKitAPIExecute.isConnected())
            throw new DataKitNotFoundException(new Status(Status.ERROR_BOUND));
        if (dataSourceClient == null)
            throw new DataKitException(new Status(Status.DATA_INVALID).getStatusMessage());
        ArrayList<RowObject> rowObjects = dataKitAPIExecute.queryFromPrimaryKey(dataSourceClient, lastSyncedKey, limit).await();
        if (rowObjects == null || !dataKitAPIExecute.isConnected())
            throw new DataKitNotFoundException(new Status(Status.ERROR_BOUND));
        else return rowObjects;
    }

    public synchronized DataTypeLong querySize() throws DataKitException {
        if (!dataKitAPIExecute.isConnected())
            throw new DataKitNotFoundException(new Status(Status.ERROR_BOUND));
        DataTypeLong dataTypeLong = dataKitAPIExecute.querySize().await();
        if (dataTypeLong == null || !dataKitAPIExecute.isConnected())
            throw new DataKitNotFoundException(new Status(Status.ERROR_BOUND));
        else return dataTypeLong;
    }

    public synchronized void subscribe(DataSourceClient dataSourceClient, OnReceiveListener onReceiveListener) throws DataKitException {
        if (!dataKitAPIExecute.isConnected())
            throw new DataKitNotFoundException(new Status(Status.ERROR_BOUND));
        if (dataSourceClient == null || onReceiveListener == null)
            throw new DataKitException(new Status(Status.DATA_INVALID).getStatusMessage());
        Status status = dataKitAPIExecute.subscribe(dataSourceClient, onReceiveListener);
        if (status == null || !dataKitAPIExecute.isConnected())
            throw new DataKitNotFoundException(new Status(Status.ERROR_BOUND));
    }

    public synchronized Status unsubscribe(DataSourceClient dataSourceClient) throws DataKitException {
        if (!dataKitAPIExecute.isConnected())
            throw new DataKitNotFoundException(new Status(Status.ERROR_BOUND));
        if (dataSourceClient == null)
            throw new DataKitException(new Status(Status.DATA_INVALID).getStatusMessage());
        Status status = dataKitAPIExecute.unsubscribe(dataSourceClient.getDs_id()).await();
        if (status == null || !dataKitAPIExecute.isConnected())
            throw new DataKitNotFoundException(new Status(Status.ERROR_BOUND));
        else return status;
    }

    public synchronized void disconnect() {
        if (dataKitAPIExecute.isConnected()) {
            handler.removeCallbacks(runnableSyncHF);
            syncHFDataAll();
            dataKitAPIExecute.disconnect();
        }
    }

    private boolean isInstalled(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    Runnable runnableSyncHF = new Runnable() {
        @Override
        public void run() {
            syncHFDataAll();
            handler.postDelayed(runnableSyncHF, SYNC_TIME_HF);
        }
    };
}
