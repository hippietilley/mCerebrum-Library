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

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.md2k.system.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code user_info} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class UserInfoCursor extends AbstractCursor implements UserInfoModel {
    public UserInfoCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(UserInfoColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code uid} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getUid() {
        String res = getStringOrNull(UserInfoColumns.UID);
        return res;
    }

    /**
     * Get the {@code type} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getType() {
        String res = getStringOrNull(UserInfoColumns.TYPE);
        return res;
    }

    /**
     * Get the {@code username} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getUsername() {
        String res = getStringOrNull(UserInfoColumns.USERNAME);
        return res;
    }

    /**
     * Get the {@code logged_in} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getLoggedIn() {
        Boolean res = getBooleanOrNull(UserInfoColumns.LOGGED_IN);
        return res;
    }

    /**
     * Get the {@code token} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getToken() {
        String res = getStringOrNull(UserInfoColumns.TOKEN);
        return res;
    }

    /**
     * Get the {@code password_hash} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPasswordHash() {
        String res = getStringOrNull(UserInfoColumns.PASSWORD_HASH);
        return res;
    }
}
