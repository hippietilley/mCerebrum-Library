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
package org.md2k.system.provider.serverinfo;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.CursorLoader;

import org.md2k.system.provider.base.AbstractSelection;

/**
 * Selection for the {@code server_info} table.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class ServerInfoSelection extends AbstractSelection<ServerInfoSelection> {
    @Override
    protected Uri baseUri() {
        return ServerInfoColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code ServerInfoCursor} object, which is positioned before the first entry, or null.
     */
    public ServerInfoCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new ServerInfoCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public ServerInfoCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code ServerInfoCursor} object, which is positioned before the first entry, or null.
     */
    public ServerInfoCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new ServerInfoCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public ServerInfoCursor query(Context context) {
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
                return new ServerInfoCursor(super.loadInBackground());
            }
        };
    }


    public ServerInfoSelection id(long... value) {
        addEquals("server_info." + ServerInfoColumns._ID, toObjectArray(value));
        return this;
    }

    public ServerInfoSelection idNot(long... value) {
        addNotEquals("server_info." + ServerInfoColumns._ID, toObjectArray(value));
        return this;
    }

    public ServerInfoSelection orderById(boolean desc) {
        orderBy("server_info." + ServerInfoColumns._ID, desc);
        return this;
    }

    public ServerInfoSelection orderById() {
        return orderById(false);
    }

    public ServerInfoSelection serverAddress(String... value) {
        addEquals(ServerInfoColumns.SERVER_ADDRESS, value);
        return this;
    }

    public ServerInfoSelection serverAddressNot(String... value) {
        addNotEquals(ServerInfoColumns.SERVER_ADDRESS, value);
        return this;
    }

    public ServerInfoSelection serverAddressLike(String... value) {
        addLike(ServerInfoColumns.SERVER_ADDRESS, value);
        return this;
    }

    public ServerInfoSelection serverAddressContains(String... value) {
        addContains(ServerInfoColumns.SERVER_ADDRESS, value);
        return this;
    }

    public ServerInfoSelection serverAddressStartsWith(String... value) {
        addStartsWith(ServerInfoColumns.SERVER_ADDRESS, value);
        return this;
    }

    public ServerInfoSelection serverAddressEndsWith(String... value) {
        addEndsWith(ServerInfoColumns.SERVER_ADDRESS, value);
        return this;
    }

    public ServerInfoSelection orderByServerAddress(boolean desc) {
        orderBy(ServerInfoColumns.SERVER_ADDRESS, desc);
        return this;
    }

    public ServerInfoSelection orderByServerAddress() {
        orderBy(ServerInfoColumns.SERVER_ADDRESS, false);
        return this;
    }

    public ServerInfoSelection username(String... value) {
        addEquals(ServerInfoColumns.USERNAME, value);
        return this;
    }

    public ServerInfoSelection usernameNot(String... value) {
        addNotEquals(ServerInfoColumns.USERNAME, value);
        return this;
    }

    public ServerInfoSelection usernameLike(String... value) {
        addLike(ServerInfoColumns.USERNAME, value);
        return this;
    }

    public ServerInfoSelection usernameContains(String... value) {
        addContains(ServerInfoColumns.USERNAME, value);
        return this;
    }

    public ServerInfoSelection usernameStartsWith(String... value) {
        addStartsWith(ServerInfoColumns.USERNAME, value);
        return this;
    }

    public ServerInfoSelection usernameEndsWith(String... value) {
        addEndsWith(ServerInfoColumns.USERNAME, value);
        return this;
    }

    public ServerInfoSelection orderByUsername(boolean desc) {
        orderBy(ServerInfoColumns.USERNAME, desc);
        return this;
    }

    public ServerInfoSelection orderByUsername() {
        orderBy(ServerInfoColumns.USERNAME, false);
        return this;
    }

    public ServerInfoSelection uuid(String... value) {
        addEquals(ServerInfoColumns.UUID, value);
        return this;
    }

    public ServerInfoSelection uuidNot(String... value) {
        addNotEquals(ServerInfoColumns.UUID, value);
        return this;
    }

    public ServerInfoSelection uuidLike(String... value) {
        addLike(ServerInfoColumns.UUID, value);
        return this;
    }

    public ServerInfoSelection uuidContains(String... value) {
        addContains(ServerInfoColumns.UUID, value);
        return this;
    }

    public ServerInfoSelection uuidStartsWith(String... value) {
        addStartsWith(ServerInfoColumns.UUID, value);
        return this;
    }

    public ServerInfoSelection uuidEndsWith(String... value) {
        addEndsWith(ServerInfoColumns.UUID, value);
        return this;
    }

    public ServerInfoSelection orderByUuid(boolean desc) {
        orderBy(ServerInfoColumns.UUID, desc);
        return this;
    }

    public ServerInfoSelection orderByUuid() {
        orderBy(ServerInfoColumns.UUID, false);
        return this;
    }

    public ServerInfoSelection passwordHash(String... value) {
        addEquals(ServerInfoColumns.PASSWORD_HASH, value);
        return this;
    }

    public ServerInfoSelection passwordHashNot(String... value) {
        addNotEquals(ServerInfoColumns.PASSWORD_HASH, value);
        return this;
    }

    public ServerInfoSelection passwordHashLike(String... value) {
        addLike(ServerInfoColumns.PASSWORD_HASH, value);
        return this;
    }

    public ServerInfoSelection passwordHashContains(String... value) {
        addContains(ServerInfoColumns.PASSWORD_HASH, value);
        return this;
    }

    public ServerInfoSelection passwordHashStartsWith(String... value) {
        addStartsWith(ServerInfoColumns.PASSWORD_HASH, value);
        return this;
    }

    public ServerInfoSelection passwordHashEndsWith(String... value) {
        addEndsWith(ServerInfoColumns.PASSWORD_HASH, value);
        return this;
    }

    public ServerInfoSelection orderByPasswordHash(boolean desc) {
        orderBy(ServerInfoColumns.PASSWORD_HASH, desc);
        return this;
    }

    public ServerInfoSelection orderByPasswordHash() {
        orderBy(ServerInfoColumns.PASSWORD_HASH, false);
        return this;
    }

    public ServerInfoSelection token(String... value) {
        addEquals(ServerInfoColumns.TOKEN, value);
        return this;
    }

    public ServerInfoSelection tokenNot(String... value) {
        addNotEquals(ServerInfoColumns.TOKEN, value);
        return this;
    }

    public ServerInfoSelection tokenLike(String... value) {
        addLike(ServerInfoColumns.TOKEN, value);
        return this;
    }

    public ServerInfoSelection tokenContains(String... value) {
        addContains(ServerInfoColumns.TOKEN, value);
        return this;
    }

    public ServerInfoSelection tokenStartsWith(String... value) {
        addStartsWith(ServerInfoColumns.TOKEN, value);
        return this;
    }

    public ServerInfoSelection tokenEndsWith(String... value) {
        addEndsWith(ServerInfoColumns.TOKEN, value);
        return this;
    }

    public ServerInfoSelection orderByToken(boolean desc) {
        orderBy(ServerInfoColumns.TOKEN, desc);
        return this;
    }

    public ServerInfoSelection orderByToken() {
        orderBy(ServerInfoColumns.TOKEN, false);
        return this;
    }

    public ServerInfoSelection fileName(String... value) {
        addEquals(ServerInfoColumns.FILE_NAME, value);
        return this;
    }

    public ServerInfoSelection fileNameNot(String... value) {
        addNotEquals(ServerInfoColumns.FILE_NAME, value);
        return this;
    }

    public ServerInfoSelection fileNameLike(String... value) {
        addLike(ServerInfoColumns.FILE_NAME, value);
        return this;
    }

    public ServerInfoSelection fileNameContains(String... value) {
        addContains(ServerInfoColumns.FILE_NAME, value);
        return this;
    }

    public ServerInfoSelection fileNameStartsWith(String... value) {
        addStartsWith(ServerInfoColumns.FILE_NAME, value);
        return this;
    }

    public ServerInfoSelection fileNameEndsWith(String... value) {
        addEndsWith(ServerInfoColumns.FILE_NAME, value);
        return this;
    }

    public ServerInfoSelection orderByFileName(boolean desc) {
        orderBy(ServerInfoColumns.FILE_NAME, desc);
        return this;
    }

    public ServerInfoSelection orderByFileName() {
        orderBy(ServerInfoColumns.FILE_NAME, false);
        return this;
    }

    public ServerInfoSelection currentVersion(String... value) {
        addEquals(ServerInfoColumns.CURRENT_VERSION, value);
        return this;
    }

    public ServerInfoSelection currentVersionNot(String... value) {
        addNotEquals(ServerInfoColumns.CURRENT_VERSION, value);
        return this;
    }

    public ServerInfoSelection currentVersionLike(String... value) {
        addLike(ServerInfoColumns.CURRENT_VERSION, value);
        return this;
    }

    public ServerInfoSelection currentVersionContains(String... value) {
        addContains(ServerInfoColumns.CURRENT_VERSION, value);
        return this;
    }

    public ServerInfoSelection currentVersionStartsWith(String... value) {
        addStartsWith(ServerInfoColumns.CURRENT_VERSION, value);
        return this;
    }

    public ServerInfoSelection currentVersionEndsWith(String... value) {
        addEndsWith(ServerInfoColumns.CURRENT_VERSION, value);
        return this;
    }

    public ServerInfoSelection orderByCurrentVersion(boolean desc) {
        orderBy(ServerInfoColumns.CURRENT_VERSION, desc);
        return this;
    }

    public ServerInfoSelection orderByCurrentVersion() {
        orderBy(ServerInfoColumns.CURRENT_VERSION, false);
        return this;
    }

    public ServerInfoSelection latestVersion(String... value) {
        addEquals(ServerInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public ServerInfoSelection latestVersionNot(String... value) {
        addNotEquals(ServerInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public ServerInfoSelection latestVersionLike(String... value) {
        addLike(ServerInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public ServerInfoSelection latestVersionContains(String... value) {
        addContains(ServerInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public ServerInfoSelection latestVersionStartsWith(String... value) {
        addStartsWith(ServerInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public ServerInfoSelection latestVersionEndsWith(String... value) {
        addEndsWith(ServerInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public ServerInfoSelection orderByLatestVersion(boolean desc) {
        orderBy(ServerInfoColumns.LATEST_VERSION, desc);
        return this;
    }

    public ServerInfoSelection orderByLatestVersion() {
        orderBy(ServerInfoColumns.LATEST_VERSION, false);
        return this;
    }
}
