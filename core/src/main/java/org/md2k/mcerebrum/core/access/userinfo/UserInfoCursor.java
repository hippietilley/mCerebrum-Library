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

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.md2k.mcerebrum.core.access.base.AbstractCursor;

/**
 * Cursor wrapper for the user info table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class UserInfoCursor extends AbstractCursor implements UserInfoModel {
    /**
     * Constructor
     *
     * @param cursor
     */
    public UserInfoCursor(Cursor cursor) {
        super(cursor);
    }


    /**
     * Returns the user identifier (Primary key).
     * @return The user identifier (Primary key).
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(UserInfoColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is " +
                    "not allowed according to the model definition");
        return res;
    }

    /**
     * Returns the UID (Can be null).
     * @return The UID (Can be null).
     */
    @Nullable
    @Override
    public String getUid() {
        String res = getStringOrNull(UserInfoColumns.UID);
        return res;
    }

    /**
     * Returns the user type (Can be null).
     * @return The user type (Can be null).
     */
    @Nullable
    @Override
    public String getType() {
        String res = getStringOrNull(UserInfoColumns.TYPE);
        return res;
    }

    /**
     * Returns the username (Can be null).
     * @return The username (Can be null).
     */
    @Nullable
    @Override
    public String getUsername() {
        String res = getStringOrNull(UserInfoColumns.USERNAME);
        return res;
    }
}
