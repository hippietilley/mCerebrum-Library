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

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.md2k.system.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code app_info} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class AppInfoContentValues extends AbstractContentValues<AppInfoContentValues> {
    @Override
    protected Uri baseUri() {
        return AppInfoColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable AppInfoSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable AppInfoSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public AppInfoContentValues putAid(@Nullable String value) {
        mContentValues.put(AppInfoColumns.AID, value);
        return this;
    }

    public AppInfoContentValues putAidNull() {
        mContentValues.putNull(AppInfoColumns.AID);
        return this;
    }

    public AppInfoContentValues putType(@Nullable String value) {
        mContentValues.put(AppInfoColumns.TYPE, value);
        return this;
    }

    public AppInfoContentValues putTypeNull() {
        mContentValues.putNull(AppInfoColumns.TYPE);
        return this;
    }

    public AppInfoContentValues putTitle(@Nullable String value) {
        mContentValues.put(AppInfoColumns.TITLE, value);
        return this;
    }

    public AppInfoContentValues putTitleNull() {
        mContentValues.putNull(AppInfoColumns.TITLE);
        return this;
    }

    public AppInfoContentValues putSummary(@Nullable String value) {
        mContentValues.put(AppInfoColumns.SUMMARY, value);
        return this;
    }

    public AppInfoContentValues putSummaryNull() {
        mContentValues.putNull(AppInfoColumns.SUMMARY);
        return this;
    }

    public AppInfoContentValues putDescription(@Nullable String value) {
        mContentValues.put(AppInfoColumns.DESCRIPTION, value);
        return this;
    }

    public AppInfoContentValues putDescriptionNull() {
        mContentValues.putNull(AppInfoColumns.DESCRIPTION);
        return this;
    }

    public AppInfoContentValues putPackageName(@Nullable String value) {
        mContentValues.put(AppInfoColumns.PACKAGE_NAME, value);
        return this;
    }

    public AppInfoContentValues putPackageNameNull() {
        mContentValues.putNull(AppInfoColumns.PACKAGE_NAME);
        return this;
    }

    public AppInfoContentValues putDownloadLink(@Nullable String value) {
        mContentValues.put(AppInfoColumns.DOWNLOAD_LINK, value);
        return this;
    }

    public AppInfoContentValues putDownloadLinkNull() {
        mContentValues.putNull(AppInfoColumns.DOWNLOAD_LINK);
        return this;
    }

    public AppInfoContentValues putUpdates(@Nullable String value) {
        mContentValues.put(AppInfoColumns.UPDATES, value);
        return this;
    }

    public AppInfoContentValues putUpdatesNull() {
        mContentValues.putNull(AppInfoColumns.UPDATES);
        return this;
    }

    /**
     * not in use, required, optional
     */
    public AppInfoContentValues putUseAs(@Nullable String value) {
        mContentValues.put(AppInfoColumns.USE_AS, value);
        return this;
    }

    public AppInfoContentValues putUseAsNull() {
        mContentValues.putNull(AppInfoColumns.USE_AS);
        return this;
    }

    public AppInfoContentValues putExpectedVersion(@Nullable String value) {
        mContentValues.put(AppInfoColumns.EXPECTED_VERSION, value);
        return this;
    }

    public AppInfoContentValues putExpectedVersionNull() {
        mContentValues.putNull(AppInfoColumns.EXPECTED_VERSION);
        return this;
    }

    public AppInfoContentValues putIcon(@Nullable String value) {
        mContentValues.put(AppInfoColumns.ICON, value);
        return this;
    }

    public AppInfoContentValues putIconNull() {
        mContentValues.putNull(AppInfoColumns.ICON);
        return this;
    }

    public AppInfoContentValues putCurrentVersion(@Nullable String value) {
        mContentValues.put(AppInfoColumns.CURRENT_VERSION, value);
        return this;
    }

    public AppInfoContentValues putCurrentVersionNull() {
        mContentValues.putNull(AppInfoColumns.CURRENT_VERSION);
        return this;
    }

    public AppInfoContentValues putLatestVersion(@Nullable String value) {
        mContentValues.put(AppInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public AppInfoContentValues putLatestVersionNull() {
        mContentValues.putNull(AppInfoColumns.LATEST_VERSION);
        return this;
    }

    public AppInfoContentValues putInstalled(@Nullable Boolean value) {
        mContentValues.put(AppInfoColumns.INSTALLED, value);
        return this;
    }

    public AppInfoContentValues putInstalledNull() {
        mContentValues.putNull(AppInfoColumns.INSTALLED);
        return this;
    }

    public AppInfoContentValues putMcerebrumSupported(@Nullable Boolean value) {
        mContentValues.put(AppInfoColumns.MCEREBRUM_SUPPORTED, value);
        return this;
    }

    public AppInfoContentValues putMcerebrumSupportedNull() {
        mContentValues.putNull(AppInfoColumns.MCEREBRUM_SUPPORTED);
        return this;
    }

    public AppInfoContentValues putInitialized(@Nullable Boolean value) {
        mContentValues.put(AppInfoColumns.INITIALIZED, value);
        return this;
    }

    public AppInfoContentValues putInitializedNull() {
        mContentValues.putNull(AppInfoColumns.INITIALIZED);
        return this;
    }
}
