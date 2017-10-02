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
package org.md2k.system.provider.appinfo;

// @formatter:off
import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.md2k.system.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code app_info} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class AppInfoCursor extends AbstractCursor implements AppInfoModel {
    public AppInfoCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(AppInfoColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code aid} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getAid() {
        String res = getStringOrNull(AppInfoColumns.AID);
        return res;
    }

    /**
     * Get the {@code type} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getType() {
        String res = getStringOrNull(AppInfoColumns.TYPE);
        return res;
    }

    /**
     * Get the {@code title} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTitle() {
        String res = getStringOrNull(AppInfoColumns.TITLE);
        return res;
    }

    /**
     * Get the {@code summary} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getSummary() {
        String res = getStringOrNull(AppInfoColumns.SUMMARY);
        return res;
    }

    /**
     * Get the {@code description} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDescription() {
        String res = getStringOrNull(AppInfoColumns.DESCRIPTION);
        return res;
    }

    /**
     * Get the {@code package_name} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPackageName() {
        String res = getStringOrNull(AppInfoColumns.PACKAGE_NAME);
        return res;
    }

    /**
     * Get the {@code download_link} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDownloadLink() {
        String res = getStringOrNull(AppInfoColumns.DOWNLOAD_LINK);
        return res;
    }

    /**
     * Get the {@code updates} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getUpdates() {
        String res = getStringOrNull(AppInfoColumns.UPDATES);
        return res;
    }

    /**
     * not in use, required, optional
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getUseAs() {
        String res = getStringOrNull(AppInfoColumns.USE_AS);
        return res;
    }

    /**
     * Get the {@code expected_version} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getExpectedVersion() {
        String res = getStringOrNull(AppInfoColumns.EXPECTED_VERSION);
        return res;
    }

    /**
     * Get the {@code icon} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getIcon() {
        String res = getStringOrNull(AppInfoColumns.ICON);
        return res;
    }

    /**
     * Get the {@code current_version} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getCurrentVersion() {
        String res = getStringOrNull(AppInfoColumns.CURRENT_VERSION);
        return res;
    }

    /**
     * Get the {@code latest_version} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getLatestVersion() {
        String res = getStringOrNull(AppInfoColumns.LATEST_VERSION);
        return res;
    }

    /**
     * Get the {@code installed} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getInstalled() {
        Boolean res = getBooleanOrNull(AppInfoColumns.INSTALLED);
        return res;
    }

    /**
     * Get the {@code mcerebrum_supported} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getMcerebrumSupported() {
        Boolean res = getBooleanOrNull(AppInfoColumns.MCEREBRUM_SUPPORTED);
        return res;
    }

    /**
     * Get the {@code initialized} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getInitialized() {
        Boolean res = getBooleanOrNull(AppInfoColumns.INITIALIZED);
        return res;
    }
}
