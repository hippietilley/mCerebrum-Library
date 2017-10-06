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
package org.md2k.system.provider.configinfo;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.CursorLoader;

import org.md2k.system.provider.base.AbstractSelection;

/**
 * Selection for the {@code config_info} table.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class ConfigInfoSelection extends AbstractSelection<ConfigInfoSelection> {
    @Override
    protected Uri baseUri() {
        return ConfigInfoColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code ConfigInfoCursor} object, which is positioned before the first entry, or null.
     */
    public ConfigInfoCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new ConfigInfoCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public ConfigInfoCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code ConfigInfoCursor} object, which is positioned before the first entry, or null.
     */
    public ConfigInfoCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new ConfigInfoCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public ConfigInfoCursor query(Context context) {
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
                return new ConfigInfoCursor(super.loadInBackground());
            }
        };
    }


    public ConfigInfoSelection id(long... value) {
        addEquals("config_info." + ConfigInfoColumns._ID, toObjectArray(value));
        return this;
    }

    public ConfigInfoSelection idNot(long... value) {
        addNotEquals("config_info." + ConfigInfoColumns._ID, toObjectArray(value));
        return this;
    }

    public ConfigInfoSelection orderById(boolean desc) {
        orderBy("config_info." + ConfigInfoColumns._ID, desc);
        return this;
    }

    public ConfigInfoSelection orderById() {
        return orderById(false);
    }

    public ConfigInfoSelection cid(String... value) {
        addEquals(ConfigInfoColumns.CID, value);
        return this;
    }

    public ConfigInfoSelection cidNot(String... value) {
        addNotEquals(ConfigInfoColumns.CID, value);
        return this;
    }

    public ConfigInfoSelection cidLike(String... value) {
        addLike(ConfigInfoColumns.CID, value);
        return this;
    }

    public ConfigInfoSelection cidContains(String... value) {
        addContains(ConfigInfoColumns.CID, value);
        return this;
    }

    public ConfigInfoSelection cidStartsWith(String... value) {
        addStartsWith(ConfigInfoColumns.CID, value);
        return this;
    }

    public ConfigInfoSelection cidEndsWith(String... value) {
        addEndsWith(ConfigInfoColumns.CID, value);
        return this;
    }

    public ConfigInfoSelection orderByCid(boolean desc) {
        orderBy(ConfigInfoColumns.CID, desc);
        return this;
    }

    public ConfigInfoSelection orderByCid() {
        orderBy(ConfigInfoColumns.CID, false);
        return this;
    }

    public ConfigInfoSelection type(String... value) {
        addEquals(ConfigInfoColumns.TYPE, value);
        return this;
    }

    public ConfigInfoSelection typeNot(String... value) {
        addNotEquals(ConfigInfoColumns.TYPE, value);
        return this;
    }

    public ConfigInfoSelection typeLike(String... value) {
        addLike(ConfigInfoColumns.TYPE, value);
        return this;
    }

    public ConfigInfoSelection typeContains(String... value) {
        addContains(ConfigInfoColumns.TYPE, value);
        return this;
    }

    public ConfigInfoSelection typeStartsWith(String... value) {
        addStartsWith(ConfigInfoColumns.TYPE, value);
        return this;
    }

    public ConfigInfoSelection typeEndsWith(String... value) {
        addEndsWith(ConfigInfoColumns.TYPE, value);
        return this;
    }

    public ConfigInfoSelection orderByType(boolean desc) {
        orderBy(ConfigInfoColumns.TYPE, desc);
        return this;
    }

    public ConfigInfoSelection orderByType() {
        orderBy(ConfigInfoColumns.TYPE, false);
        return this;
    }

    public ConfigInfoSelection title(String... value) {
        addEquals(ConfigInfoColumns.TITLE, value);
        return this;
    }

    public ConfigInfoSelection titleNot(String... value) {
        addNotEquals(ConfigInfoColumns.TITLE, value);
        return this;
    }

    public ConfigInfoSelection titleLike(String... value) {
        addLike(ConfigInfoColumns.TITLE, value);
        return this;
    }

    public ConfigInfoSelection titleContains(String... value) {
        addContains(ConfigInfoColumns.TITLE, value);
        return this;
    }

    public ConfigInfoSelection titleStartsWith(String... value) {
        addStartsWith(ConfigInfoColumns.TITLE, value);
        return this;
    }

    public ConfigInfoSelection titleEndsWith(String... value) {
        addEndsWith(ConfigInfoColumns.TITLE, value);
        return this;
    }

    public ConfigInfoSelection orderByTitle(boolean desc) {
        orderBy(ConfigInfoColumns.TITLE, desc);
        return this;
    }

    public ConfigInfoSelection orderByTitle() {
        orderBy(ConfigInfoColumns.TITLE, false);
        return this;
    }

    public ConfigInfoSelection summary(String... value) {
        addEquals(ConfigInfoColumns.SUMMARY, value);
        return this;
    }

    public ConfigInfoSelection summaryNot(String... value) {
        addNotEquals(ConfigInfoColumns.SUMMARY, value);
        return this;
    }

    public ConfigInfoSelection summaryLike(String... value) {
        addLike(ConfigInfoColumns.SUMMARY, value);
        return this;
    }

    public ConfigInfoSelection summaryContains(String... value) {
        addContains(ConfigInfoColumns.SUMMARY, value);
        return this;
    }

    public ConfigInfoSelection summaryStartsWith(String... value) {
        addStartsWith(ConfigInfoColumns.SUMMARY, value);
        return this;
    }

    public ConfigInfoSelection summaryEndsWith(String... value) {
        addEndsWith(ConfigInfoColumns.SUMMARY, value);
        return this;
    }

    public ConfigInfoSelection orderBySummary(boolean desc) {
        orderBy(ConfigInfoColumns.SUMMARY, desc);
        return this;
    }

    public ConfigInfoSelection orderBySummary() {
        orderBy(ConfigInfoColumns.SUMMARY, false);
        return this;
    }

    public ConfigInfoSelection description(String... value) {
        addEquals(ConfigInfoColumns.DESCRIPTION, value);
        return this;
    }

    public ConfigInfoSelection descriptionNot(String... value) {
        addNotEquals(ConfigInfoColumns.DESCRIPTION, value);
        return this;
    }

    public ConfigInfoSelection descriptionLike(String... value) {
        addLike(ConfigInfoColumns.DESCRIPTION, value);
        return this;
    }

    public ConfigInfoSelection descriptionContains(String... value) {
        addContains(ConfigInfoColumns.DESCRIPTION, value);
        return this;
    }

    public ConfigInfoSelection descriptionStartsWith(String... value) {
        addStartsWith(ConfigInfoColumns.DESCRIPTION, value);
        return this;
    }

    public ConfigInfoSelection descriptionEndsWith(String... value) {
        addEndsWith(ConfigInfoColumns.DESCRIPTION, value);
        return this;
    }

    public ConfigInfoSelection orderByDescription(boolean desc) {
        orderBy(ConfigInfoColumns.DESCRIPTION, desc);
        return this;
    }

    public ConfigInfoSelection orderByDescription() {
        orderBy(ConfigInfoColumns.DESCRIPTION, false);
        return this;
    }

    public ConfigInfoSelection versions(String... value) {
        addEquals(ConfigInfoColumns.VERSIONS, value);
        return this;
    }

    public ConfigInfoSelection versionsNot(String... value) {
        addNotEquals(ConfigInfoColumns.VERSIONS, value);
        return this;
    }

    public ConfigInfoSelection versionsLike(String... value) {
        addLike(ConfigInfoColumns.VERSIONS, value);
        return this;
    }

    public ConfigInfoSelection versionsContains(String... value) {
        addContains(ConfigInfoColumns.VERSIONS, value);
        return this;
    }

    public ConfigInfoSelection versionsStartsWith(String... value) {
        addStartsWith(ConfigInfoColumns.VERSIONS, value);
        return this;
    }

    public ConfigInfoSelection versionsEndsWith(String... value) {
        addEndsWith(ConfigInfoColumns.VERSIONS, value);
        return this;
    }

    public ConfigInfoSelection orderByVersions(boolean desc) {
        orderBy(ConfigInfoColumns.VERSIONS, desc);
        return this;
    }

    public ConfigInfoSelection orderByVersions() {
        orderBy(ConfigInfoColumns.VERSIONS, false);
        return this;
    }

    public ConfigInfoSelection updates(String... value) {
        addEquals(ConfigInfoColumns.UPDATES, value);
        return this;
    }

    public ConfigInfoSelection updatesNot(String... value) {
        addNotEquals(ConfigInfoColumns.UPDATES, value);
        return this;
    }

    public ConfigInfoSelection updatesLike(String... value) {
        addLike(ConfigInfoColumns.UPDATES, value);
        return this;
    }

    public ConfigInfoSelection updatesContains(String... value) {
        addContains(ConfigInfoColumns.UPDATES, value);
        return this;
    }

    public ConfigInfoSelection updatesStartsWith(String... value) {
        addStartsWith(ConfigInfoColumns.UPDATES, value);
        return this;
    }

    public ConfigInfoSelection updatesEndsWith(String... value) {
        addEndsWith(ConfigInfoColumns.UPDATES, value);
        return this;
    }

    public ConfigInfoSelection orderByUpdates(boolean desc) {
        orderBy(ConfigInfoColumns.UPDATES, desc);
        return this;
    }

    public ConfigInfoSelection orderByUpdates() {
        orderBy(ConfigInfoColumns.UPDATES, false);
        return this;
    }

    public ConfigInfoSelection expectedVersion(String... value) {
        addEquals(ConfigInfoColumns.EXPECTED_VERSION, value);
        return this;
    }

    public ConfigInfoSelection expectedVersionNot(String... value) {
        addNotEquals(ConfigInfoColumns.EXPECTED_VERSION, value);
        return this;
    }

    public ConfigInfoSelection expectedVersionLike(String... value) {
        addLike(ConfigInfoColumns.EXPECTED_VERSION, value);
        return this;
    }

    public ConfigInfoSelection expectedVersionContains(String... value) {
        addContains(ConfigInfoColumns.EXPECTED_VERSION, value);
        return this;
    }

    public ConfigInfoSelection expectedVersionStartsWith(String... value) {
        addStartsWith(ConfigInfoColumns.EXPECTED_VERSION, value);
        return this;
    }

    public ConfigInfoSelection expectedVersionEndsWith(String... value) {
        addEndsWith(ConfigInfoColumns.EXPECTED_VERSION, value);
        return this;
    }

    public ConfigInfoSelection orderByExpectedVersion(boolean desc) {
        orderBy(ConfigInfoColumns.EXPECTED_VERSION, desc);
        return this;
    }

    public ConfigInfoSelection orderByExpectedVersion() {
        orderBy(ConfigInfoColumns.EXPECTED_VERSION, false);
        return this;
    }

    public ConfigInfoSelection latestVersion(String... value) {
        addEquals(ConfigInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public ConfigInfoSelection latestVersionNot(String... value) {
        addNotEquals(ConfigInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public ConfigInfoSelection latestVersionLike(String... value) {
        addLike(ConfigInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public ConfigInfoSelection latestVersionContains(String... value) {
        addContains(ConfigInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public ConfigInfoSelection latestVersionStartsWith(String... value) {
        addStartsWith(ConfigInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public ConfigInfoSelection latestVersionEndsWith(String... value) {
        addEndsWith(ConfigInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public ConfigInfoSelection orderByLatestVersion(boolean desc) {
        orderBy(ConfigInfoColumns.LATEST_VERSION, desc);
        return this;
    }

    public ConfigInfoSelection orderByLatestVersion() {
        orderBy(ConfigInfoColumns.LATEST_VERSION, false);
        return this;
    }

    public ConfigInfoSelection downloadLink(String... value) {
        addEquals(ConfigInfoColumns.DOWNLOAD_LINK, value);
        return this;
    }

    public ConfigInfoSelection downloadLinkNot(String... value) {
        addNotEquals(ConfigInfoColumns.DOWNLOAD_LINK, value);
        return this;
    }

    public ConfigInfoSelection downloadLinkLike(String... value) {
        addLike(ConfigInfoColumns.DOWNLOAD_LINK, value);
        return this;
    }

    public ConfigInfoSelection downloadLinkContains(String... value) {
        addContains(ConfigInfoColumns.DOWNLOAD_LINK, value);
        return this;
    }

    public ConfigInfoSelection downloadLinkStartsWith(String... value) {
        addStartsWith(ConfigInfoColumns.DOWNLOAD_LINK, value);
        return this;
    }

    public ConfigInfoSelection downloadLinkEndsWith(String... value) {
        addEndsWith(ConfigInfoColumns.DOWNLOAD_LINK, value);
        return this;
    }

    public ConfigInfoSelection orderByDownloadLink(boolean desc) {
        orderBy(ConfigInfoColumns.DOWNLOAD_LINK, desc);
        return this;
    }

    public ConfigInfoSelection orderByDownloadLink() {
        orderBy(ConfigInfoColumns.DOWNLOAD_LINK, false);
        return this;
    }

    public ConfigInfoSelection lastUpdated(String... value) {
        addEquals(ConfigInfoColumns.LAST_UPDATED, value);
        return this;
    }

    public ConfigInfoSelection lastUpdatedNot(String... value) {
        addNotEquals(ConfigInfoColumns.LAST_UPDATED, value);
        return this;
    }

    public ConfigInfoSelection lastUpdatedLike(String... value) {
        addLike(ConfigInfoColumns.LAST_UPDATED, value);
        return this;
    }

    public ConfigInfoSelection lastUpdatedContains(String... value) {
        addContains(ConfigInfoColumns.LAST_UPDATED, value);
        return this;
    }

    public ConfigInfoSelection lastUpdatedStartsWith(String... value) {
        addStartsWith(ConfigInfoColumns.LAST_UPDATED, value);
        return this;
    }

    public ConfigInfoSelection lastUpdatedEndsWith(String... value) {
        addEndsWith(ConfigInfoColumns.LAST_UPDATED, value);
        return this;
    }

    public ConfigInfoSelection orderByLastUpdated(boolean desc) {
        orderBy(ConfigInfoColumns.LAST_UPDATED, desc);
        return this;
    }

    public ConfigInfoSelection orderByLastUpdated() {
        orderBy(ConfigInfoColumns.LAST_UPDATED, false);
        return this;
    }

    public ConfigInfoSelection fileName(String... value) {
        addEquals(ConfigInfoColumns.FILE_NAME, value);
        return this;
    }

    public ConfigInfoSelection fileNameNot(String... value) {
        addNotEquals(ConfigInfoColumns.FILE_NAME, value);
        return this;
    }

    public ConfigInfoSelection fileNameLike(String... value) {
        addLike(ConfigInfoColumns.FILE_NAME, value);
        return this;
    }

    public ConfigInfoSelection fileNameContains(String... value) {
        addContains(ConfigInfoColumns.FILE_NAME, value);
        return this;
    }

    public ConfigInfoSelection fileNameStartsWith(String... value) {
        addStartsWith(ConfigInfoColumns.FILE_NAME, value);
        return this;
    }

    public ConfigInfoSelection fileNameEndsWith(String... value) {
        addEndsWith(ConfigInfoColumns.FILE_NAME, value);
        return this;
    }

    public ConfigInfoSelection orderByFileName(boolean desc) {
        orderBy(ConfigInfoColumns.FILE_NAME, desc);
        return this;
    }

    public ConfigInfoSelection orderByFileName() {
        orderBy(ConfigInfoColumns.FILE_NAME, false);
        return this;
    }
}
