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
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.CursorLoader;

import org.md2k.system.provider.base.AbstractSelection;

/**
 * Selection for the {@code user_info} table.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class UserInfoSelection extends AbstractSelection<UserInfoSelection> {
    @Override
    protected Uri baseUri() {
        return UserInfoColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code UserInfoCursor} object, which is positioned before the first entry, or null.
     */
    public UserInfoCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new UserInfoCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public UserInfoCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code UserInfoCursor} object, which is positioned before the first entry, or null.
     */
    public UserInfoCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new UserInfoCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public UserInfoCursor query(Context context) {
        return query(context, null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public CursorLoader getCursorLoader(Context context, String[] projection) {
        return new CursorLoader(context, uri(), projection, sel(), args(), order()) {
            @Override
            public Cursor loadInBackground() {
                return new UserInfoCursor(super.loadInBackground());
            }
        };
    }


    public UserInfoSelection id(long... value) {
        addEquals("user_info." + UserInfoColumns._ID, toObjectArray(value));
        return this;
    }

    public UserInfoSelection idNot(long... value) {
        addNotEquals("user_info." + UserInfoColumns._ID, toObjectArray(value));
        return this;
    }

    public UserInfoSelection orderById(boolean desc) {
        orderBy("user_info." + UserInfoColumns._ID, desc);
        return this;
    }

    public UserInfoSelection orderById() {
        return orderById(false);
    }

    public UserInfoSelection uid(String... value) {
        addEquals(UserInfoColumns.UID, value);
        return this;
    }

    public UserInfoSelection uidNot(String... value) {
        addNotEquals(UserInfoColumns.UID, value);
        return this;
    }

    public UserInfoSelection uidLike(String... value) {
        addLike(UserInfoColumns.UID, value);
        return this;
    }

    public UserInfoSelection uidContains(String... value) {
        addContains(UserInfoColumns.UID, value);
        return this;
    }

    public UserInfoSelection uidStartsWith(String... value) {
        addStartsWith(UserInfoColumns.UID, value);
        return this;
    }

    public UserInfoSelection uidEndsWith(String... value) {
        addEndsWith(UserInfoColumns.UID, value);
        return this;
    }

    public UserInfoSelection orderByUid(boolean desc) {
        orderBy(UserInfoColumns.UID, desc);
        return this;
    }

    public UserInfoSelection orderByUid() {
        orderBy(UserInfoColumns.UID, false);
        return this;
    }

    public UserInfoSelection type(String... value) {
        addEquals(UserInfoColumns.TYPE, value);
        return this;
    }

    public UserInfoSelection typeNot(String... value) {
        addNotEquals(UserInfoColumns.TYPE, value);
        return this;
    }

    public UserInfoSelection typeLike(String... value) {
        addLike(UserInfoColumns.TYPE, value);
        return this;
    }

    public UserInfoSelection typeContains(String... value) {
        addContains(UserInfoColumns.TYPE, value);
        return this;
    }

    public UserInfoSelection typeStartsWith(String... value) {
        addStartsWith(UserInfoColumns.TYPE, value);
        return this;
    }

    public UserInfoSelection typeEndsWith(String... value) {
        addEndsWith(UserInfoColumns.TYPE, value);
        return this;
    }

    public UserInfoSelection orderByType(boolean desc) {
        orderBy(UserInfoColumns.TYPE, desc);
        return this;
    }

    public UserInfoSelection orderByType() {
        orderBy(UserInfoColumns.TYPE, false);
        return this;
    }

    public UserInfoSelection username(String... value) {
        addEquals(UserInfoColumns.USERNAME, value);
        return this;
    }

    public UserInfoSelection usernameNot(String... value) {
        addNotEquals(UserInfoColumns.USERNAME, value);
        return this;
    }

    public UserInfoSelection usernameLike(String... value) {
        addLike(UserInfoColumns.USERNAME, value);
        return this;
    }

    public UserInfoSelection usernameContains(String... value) {
        addContains(UserInfoColumns.USERNAME, value);
        return this;
    }

    public UserInfoSelection usernameStartsWith(String... value) {
        addStartsWith(UserInfoColumns.USERNAME, value);
        return this;
    }

    public UserInfoSelection usernameEndsWith(String... value) {
        addEndsWith(UserInfoColumns.USERNAME, value);
        return this;
    }

    public UserInfoSelection orderByUsername(boolean desc) {
        orderBy(UserInfoColumns.USERNAME, desc);
        return this;
    }

    public UserInfoSelection orderByUsername() {
        orderBy(UserInfoColumns.USERNAME, false);
        return this;
    }

    public UserInfoSelection loggedIn(Boolean value) {
        addEquals(UserInfoColumns.LOGGED_IN, toObjectArray(value));
        return this;
    }

    public UserInfoSelection orderByLoggedIn(boolean desc) {
        orderBy(UserInfoColumns.LOGGED_IN, desc);
        return this;
    }

    public UserInfoSelection orderByLoggedIn() {
        orderBy(UserInfoColumns.LOGGED_IN, false);
        return this;
    }

    public UserInfoSelection token(String... value) {
        addEquals(UserInfoColumns.TOKEN, value);
        return this;
    }

    public UserInfoSelection tokenNot(String... value) {
        addNotEquals(UserInfoColumns.TOKEN, value);
        return this;
    }

    public UserInfoSelection tokenLike(String... value) {
        addLike(UserInfoColumns.TOKEN, value);
        return this;
    }

    public UserInfoSelection tokenContains(String... value) {
        addContains(UserInfoColumns.TOKEN, value);
        return this;
    }

    public UserInfoSelection tokenStartsWith(String... value) {
        addStartsWith(UserInfoColumns.TOKEN, value);
        return this;
    }

    public UserInfoSelection tokenEndsWith(String... value) {
        addEndsWith(UserInfoColumns.TOKEN, value);
        return this;
    }

    public UserInfoSelection orderByToken(boolean desc) {
        orderBy(UserInfoColumns.TOKEN, desc);
        return this;
    }

    public UserInfoSelection orderByToken() {
        orderBy(UserInfoColumns.TOKEN, false);
        return this;
    }

    public UserInfoSelection passwordHash(String... value) {
        addEquals(UserInfoColumns.PASSWORD_HASH, value);
        return this;
    }

    public UserInfoSelection passwordHashNot(String... value) {
        addNotEquals(UserInfoColumns.PASSWORD_HASH, value);
        return this;
    }

    public UserInfoSelection passwordHashLike(String... value) {
        addLike(UserInfoColumns.PASSWORD_HASH, value);
        return this;
    }

    public UserInfoSelection passwordHashContains(String... value) {
        addContains(UserInfoColumns.PASSWORD_HASH, value);
        return this;
    }

    public UserInfoSelection passwordHashStartsWith(String... value) {
        addStartsWith(UserInfoColumns.PASSWORD_HASH, value);
        return this;
    }

    public UserInfoSelection passwordHashEndsWith(String... value) {
        addEndsWith(UserInfoColumns.PASSWORD_HASH, value);
        return this;
    }

    public UserInfoSelection orderByPasswordHash(boolean desc) {
        orderBy(UserInfoColumns.PASSWORD_HASH, desc);
        return this;
    }

    public UserInfoSelection orderByPasswordHash() {
        orderBy(UserInfoColumns.PASSWORD_HASH, false);
        return this;
    }
}
