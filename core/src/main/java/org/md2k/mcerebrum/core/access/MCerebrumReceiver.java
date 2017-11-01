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

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import org.md2k.datakitapi.DataKitAPI;
import org.md2k.mcerebrum.core.access.appinfo.AppAccess;
import org.md2k.mcerebrum.core.access.appinfo.AppCP;
import org.md2k.mcerebrum.core.constant.MCEREBRUM;

public class MCerebrumReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String funcInit= AppAccess.getFuncUpdateInfo(context, context.getPackageName());
        if(funcInit==null){
            SharedPreferences sharedpreferences = context.getSharedPreferences("mcerebrum", Context.MODE_PRIVATE);
            funcInit=sharedpreferences.getString("init",null);
            if(funcInit==null) return;
            AppAccess.setFuncUpdateInfo(context, context.getPackageName(), funcInit);
        }
        String s = intent.getStringExtra(MCEREBRUM.APP_ACCESS.OP);

        if(s!=null && s.equals(MCEREBRUM.APP_ACCESS.OP_DATAKIT_STOP)){
            if(DataKitAPI.getInstance(context).isConnected()){
                DataKitAPI.getInstance(context).disconnect();
            }
        }
        AppAccess.setMCerebrumSupported(context, context.getPackageName(), true);
        try{
            boolean isConnected=DataKitAPI.getInstance(context).isConnected();
            AppAccess.setDataKitConnected(context, context.getPackageName(), isConnected);
        }catch (Exception ignored){

        }
        try {
            Boolean b = AppCP.getUseInStudy(context, context.getPackageName());
            if(b==null || !b) return;
            Class act =  Class.forName(funcInit);
            MCerebrumInfo m= (MCerebrumInfo) act.newInstance();
            m.update(context);
        } catch (Exception ignored) {

        }
/*
        if(AppAccess.getFuncPermission(context, context.getPackageName())!=null && !AppAccess.getPermissionOk(context, context.getPackageName())){
            AppAccess.permission(context, context.getPackageName());
        }
*/
/*
        Intent i = new Intent("org.md2k.mcerebrum.intent.action.REPLY");
        i.putExtra("package_name",context.getPackageName());
        context.sendBroadcast(i);
*/
    }
}