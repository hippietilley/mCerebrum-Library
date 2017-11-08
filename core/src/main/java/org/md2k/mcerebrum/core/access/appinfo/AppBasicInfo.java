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

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import org.md2k.mcerebrum.core.R;
import org.md2k.mcerebrum.core.constant.MCEREBRUM;

import java.util.ArrayList;


public class AppBasicInfo {

    public static String getMCerebrum(Context context){
        ArrayList<String> packageNames = AppBasicInfo.get(context);
        for(int i=0;i<packageNames.size();i++) {
            String type=AppCP.getType(context, packageNames.get(i));
            if(type==null) return null;
            if(type.equalsIgnoreCase(MCEREBRUM.APP.TYPE_MCEREBRUM)) return packageNames.get(i);
        }
        return null;
    }
    public static String getDataKit(Context context){
        ArrayList<String> packageNames = AppBasicInfo.get(context);
        for(int i=0;i<packageNames.size();i++) {
            String type=AppCP.getType(context, packageNames.get(i));
            if(type==null) return null;
            if(type.equalsIgnoreCase(MCEREBRUM.APP.TYPE_DATAKIT)) return packageNames.get(i);
        }
        return null;
    }
    public static ArrayList<String> getStudy(Context context){
        ArrayList<String> packageNames = AppBasicInfo.get(context);
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<packageNames.size();i++) {
            String type=AppCP.getType(context, packageNames.get(i));
            if(type==null) return null;
            if(type.equalsIgnoreCase(MCEREBRUM.APP.TYPE_STUDY))
                list.add(packageNames.get(i));
        }
        return list;
    }
    public static Drawable getIcon(Context context, String packageName, String path) {
        try {
            Drawable icon = context.getPackageManager().getApplicationIcon(packageName);
            if (icon != null) return icon;
        } catch (Exception ignored) {
        }
        try {
            if (AppCP.getIcon(context, packageName) != null) {
                Bitmap bitmap = BitmapFactory.decodeFile(path + AppCP.getIcon(context, packageName));
                if (bitmap != null)
                    return new BitmapDrawable(context.getResources(), bitmap);
            }
        } catch (Exception ignored) {

        }
        return context.getResources().getDrawable(R.drawable.ic_question);
/*
        return new IconicsDrawable(context)
                .icon(FontAwesome.Icon.faw_question_circle_o)
                .color(Color.WHITE)
                .sizeDp(128);
*/
            /*AssetManager am = context.getAssets();
            try {
                return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(am.open("mcerebrum.png")));
            } catch (IOException ignored) {
            }
            return null;
*/
    }
    public static ArrayList<String> get(Context context){
        ArrayList<String> packageNames = AppCP.read(context);
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<packageNames.size();i++) {
            String useAs=AppCP.getUseAs(context, packageNames.get(i));
            if(useAs==null) continue;
            if(useAs.equalsIgnoreCase(MCEREBRUM.APP.USE_AS_NOT_IN_USE)) continue;
            list.add(packageNames.get(i));
        }
        return list;
    }

    public static String getTitle(Context context, String packageName) {
        return AppCP.getTitle(context, packageName);
    }
    public static String getSummary(Context context, String packageName) {
        return AppCP.getSummary(context, packageName);
    }
    public static String getDescription(Context context, String packageName) {
        return AppCP.getDescription(context, packageName);
    }

    public static String getUseAs(Context context, String packageName) {
        return AppCP.getUseAs(context, packageName);
    }

    public static String getType(Context context, String packageName) {
        return AppCP.getType(context, packageName);
    }

    public static void set(Context context, String package_name, String type, String title, String summary, String description, String use_as, String download_link, String update, String expected_version, String icon, boolean useInStudy) {
        AppCP.set(context, package_name, type, title, summary, description, use_as, download_link, update, expected_version, icon, useInStudy);
    }
}
