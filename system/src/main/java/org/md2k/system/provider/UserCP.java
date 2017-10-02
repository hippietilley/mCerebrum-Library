package org.md2k.system.provider;
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

import org.md2k.system.provider.userinfo.UserInfoBean;
import org.md2k.system.provider.userinfo.UserInfoContentValues;
import org.md2k.system.provider.userinfo.UserInfoCursor;
import org.md2k.system.provider.userinfo.UserInfoSelection;

public class UserCP {
    private UserInfoBean userInfoBean;

    public UserCP() {
        userInfoBean = new UserInfoBean();
    }

    public void set(Context context, String title, String uuid, String token, boolean isLoggedIn, String hashPassword) {
        userInfoBean.setUid(uuid);
        userInfoBean.setUsername(title);
        userInfoBean.setToken(token);
        userInfoBean.setLoggedIn(isLoggedIn);
        userInfoBean.setPasswordHash(hashPassword);
        insertOrUpdate(context);
    }

    public void delete(Context context) {
        UserInfoSelection userInfoSelection = new UserInfoSelection();
        userInfoSelection.delete(context);
    }

    public void insertOrUpdate(Context context) {
        UserInfoContentValues values = prepare();
        if (isEmpty(context))
            values.insert(context);
        else
            values.update(context, new UserInfoSelection().uid(userInfoBean.getUid()));
    }

    public boolean read(Context context) {
        try {
            UserInfoSelection userInfoSelection = new UserInfoSelection();
            UserInfoCursor c = userInfoSelection.query(context);
            if (c.moveToNext()) {
                set(c);
                c.close();
                return true;
            } else {
                c.close();
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    public void set(UserInfoCursor userInfoCursor) {
        userInfoBean.setUid(userInfoCursor.getUid());
        userInfoBean.setUsername(userInfoCursor.getUsername());
        userInfoBean.setType(userInfoCursor.getType());
        userInfoBean.setToken(userInfoCursor.getToken());
        userInfoBean.setPasswordHash(userInfoCursor.getPasswordHash());
        userInfoBean.setLoggedIn(userInfoCursor.getLoggedIn());
    }

    public boolean isEmpty(Context context) {
        int count = 0;
        UserInfoSelection userInfoSelection = new UserInfoSelection();
        UserInfoCursor c = userInfoSelection.query(context);
        while (c.moveToNext()) {
            count++;
        }
        c.close();
        return count == 0;
    }


    private UserInfoContentValues prepare() {
        UserInfoContentValues values = new UserInfoContentValues();
        values.putLoggedIn(userInfoBean.getLoggedIn());
        values.putUsername(userInfoBean.getUsername());
        values.putToken(userInfoBean.getToken());
        values.putType(userInfoBean.getType());
        values.putUid(userInfoBean.getUid());
        values.putPasswordHash(userInfoBean.getPasswordHash());
        return values;
    }

    public String getTitle() {
        return userInfoBean.getUsername();
    }

    public boolean isLoggedIn() {
        return userInfoBean.getLoggedIn();
    }

    public void setLoggedIn(Context context,boolean loggedIn) {
        userInfoBean.setLoggedIn(loggedIn);
        insertOrUpdate(context);
    }

    public void setTitle(Context context,String userName) {
        userInfoBean.setUsername(userName);
        insertOrUpdate(context);
    }

    public String getPasswordHash() {
        return userInfoBean.getPasswordHash();
    }


    public String getToken() {
        return userInfoBean.getToken();
    }
}
