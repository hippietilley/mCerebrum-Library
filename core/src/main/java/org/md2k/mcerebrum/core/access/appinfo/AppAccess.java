package org.md2k.mcerebrum.core.access.appinfo;
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

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import org.md2k.mcerebrum.core.constant.MCEREBRUM;

import java.util.ArrayList;

public class AppAccess {

    public static void configure(Context context, String packageName) {
        String name= AppCP.getFuncConfigure(context, packageName);
        if(name==null) return;
        startActivity(context, packageName, name);
    }
    public static void report(Context context, String packageName) {
        String name= AppCP.getFuncReport(context, packageName);
        if(name==null) return;
        startActivity(context, packageName, name);
    }
    public static void set(Context context) {
        ArrayList<String> apps = AppBasicInfo.get(context);
        for(int i=0;i<apps.size();i++)
            set(context, apps.get(i));
    }

    public static void set(Context context, String packageName){
        boolean isInstalled = AppCP.getInstalled(context, packageName);
        if(!isInstalled)
            AppCP.clearAccess(context, packageName);
    }
    public static void clear(Context context, String packageName) {
        String name= AppCP.getFuncClear(context, packageName);
        if(name==null) return;
        startActivity(context, packageName, name);
    }
    public static void permission(Context context, String packageName) {
        String name= AppCP.getFuncPermission(context, packageName);
        if(name==null) return;
        startActivity(context, packageName, name);
    }

    private static void startActivity(Context context, String packageName, String activityName){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, activityName));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
    private static void startService(Context context, String packageName, String serviceName){
        if(AppInfo.isServiceRunning(context, serviceName)) return;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, serviceName));
        context.startService(intent);
    }
    public static void stopService(Context context, String packageName, String serviceName){
        if(!AppInfo.isServiceRunning(context, serviceName)) return;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, serviceName));
        context.stopService(intent);
    }

    public static void launch(Context context, String packageName) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        context.startActivity(intent);
    }

    public static void startBackground(Context context, String packageName) {
        String name= AppCP.getFuncBackground(context, packageName);
        if(name==null) return;
        startService(context, packageName, name);
    }
    public static void stopBackground(Context context, String packageName) {
        String name= AppCP.getFuncBackground(context, packageName);
        if(name==null) return;
        stopService(context, packageName, name);
    }
    public static void setDataKitConnected(Context context, String packageName, boolean b) {
        AppCP.setDataKitConnected(context, packageName, b);
    }
    public static void setMCerebrumSupported(Context context, String packageName, boolean b) {
        AppCP.setMCerebrumSupported(context, packageName, b);
    }
    public static boolean getMCerebrumSupported(Context context, String packageName) {
        return AppCP.getMCerebrumSupported(context, packageName);
    }

    public static void setFuncReport(Context context, String packageName, String name) {
        AppCP.setFuncReport(context, packageName, name);
    }
    public static void setFuncBackground(Context context, String packageName, String name) {
        AppCP.setFuncBackground(context, packageName, name);
    }
    public static void setFuncClear(Context context, String packageName, String name) {
        AppCP.setFuncClear(context, packageName, name);
    }
    public static void setConfigureMatch(Context context, String packageName, boolean b) {
        AppCP.setConfigureMatch(context, packageName, b);
    }
    public static boolean getConfigureMatch(Context context, String packageName) {
        return AppCP.getConfigureMatch(context, packageName);
    }

    public static String getFuncClear(Context context, String packageName) {
        return AppCP.getFuncClear(context, packageName);
    }
    public static void setFuncConfigure(Context context, String packageName, String name) {
        AppCP.setFuncConfigure(context, packageName, name);
    }
    public static String getFuncConfigure(Context context, String packageName) {
        return AppCP.getFuncConfigure(context, packageName);
    }
    public static void setFuncInitialize(Context context, String packageName, String name) {
        AppCP.setFuncInitialize(context, packageName, name);
    }
    public static String getFuncPermission(Context context, String packageName) {
        return AppCP.getFuncPermission(context, packageName);
    }
    public static void setFuncPermission(Context context, String packageName, String name) {
        AppCP.setFuncPermission(context, packageName, name);
    }
    public static boolean getPermissionOk(Context context, String packageName) {
        return AppCP.getPermissionOk(context, packageName);
    }
    public static void setPermissionOk(Context context, String packageName, boolean b) {
        AppCP.setPermissionOk(context, packageName,b);
    }

    public static void setFuncUpdateInfo(Context context, String packageName, String name) {
        AppCP.setFuncUpdateInfo(context, packageName, name);
    }
    public static String getFuncUpdateInfo(Context context, String packageName) {
        return AppCP.getFuncUpdateInfo(context, packageName);
    }

    public static void setConfigured(Context context, String packageName, boolean isConfigured) {
        AppCP.setConfigured(context, packageName, isConfigured);
    }
    public static boolean getConfigured(Context context, String packageName) {
        return AppCP.getConfigured(context, packageName);
    }

/*
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

    public void report(Bundle bundle) {
        try {
            if(!AppCP.getMCerebrumSupported(context, packageName)) return;
            Intent intent=new Intent();
            context.startActivity(intent);
        } catch (Exception ignored) {
        }
    }


    public void configure(Bundle bundle) {
        try {
            if(!ppCP.getMCerebrumSupported()) return;
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
*/
public static boolean isConfigurable(Context context, String packageName){
    String f = AppCP.getFuncConfigure(context, packageName);
    return f != null;
}
public static ArrayList<String> getRequiredAppNotConfigured(Context context) {
    ArrayList<String> packageNames=AppBasicInfo.get(context);
    ArrayList<String> list=new ArrayList<>();
    for(int i=0;i<packageNames.size();i++) {
        String useAs = AppCP.getUseAs(context, packageNames.get(i));
        boolean isConfigurable = isConfigurable(context, packageNames.get(i));
        boolean isConfigMatch = AppCP.getConfigureMatch(context, packageNames.get(i));
        if (useAs == null || !useAs.equalsIgnoreCase(MCEREBRUM.APP.USE_AS_REQUIRED)) continue;
        if (!AppCP.getInstalled(context, packageNames.get(i))) list.add(packageNames.get(i));
        else if(isConfigurable && !isConfigMatch)
            list.add(packageNames.get(i));
    }
    return list;
}

    public static ArrayList<String> getRequiredAppConfigured(Context context) {
        ArrayList<String> packageNames=AppBasicInfo.get(context);
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<packageNames.size();i++) {
            String useAs = AppCP.getUseAs(context, packageNames.get(i));
            if (useAs == null || !useAs.equalsIgnoreCase(MCEREBRUM.APP.USE_AS_REQUIRED)) continue;
            if(!AppCP.getInstalled(context, packageNames.get(i))) continue;
            boolean isConfigurable = isConfigurable(context, packageNames.get(i));
            boolean isConfigMatch = AppCP.getConfigureMatch(context, packageNames.get(i));
            if(isConfigurable && !isConfigMatch) continue;
            list.add(packageNames.get(i));
        }
        return list;
    }
}
