package org.md2k.system.app;
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

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import org.md2k.mcerebrum.core.access.MCerebrumStatus;
import org.md2k.system.provider.AppCP;

public class MCerebrumController {
    private AppCP appCP;
    private Context context;
    private ServiceCommunication serviceCommunication;
    private MCerebrumStatus mCerebrumStatus;
    MCerebrumController(Context context, AppCP appCP) {
        this.appCP = appCP;
        this.context=context;
        mCerebrumStatus = null;
        appCP.setMCerebrumSupported(context, checkMCerebrumSupport(appCP.getPackageName()));
        serviceCommunication=new ServiceCommunication(new ResponseCallback() {
            @Override
            public void onResponse(boolean isConnected) {
                if (isConnected) {
                    setStatus();
                }
            }
        });
    }

    public boolean ismCerebrumSupported() {
        return appCP.getMCerebrumSupported();
    }

    private boolean checkMCerebrumSupport(String packageName){
        PackageInfo pi;
        try {
            pi = context.getPackageManager().getPackageInfo(
                    packageName, PackageManager.GET_SERVICES);
            if(pi.services==null) return false;
            ServiceInfo[] s = pi.services;
            for (ServiceInfo value : s) {
                if (value.name.endsWith(".ServiceMCerebrum")) return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    void startService() {
        if(!appCP.getMCerebrumSupported()) return;
        try {
            serviceCommunication.start(context, appCP.getPackageName());
        } catch (Exception ignored) {
        }
    }
    void stopService() {
        try {
            if(!appCP.getMCerebrumSupported()) return;
            serviceCommunication.stop(context);
        } catch (Exception ignored) {
        }
    }

    public void report(Bundle bundle) {
        try {
            if(!appCP.getMCerebrumSupported()) return;
            serviceCommunication.report(bundle);
        } catch (Exception ignored) {
        }
    }

    public void configure(Bundle bundle) {
        try {
            if(!appCP.getMCerebrumSupported()) return;
            serviceCommunication.configure(bundle);
        } catch (Exception ignored) {
        }

    }

    public void clear(Bundle bundle) {

        try {
            if(!appCP.getMCerebrumSupported()) return;
            serviceCommunication.clear(bundle);
        } catch (Exception ignored) {
        }
    }

    public void startBackground(Bundle bundle) {
        try {
            if(!appCP.getMCerebrumSupported()) return;
            serviceCommunication.startBackground(bundle);
        } catch (Exception ignored) {
        }
    }

    public void stopBackground(Bundle bundle) {
        try {
            if(!appCP.getMCerebrumSupported()) return;
            serviceCommunication.stopBackground(bundle);
        } catch (Exception ignored) {
        }
    }

    public void initialize(Bundle bundle) {
        try {
            if(!appCP.getMCerebrumSupported()) return;
            serviceCommunication.initialize(bundle);
        } catch (Exception ignored) {
        }
    }

    void setStatus() {
        try {
            if(!appCP.getMCerebrumSupported()) return;
            mCerebrumStatus = serviceCommunication.getmCerebrumStatus();
            if (!appCP.getInitialized()) {
                appCP.setInitialized(context, true);
                initialize(null);
            }
            LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("connection"));
        } catch (Exception ignored) {
        }
    }

    public boolean isServiceRunning() {
        return appCP.getMCerebrumSupported() && mCerebrumStatus!=null && serviceCommunication.ismServiceBound();
    }
    public boolean isRunInBackground() {
        return appCP.getMCerebrumSupported() && mCerebrumStatus!=null && mCerebrumStatus.isRunInBackground();
    }

    public boolean isConfigurable() {

        return appCP.getMCerebrumSupported() && mCerebrumStatus!=null && mCerebrumStatus.isConfigurable();
    }

    public boolean isConfigured() {

        return appCP.getMCerebrumSupported() && mCerebrumStatus!=null && mCerebrumStatus.isConfigured();
    }

    public boolean hasClear() {
        return appCP.getMCerebrumSupported() && mCerebrumStatus!=null && mCerebrumStatus.hasClear();
    }

    public boolean isEqualDefault() {

        return appCP.getMCerebrumSupported() && mCerebrumStatus!=null && mCerebrumStatus.isEqualDefault();
    }

    public void launch(Bundle bundle) {
        try {
            serviceCommunication.launch(bundle);
            return;
        } catch (Exception ignored) {
            Log.d("abc","e="+ignored.getMessage());
        }
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(appCP.getPackageName());
        context.startActivity(intent);
    }

    public void setInitialized(boolean initialized) {
        appCP.setInitialized(context, initialized);
    }

    public boolean isInitialized() {
        return appCP.getInitialized();
    }

    public void reset() {
        appCP.setInitialized(context, false);
        appCP.setMCerebrumSupported(context, checkMCerebrumSupport(appCP.getPackageName()));
    }
    public boolean isRunning(){
        return appCP.getMCerebrumSupported() && mCerebrumStatus!=null && mCerebrumStatus.isRunning();
    }
}
