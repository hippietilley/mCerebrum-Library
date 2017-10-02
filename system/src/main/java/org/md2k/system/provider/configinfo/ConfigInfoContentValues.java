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
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.md2k.system.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code config_info} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class ConfigInfoContentValues extends AbstractContentValues<ConfigInfoContentValues> {
    @Override
    protected Uri baseUri() {
        return ConfigInfoColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable ConfigInfoSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable ConfigInfoSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public ConfigInfoContentValues putCid(@Nullable String value) {
        mContentValues.put(ConfigInfoColumns.CID, value);
        return this;
    }

    public ConfigInfoContentValues putCidNull() {
        mContentValues.putNull(ConfigInfoColumns.CID);
        return this;
    }

    public ConfigInfoContentValues putType(@Nullable String value) {
        mContentValues.put(ConfigInfoColumns.TYPE, value);
        return this;
    }

    public ConfigInfoContentValues putTypeNull() {
        mContentValues.putNull(ConfigInfoColumns.TYPE);
        return this;
    }

    public ConfigInfoContentValues putTitle(@Nullable String value) {
        mContentValues.put(ConfigInfoColumns.TITLE, value);
        return this;
    }

    public ConfigInfoContentValues putTitleNull() {
        mContentValues.putNull(ConfigInfoColumns.TITLE);
        return this;
    }

    public ConfigInfoContentValues putSummary(@Nullable String value) {
        mContentValues.put(ConfigInfoColumns.SUMMARY, value);
        return this;
    }

    public ConfigInfoContentValues putSummaryNull() {
        mContentValues.putNull(ConfigInfoColumns.SUMMARY);
        return this;
    }

    public ConfigInfoContentValues putDescription(@Nullable String value) {
        mContentValues.put(ConfigInfoColumns.DESCRIPTION, value);
        return this;
    }

    public ConfigInfoContentValues putDescriptionNull() {
        mContentValues.putNull(ConfigInfoColumns.DESCRIPTION);
        return this;
    }

    public ConfigInfoContentValues putVersions(@Nullable String value) {
        mContentValues.put(ConfigInfoColumns.VERSIONS, value);
        return this;
    }

    public ConfigInfoContentValues putVersionsNull() {
        mContentValues.putNull(ConfigInfoColumns.VERSIONS);
        return this;
    }

    public ConfigInfoContentValues putUpdates(@Nullable String value) {
        mContentValues.put(ConfigInfoColumns.UPDATES, value);
        return this;
    }

    public ConfigInfoContentValues putUpdatesNull() {
        mContentValues.putNull(ConfigInfoColumns.UPDATES);
        return this;
    }

    public ConfigInfoContentValues putExpectedVersion(@Nullable String value) {
        mContentValues.put(ConfigInfoColumns.EXPECTED_VERSION, value);
        return this;
    }

    public ConfigInfoContentValues putExpectedVersionNull() {
        mContentValues.putNull(ConfigInfoColumns.EXPECTED_VERSION);
        return this;
    }

    public ConfigInfoContentValues putLatestVersion(@Nullable String value) {
        mContentValues.put(ConfigInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public ConfigInfoContentValues putLatestVersionNull() {
        mContentValues.putNull(ConfigInfoColumns.LATEST_VERSION);
        return this;
    }

    public ConfigInfoContentValues putDownloadLink(@Nullable String value) {
        mContentValues.put(ConfigInfoColumns.DOWNLOAD_LINK, value);
        return this;
    }

    public ConfigInfoContentValues putDownloadLinkNull() {
        mContentValues.putNull(ConfigInfoColumns.DOWNLOAD_LINK);
        return this;
    }

    public ConfigInfoContentValues putLastUpdated(@Nullable Long value) {
        mContentValues.put(ConfigInfoColumns.LAST_UPDATED, value);
        return this;
    }

    public ConfigInfoContentValues putLastUpdatedNull() {
        mContentValues.putNull(ConfigInfoColumns.LAST_UPDATED);
        return this;
    }
}
