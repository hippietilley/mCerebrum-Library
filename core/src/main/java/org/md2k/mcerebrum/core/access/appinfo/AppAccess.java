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

package org.md2k.mcerebrum.core.access.appinfo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import org.md2k.mcerebrum.core.constant.MCEREBRUM;

import java.util.ArrayList;

/**
 * Provides methods for making calls to <code>AppCP</code>.
 */
public class AppAccess {

    /**
     *
     *
     * @param context Android context.
     * @param packageName Name of the package.
     */
    public static void configure(Context context, String packageName) {
        String name = AppCP.getFuncConfigure(context, packageName);
        if(name == null)
            return;
        startActivity(context, packageName, name);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     */
    public static void report(Context context, String packageName) {
        String name = AppCP.getFuncReport(context, packageName);
        if(name == null)
            return;
        startActivity(context, packageName, name);
    }

    /**
     * @param context Android context.
     */
    public static void set(Context context) {
        ArrayList<String> apps = AppBasicInfo.get(context);
        for(int i = 0; i < apps.size(); i++)
            set(context, apps.get(i));
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     */
    public static void set(Context context, String packageName){
        boolean isInstalled = AppCP.getInstalled(context, packageName);
        if(!isInstalled)
            AppCP.clearAccess(context, packageName);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     */
    public static void clear(Context context, String packageName) {
        String name = AppCP.getFuncClear(context, packageName);
        if(name == null)
            return;
        startActivity(context, packageName, name);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     */
    public static void permission(Context context, String packageName) {
        String name = AppCP.getFuncPermission(context, packageName);
        if(name == null)
            return;
        startActivity(context, packageName, name);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     * @param activityName Name of the activity.
     */
    private static void startActivity(Context context, String packageName, String activityName){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, activityName));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     * @param serviceName Name of the service.
     */
    private static void startService(Context context, String packageName, String serviceName){
        if(AppInfo.isServiceRunning(context, serviceName)) return;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, serviceName));
        context.startService(intent);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     * @param serviceName
     */
    public static void stopService(Context context, String packageName, String serviceName){
        if(!AppInfo.isServiceRunning(context, serviceName)) return;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, serviceName));
        context.stopService(intent);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     */
    public static void launch(Context context, String packageName) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        context.startActivity(intent);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     */
    public static void startBackground(Context context, String packageName) {
        String name = AppCP.getFuncBackground(context, packageName);
        if(name == null)
            return;
        startService(context, packageName, name);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     */
    public static void stopBackground(Context context, String packageName) {
        String name = AppCP.getFuncBackground(context, packageName);
        if(name == null)
            return;
        stopService(context, packageName, name);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     * @param b
     */
    public static void setDataKitConnected(Context context, String packageName, boolean b) {
        AppCP.setDataKitConnected(context, packageName, b);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     * @param b
     */
    public static void setMCerebrumSupported(Context context, String packageName, boolean b) {
        AppCP.setMCerebrumSupported(context, packageName, b);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     * @return
     */
    public static boolean getMCerebrumSupported(Context context, String packageName) {
        return AppCP.getMCerebrumSupported(context, packageName);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     * @param name
     */
    public static void setFuncReport(Context context, String packageName, String name) {
        AppCP.setFuncReport(context, packageName, name);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     * @param name
     */
    public static void setFuncBackground(Context context, String packageName, String name) {
        AppCP.setFuncBackground(context, packageName, name);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     * @param name
     */
    public static void setFuncClear(Context context, String packageName, String name) {
        AppCP.setFuncClear(context, packageName, name);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     * @param b
     */
    public static void setConfigureMatch(Context context, String packageName, boolean b) {
        AppCP.setConfigureMatch(context, packageName, b);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     * @return
     */
    public static boolean getConfigureMatch(Context context, String packageName) {
        return AppCP.getConfigureMatch(context, packageName);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     * @return
     */
    public static String getFuncClear(Context context, String packageName) {
        return AppCP.getFuncClear(context, packageName);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     * @param name
     */
    public static void setFuncConfigure(Context context, String packageName, String name) {
        AppCP.setFuncConfigure(context, packageName, name);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     * @return
     */
    public static String getFuncConfigure(Context context, String packageName) {
        return AppCP.getFuncConfigure(context, packageName);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     * @param name
     */
    public static void setFuncInitialize(Context context, String packageName, String name) {
        AppCP.setFuncInitialize(context, packageName, name);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     * @return
     */
    public static String getFuncPermission(Context context, String packageName) {
        return AppCP.getFuncPermission(context, packageName);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     * @param name
     */
    public static void setFuncPermission(Context context, String packageName, String name) {
        AppCP.setFuncPermission(context, packageName, name);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     * @return
     */
    public static boolean getPermissionOk(Context context, String packageName) {
        return AppCP.getPermissionOk(context, packageName);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     * @param b
     */
    public static void setPermissionOk(Context context, String packageName, boolean b) {
        AppCP.setPermissionOk(context, packageName,b);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     * @param name
     */
    public static void setFuncUpdateInfo(Context context, String packageName, String name) {
        AppCP.setFuncUpdateInfo(context, packageName, name);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     * @return
     */
    public static String getFuncUpdateInfo(Context context, String packageName) {
        return AppCP.getFuncUpdateInfo(context, packageName);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     * @param isConfigured
     */
    public static void setConfigured(Context context, String packageName, boolean isConfigured) {
        AppCP.setConfigured(context, packageName, isConfigured);
    }

    /**
     * @param context Android context.
     * @param packageName Name of the package.
     * @return
     */
    public static boolean getConfigured(Context context, String packageName) {
        return AppCP.getConfigured(context, packageName);
    }

    /**
     * Determines whether a app is configurable or not.
     * @param context Android context.
     * @param packageName Name of the package.
     * @return Whether a app is configurable or not.
     */
    public static boolean isConfigurable(Context context, String packageName){
        String f = AppCP.getFuncConfigure(context, packageName);
        return f != null;
    }

    /**
     * Returns the list of reqired apps that have not been configured.
     * @param context Android context.
     * @return The list of reqired apps that have not been configured.
     */
    public static ArrayList<String> getRequiredAppNotConfigured(Context context) {
        ArrayList<String> packageNames = AppBasicInfo.get(context);
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < packageNames.size(); i++) {
            String useAs = AppCP.getUseAs(context, packageNames.get(i));
            boolean isConfigurable = isConfigurable(context, packageNames.get(i));
            boolean isConfigMatch = AppCP.getConfigureMatch(context, packageNames.get(i));
            if (useAs == null || !useAs.equalsIgnoreCase(MCEREBRUM.APP.USE_AS_REQUIRED))
                continue;
            if (!AppCP.getInstalled(context, packageNames.get(i)))
                list.add(packageNames.get(i));
            else if(isConfigurable && !isConfigMatch)
                list.add(packageNames.get(i));
        }
        return list;
    }

    /**
     * Returns the list of reqired apps that have been configured.
     * @param context Android context
     * @return The list of reqired apps that have been configured.
     */
    public static ArrayList<String> getRequiredAppConfigured(Context context) {
        ArrayList<String> packageNames = AppBasicInfo.get(context);
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < packageNames.size(); i++) {
            String useAs = AppCP.getUseAs(context, packageNames.get(i));
            if (useAs == null || !useAs.equalsIgnoreCase(MCEREBRUM.APP.USE_AS_REQUIRED))
                continue;
            if(!AppCP.getInstalled(context, packageNames.get(i)))
                continue;
            boolean isConfigurable = isConfigurable(context, packageNames.get(i));
            boolean isConfigMatch = AppCP.getConfigureMatch(context, packageNames.get(i));
            if(isConfigurable && !isConfigMatch)
                continue;
            list.add(packageNames.get(i));
        }
        return list;
    }
}
