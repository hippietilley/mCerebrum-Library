package org.md2k.mcerebrum.core.access;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;



abstract public class AbstractServiceMCerebrum extends Service {

    private void log(String message) {
        Log.v("MainService", message);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        log("Received start command.");
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        log("Received binding.");
        return mBinder;
    }

    private final IMCerebrumService.Stub mBinder = new IMCerebrumService.Stub() {
        @Override
        public void Initialize() throws RemoteException{
            initialize();
        }
        @Override
        public Info GetInfo() throws RemoteException {
            Info info=new Info(getPackageName(), isConfigurable(), isConfigured(), isRunning(), getRunningTime(), isRunInBackground(), hasReport());
            // Generates a list of 1000 objects that aren't sent back to the binding Activity
            return info;
        }
        @Override
        public void Launch() throws RemoteException{
            launch();
        }

/*
        @Override
        public void exit() throws RemoteException {
            log("Received exit command.");
            stopSelf();
        }
*/

        @Override
        public void StartBackground() throws RemoteException {
            startBackground();
        }
        @Override
        public void StopBackground() throws RemoteException {
            stopBackground();
        }
        @Override
        public void Report()throws RemoteException{
            report();
        }
        @Override
        public void Clear() throws RemoteException {
            clear();
        }
        @Override
        public void Configure() throws RemoteException {
            configure();
        }

        @Override
        public void Exit() throws RemoteException {
            log("Received exit command.");
            stopSelf();
        }
    };
    abstract public void initialize();
    abstract public void launch();
    abstract public void startBackground();
    abstract public void stopBackground();
    abstract public void report();
    abstract public void clear();

    abstract public boolean hasReport();

    abstract public boolean isRunInBackground();

    abstract public long getRunningTime();

    abstract public boolean isRunning();

    abstract public boolean isConfigured();

    abstract public boolean isConfigurable();

    abstract public void configure();
}
