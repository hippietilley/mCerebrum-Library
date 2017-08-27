package org.md2k.mcerebrum.core;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ServicemCerebrum extends Service {
    public ServicemCerebrum() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
