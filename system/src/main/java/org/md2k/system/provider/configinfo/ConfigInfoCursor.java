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

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.md2k.system.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code config_info} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class ConfigInfoCursor extends AbstractCursor implements ConfigInfoModel {
    public ConfigInfoCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(ConfigInfoColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code cid} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getCid() {
        String res = getStringOrNull(ConfigInfoColumns.CID);
        return res;
    }

    /**
     * Get the {@code type} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getType() {
        String res = getStringOrNull(ConfigInfoColumns.TYPE);
        return res;
    }

    /**
     * Get the {@code title} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTitle() {
        String res = getStringOrNull(ConfigInfoColumns.TITLE);
        return res;
    }

    /**
     * Get the {@code summary} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getSummary() {
        String res = getStringOrNull(ConfigInfoColumns.SUMMARY);
        return res;
    }

    /**
     * Get the {@code description} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDescription() {
        String res = getStringOrNull(ConfigInfoColumns.DESCRIPTION);
        return res;
    }

    /**
     * Get the {@code versions} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getVersions() {
        String res = getStringOrNull(ConfigInfoColumns.VERSIONS);
        return res;
    }

    /**
     * Get the {@code updates} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getUpdates() {
        String res = getStringOrNull(ConfigInfoColumns.UPDATES);
        return res;
    }

    /**
     * Get the {@code expected_version} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getExpectedVersion() {
        String res = getStringOrNull(ConfigInfoColumns.EXPECTED_VERSION);
        return res;
    }

    /**
     * Get the {@code latest_version} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getLatestVersion() {
        String res = getStringOrNull(ConfigInfoColumns.LATEST_VERSION);
        return res;
    }

    /**
     * Get the {@code download_link} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDownloadLink() {
        String res = getStringOrNull(ConfigInfoColumns.DOWNLOAD_LINK);
        return res;
    }

    /**
     * Get the {@code last_updated} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getLastUpdated() {
        String res = getStringOrNull(ConfigInfoColumns.LAST_UPDATED);
        return res;
    }

    /**
     * Get the {@code file_name} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getFileName() {
        String res = getStringOrNull(ConfigInfoColumns.FILE_NAME);
        return res;
    }
}
