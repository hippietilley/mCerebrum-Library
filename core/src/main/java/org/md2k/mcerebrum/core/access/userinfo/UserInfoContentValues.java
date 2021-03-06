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

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.md2k.mcerebrum.core.access.base.AbstractContentValues;

/**
 * User ContentProvider ContentValues class.
 * This class is auto-generated by Android ContentProvider Generator.
 * For more information see <a href="https://github.com/BoD/android-contentprovider-generator">GitHub</a>.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class UserInfoContentValues extends AbstractContentValues<UserInfoContentValues> {

    @Override
    protected Uri baseUri() {
        return UserInfoColumns.CONTENT_URI;
    }

    public int update(ContentResolver contentResolver, @Nullable UserInfoSelection where) {
        return contentResolver.update(uri(), values(),
                where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public int update(Context context, @Nullable UserInfoSelection where) {
        return context.getContentResolver().update(uri(), values(),
                where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public UserInfoContentValues putUid(@Nullable String value) {
        mContentValues.put(UserInfoColumns.UID, value);
        return this;
    }

    public UserInfoContentValues putUidNull() {
        mContentValues.putNull(UserInfoColumns.UID);
        return this;
    }

    public UserInfoContentValues putType(@Nullable String value) {
        mContentValues.put(UserInfoColumns.TYPE, value);
        return this;
    }

    public UserInfoContentValues putTypeNull() {
        mContentValues.putNull(UserInfoColumns.TYPE);
        return this;
    }

    public UserInfoContentValues putUsername(@Nullable String value) {
        mContentValues.put(UserInfoColumns.USERNAME, value);
        return this;
    }

    public UserInfoContentValues putUsernameNull() {
        mContentValues.putNull(UserInfoColumns.USERNAME);
        return this;
    }
}
