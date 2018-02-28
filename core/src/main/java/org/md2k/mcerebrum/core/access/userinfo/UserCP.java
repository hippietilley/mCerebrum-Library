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

package org.md2k.mcerebrum.core.access.userinfo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.md2k.mcerebrum.core.access.SampleProviderSQLiteOpenHelper;
import org.md2k.mcerebrum.core.access.userinfo.UserInfoBean;
import org.md2k.mcerebrum.core.access.userinfo.UserInfoCursor;
import org.md2k.mcerebrum.core.access.userinfo.UserInfoSelection;
import org.md2k.mcerebrum.core.access.userinfo.UserInfoBean;
import org.md2k.mcerebrum.core.access.userinfo.UserInfoColumns;
import org.md2k.mcerebrum.core.access.userinfo.UserInfoContentValues;
import org.md2k.mcerebrum.core.access.userinfo.UserInfoCursor;
import org.md2k.mcerebrum.core.access.userinfo.UserInfoSelection;

/**
 *
 */
public class UserCP {

    /**
     * Deletes
     * @param context Android context
     */
    public static void deleteTable(Context context) {
        try {
            SampleProviderSQLiteOpenHelper s = SampleProviderSQLiteOpenHelper.getInstance(context);
            SQLiteDatabase db = s.getWritableDatabase();
            db.execSQL("DROP TABLE IF EXISTS " + UserInfoColumns.TABLE_NAME);
            db.execSQL(SampleProviderSQLiteOpenHelper.SQL_CREATE_TABLE_USER_INFO);
        }catch (Exception e){}
    }

    /**
     * @param context Android context
     * @param userInfoBean
     */
    public static void insertOrUpdate(Context context, UserInfoBean userInfoBean) {
        try {
            UserInfoContentValues values = prepare(userInfoBean);
            if (isEmpty(context))
                values.insert(context);
            else
                values.update(context, new UserInfoSelection().uid(userInfoBean.getUid()));
        }catch (Exception e){
            deleteTable(context);
            UserInfoContentValues values = prepare(userInfoBean);
            values.insert(context);
        }
    }

    /**
     * @param context Android context
     * @return
     */
    private static UserInfoBean read(Context context) {
        UserInfoBean userInfoBean = null;
        try {
            UserInfoSelection userInfoSelection = new UserInfoSelection();
            UserInfoCursor u = userInfoSelection.query(context);
            if (u.moveToNext())
                userInfoBean = UserInfoBean.newInstance(u.getId(), u.getUid(), u.getType(), u.getUsername());
            u.close();
        } catch (Exception ignored) {}
        return userInfoBean;
    }

    /**
     * @param context Android context
     * @return
     */
    public static boolean isEmpty(Context context) {
        int count = 0;
        UserInfoSelection userInfoSelection = new UserInfoSelection();
        UserInfoCursor c = userInfoSelection.query(context);
        while (c.moveToNext()) {
            count++;
        }
        c.close();
        return count == 0;
    }


    /**
     * @param userInfoBean
     * @return
     */
    private static UserInfoContentValues prepare(UserInfoBean userInfoBean) {
        UserInfoContentValues values = new UserInfoContentValues();
        values.putUsername(userInfoBean.getUsername());
        values.putType(userInfoBean.getType());
        values.putUid(userInfoBean.getUid());
        return values;
    }

    /**
     * @param context Android context
     * @param type
     * @param userName
     */
    public static void set(Context context, String type, String userName) {
        UserInfoBean userInfoBean = read(context);
        if (userInfoBean == null)
            userInfoBean = new UserInfoBean();
        userInfoBean.setType(type);
        userInfoBean.setUsername(userName);
        insertOrUpdate(context, userInfoBean);
    }

    /**
     * @param context Android context
     * @return
     */
    public static String getUserName(Context context) {
        UserInfoBean userInfoBean = read(context);
        if (userInfoBean == null)
            return null;
        return userInfoBean.getUsername();
    }
}
