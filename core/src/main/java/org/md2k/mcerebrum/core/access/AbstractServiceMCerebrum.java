package org.md2k.mcerebrum.core.access;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;



abstract public class AbstractServiceMCerebrum extends Service {

    private void log(String message) {
        Log.v("MainService", message);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private final IMCerebrumService.Stub mBinder = new IMCerebrumService.Stub() {
        @Override
        public MCerebrumStatus GetmCerebrumStatus() throws RemoteException {
            MCerebrumStatus mC=new MCerebrumStatus(getPackageName(), isConfigurable(), isConfigured(), isRunning(), getRunningTime(), isRunInBackground(), hasReport(), hasClear(), hasInitialize(), isEqualDefault());
            return mC;
        }
        @Override
        public void Initialize(Bundle bundle) throws RemoteException{
            initialize(bundle);
        }
        @Override
        public void Launch(Bundle bundle) throws RemoteException{
            launch(bundle);
        }

/*
        @Override
        public void exit() throws RemoteException {
            log("Received exit command.");
            stopSelf();
        }
*/

        @Override
        public void StartBackground(Bundle bundle) throws RemoteException {
            startBackground(bundle);
        }
        @Override
        public void StopBackground(Bundle bundle) throws RemoteException {
            stopBackground(bundle);
        }
        @Override
        public void Report(Bundle bundle)throws RemoteException{
            report(bundle);
        }
        @Override
        public void Clear(Bundle bundle) throws RemoteException {
            clear(bundle);
        }
        @Override
        public void Configure(Bundle bundle) throws RemoteException {
            configure(bundle);
        }
    };

    protected abstract boolean hasClear();

    abstract public void initialize(Bundle bundle);
    abstract public void launch(Bundle bundle);
    abstract public void startBackground(Bundle bundle);
    abstract public void stopBackground(Bundle bundle);
    abstract public void report(Bundle bundle);
    abstract public void clear(Bundle bundle);
    abstract public void configure(Bundle bundle);

    abstract public boolean hasReport();

    abstract public boolean isRunInBackground();

    abstract public long getRunningTime();

    abstract public boolean isRunning();

    abstract public boolean isConfigured();

    abstract public boolean isConfigurable();

    abstract public boolean hasInitialize();

    abstract public boolean isEqualDefault();
}
