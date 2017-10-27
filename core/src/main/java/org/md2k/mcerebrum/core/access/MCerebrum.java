package org.md2k.mcerebrum.core.access;
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

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.md2k.mcerebrum.core.access.appinfo.AppAccess;

public class MCerebrum {
    private MCerebrum(){
        throw new UnsupportedOperationException("u can't instantiate me...");
    }
/*
    public static void init(Context context){
        AppInfoBean appBean=new AppInfoBean();
        appBean.setPackageName(context.getPackageName());
//        if(AppCP.isEmpty(context))
            AppCP.insertOrUpdate(context, appBean);
    }
*/

    public static void setReportActivity(Context context, Class<? extends Activity> report){
        AppAccess.setFuncReport(context, context.getPackageName(), report.getName());
    }
    public static void setClearActivity(Context context, Class<? extends Activity> report){
        AppAccess.setFuncClear(context, context.getPackageName(), report.getName());
    }
    public static void setInitializeActivity(Context context, Class<? extends Activity> report){
        AppAccess.setFuncInitialize(context, context.getPackageName(), report.getName());
    }
    public static void setConfigureActivity(Context context, Class<? extends Activity> report){
        AppAccess.setFuncConfigure(context, context.getPackageName(), report.getName());
    }
    public static void setBackgroundService(Context context, Class<? extends Service> report){
        AppAccess.setFuncBackground(context, context.getPackageName(), report.getName());
    }
    public static void setPermissionActivity(Context context, Class<? extends Activity> report){
        AppAccess.setFuncPermission(context, context.getPackageName(), report.getName());
    }
    public static void setPermission(Context context, boolean b){
        AppAccess.setPermissionOk(context, context.getPackageName(), b);
    }
    public static boolean getPermission(Context context) {
        return AppAccess.getPermissionOk(context, context.getPackageName());
    }

    public static void setConfigured(Context context, boolean b){
        AppAccess.setConfigured(context, context.getPackageName(), b);
    }
    public static void setConfigureExact(Context context, boolean b){
        AppAccess.setConfigureMatch(context, context.getPackageName(), b);
    }

    public static void init(Context context, Class<? extends MCerebrumInfo> info) {
        SharedPreferences sharedpreferences = context.getSharedPreferences("mcerebrum", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("init", info.getName());
        editor.apply();
        AppAccess.setFuncUpdateInfo(context, context.getPackageName(), info.getName());
    }

/*
//    public static String getReport(Context context){
        return AppCP.getReport(context);
    }
*/
}
