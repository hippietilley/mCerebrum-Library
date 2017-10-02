/*
 * This source is part of the
 *      _____  ___   ____
 *  __ / / _ \/ _ | / __/___  _______ _
 * / // / , _/ __ |/ _/_/ _ \/ __/ _ `/
 * \___/_/|_/_/ |_/_/ (_)___/_/  \_, /
 *                              /___/
 * repository.
 *
 * Copyright (C) 2012-2017 Benoit 'BoD' Lubek (BoD@JRAF.org)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.md2k.system.provider.userinfo;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.md2k.system.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code user_info} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class UserInfoContentValues extends AbstractContentValues<UserInfoContentValues> {
    @Override
    protected Uri baseUri() {
        return UserInfoColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable UserInfoSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable UserInfoSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
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

    public UserInfoContentValues putLoggedIn(@Nullable Boolean value) {
        mContentValues.put(UserInfoColumns.LOGGED_IN, value);
        return this;
    }

    public UserInfoContentValues putLoggedInNull() {
        mContentValues.putNull(UserInfoColumns.LOGGED_IN);
        return this;
    }

    public UserInfoContentValues putToken(@Nullable String value) {
        mContentValues.put(UserInfoColumns.TOKEN, value);
        return this;
    }

    public UserInfoContentValues putTokenNull() {
        mContentValues.putNull(UserInfoColumns.TOKEN);
        return this;
    }

    public UserInfoContentValues putPasswordHash(@Nullable String value) {
        mContentValues.put(UserInfoColumns.PASSWORD_HASH, value);
        return this;
    }

    public UserInfoContentValues putPasswordHashNull() {
        mContentValues.putNull(UserInfoColumns.PASSWORD_HASH);
        return this;
    }
}
