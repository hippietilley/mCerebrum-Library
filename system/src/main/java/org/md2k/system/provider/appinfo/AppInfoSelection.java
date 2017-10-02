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
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.CursorLoader;

import org.md2k.system.provider.base.AbstractSelection;

/**
 * Selection for the {@code app_info} table.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class AppInfoSelection extends AbstractSelection<AppInfoSelection> {
    @Override
    protected Uri baseUri() {
        return AppInfoColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code AppInfoCursor} object, which is positioned before the first entry, or null.
     */
    public AppInfoCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new AppInfoCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public AppInfoCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code AppInfoCursor} object, which is positioned before the first entry, or null.
     */
    public AppInfoCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new AppInfoCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public AppInfoCursor query(Context context) {
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
                return new AppInfoCursor(super.loadInBackground());
            }
        };
    }


    public AppInfoSelection id(long... value) {
        addEquals("app_info." + AppInfoColumns._ID, toObjectArray(value));
        return this;
    }

    public AppInfoSelection idNot(long... value) {
        addNotEquals("app_info." + AppInfoColumns._ID, toObjectArray(value));
        return this;
    }

    public AppInfoSelection orderById(boolean desc) {
        orderBy("app_info." + AppInfoColumns._ID, desc);
        return this;
    }

    public AppInfoSelection orderById() {
        return orderById(false);
    }

    public AppInfoSelection aid(String... value) {
        addEquals(AppInfoColumns.AID, value);
        return this;
    }

    public AppInfoSelection aidNot(String... value) {
        addNotEquals(AppInfoColumns.AID, value);
        return this;
    }

    public AppInfoSelection aidLike(String... value) {
        addLike(AppInfoColumns.AID, value);
        return this;
    }

    public AppInfoSelection aidContains(String... value) {
        addContains(AppInfoColumns.AID, value);
        return this;
    }

    public AppInfoSelection aidStartsWith(String... value) {
        addStartsWith(AppInfoColumns.AID, value);
        return this;
    }

    public AppInfoSelection aidEndsWith(String... value) {
        addEndsWith(AppInfoColumns.AID, value);
        return this;
    }

    public AppInfoSelection orderByAid(boolean desc) {
        orderBy(AppInfoColumns.AID, desc);
        return this;
    }

    public AppInfoSelection orderByAid() {
        orderBy(AppInfoColumns.AID, false);
        return this;
    }

    public AppInfoSelection type(String... value) {
        addEquals(AppInfoColumns.TYPE, value);
        return this;
    }

    public AppInfoSelection typeNot(String... value) {
        addNotEquals(AppInfoColumns.TYPE, value);
        return this;
    }

    public AppInfoSelection typeLike(String... value) {
        addLike(AppInfoColumns.TYPE, value);
        return this;
    }

    public AppInfoSelection typeContains(String... value) {
        addContains(AppInfoColumns.TYPE, value);
        return this;
    }

    public AppInfoSelection typeStartsWith(String... value) {
        addStartsWith(AppInfoColumns.TYPE, value);
        return this;
    }

    public AppInfoSelection typeEndsWith(String... value) {
        addEndsWith(AppInfoColumns.TYPE, value);
        return this;
    }

    public AppInfoSelection orderByType(boolean desc) {
        orderBy(AppInfoColumns.TYPE, desc);
        return this;
    }

    public AppInfoSelection orderByType() {
        orderBy(AppInfoColumns.TYPE, false);
        return this;
    }

    public AppInfoSelection title(String... value) {
        addEquals(AppInfoColumns.TITLE, value);
        return this;
    }

    public AppInfoSelection titleNot(String... value) {
        addNotEquals(AppInfoColumns.TITLE, value);
        return this;
    }

    public AppInfoSelection titleLike(String... value) {
        addLike(AppInfoColumns.TITLE, value);
        return this;
    }

    public AppInfoSelection titleContains(String... value) {
        addContains(AppInfoColumns.TITLE, value);
        return this;
    }

    public AppInfoSelection titleStartsWith(String... value) {
        addStartsWith(AppInfoColumns.TITLE, value);
        return this;
    }

    public AppInfoSelection titleEndsWith(String... value) {
        addEndsWith(AppInfoColumns.TITLE, value);
        return this;
    }

    public AppInfoSelection orderByTitle(boolean desc) {
        orderBy(AppInfoColumns.TITLE, desc);
        return this;
    }

    public AppInfoSelection orderByTitle() {
        orderBy(AppInfoColumns.TITLE, false);
        return this;
    }

    public AppInfoSelection summary(String... value) {
        addEquals(AppInfoColumns.SUMMARY, value);
        return this;
    }

    public AppInfoSelection summaryNot(String... value) {
        addNotEquals(AppInfoColumns.SUMMARY, value);
        return this;
    }

    public AppInfoSelection summaryLike(String... value) {
        addLike(AppInfoColumns.SUMMARY, value);
        return this;
    }

    public AppInfoSelection summaryContains(String... value) {
        addContains(AppInfoColumns.SUMMARY, value);
        return this;
    }

    public AppInfoSelection summaryStartsWith(String... value) {
        addStartsWith(AppInfoColumns.SUMMARY, value);
        return this;
    }

    public AppInfoSelection summaryEndsWith(String... value) {
        addEndsWith(AppInfoColumns.SUMMARY, value);
        return this;
    }

    public AppInfoSelection orderBySummary(boolean desc) {
        orderBy(AppInfoColumns.SUMMARY, desc);
        return this;
    }

    public AppInfoSelection orderBySummary() {
        orderBy(AppInfoColumns.SUMMARY, false);
        return this;
    }

    public AppInfoSelection description(String... value) {
        addEquals(AppInfoColumns.DESCRIPTION, value);
        return this;
    }

    public AppInfoSelection descriptionNot(String... value) {
        addNotEquals(AppInfoColumns.DESCRIPTION, value);
        return this;
    }

    public AppInfoSelection descriptionLike(String... value) {
        addLike(AppInfoColumns.DESCRIPTION, value);
        return this;
    }

    public AppInfoSelection descriptionContains(String... value) {
        addContains(AppInfoColumns.DESCRIPTION, value);
        return this;
    }

    public AppInfoSelection descriptionStartsWith(String... value) {
        addStartsWith(AppInfoColumns.DESCRIPTION, value);
        return this;
    }

    public AppInfoSelection descriptionEndsWith(String... value) {
        addEndsWith(AppInfoColumns.DESCRIPTION, value);
        return this;
    }

    public AppInfoSelection orderByDescription(boolean desc) {
        orderBy(AppInfoColumns.DESCRIPTION, desc);
        return this;
    }

    public AppInfoSelection orderByDescription() {
        orderBy(AppInfoColumns.DESCRIPTION, false);
        return this;
    }

    public AppInfoSelection packageName(String... value) {
        addEquals(AppInfoColumns.PACKAGE_NAME, value);
        return this;
    }

    public AppInfoSelection packageNameNot(String... value) {
        addNotEquals(AppInfoColumns.PACKAGE_NAME, value);
        return this;
    }

    public AppInfoSelection packageNameLike(String... value) {
        addLike(AppInfoColumns.PACKAGE_NAME, value);
        return this;
    }

    public AppInfoSelection packageNameContains(String... value) {
        addContains(AppInfoColumns.PACKAGE_NAME, value);
        return this;
    }

    public AppInfoSelection packageNameStartsWith(String... value) {
        addStartsWith(AppInfoColumns.PACKAGE_NAME, value);
        return this;
    }

    public AppInfoSelection packageNameEndsWith(String... value) {
        addEndsWith(AppInfoColumns.PACKAGE_NAME, value);
        return this;
    }

    public AppInfoSelection orderByPackageName(boolean desc) {
        orderBy(AppInfoColumns.PACKAGE_NAME, desc);
        return this;
    }

    public AppInfoSelection orderByPackageName() {
        orderBy(AppInfoColumns.PACKAGE_NAME, false);
        return this;
    }

    public AppInfoSelection downloadLink(String... value) {
        addEquals(AppInfoColumns.DOWNLOAD_LINK, value);
        return this;
    }

    public AppInfoSelection downloadLinkNot(String... value) {
        addNotEquals(AppInfoColumns.DOWNLOAD_LINK, value);
        return this;
    }

    public AppInfoSelection downloadLinkLike(String... value) {
        addLike(AppInfoColumns.DOWNLOAD_LINK, value);
        return this;
    }

    public AppInfoSelection downloadLinkContains(String... value) {
        addContains(AppInfoColumns.DOWNLOAD_LINK, value);
        return this;
    }

    public AppInfoSelection downloadLinkStartsWith(String... value) {
        addStartsWith(AppInfoColumns.DOWNLOAD_LINK, value);
        return this;
    }

    public AppInfoSelection downloadLinkEndsWith(String... value) {
        addEndsWith(AppInfoColumns.DOWNLOAD_LINK, value);
        return this;
    }

    public AppInfoSelection orderByDownloadLink(boolean desc) {
        orderBy(AppInfoColumns.DOWNLOAD_LINK, desc);
        return this;
    }

    public AppInfoSelection orderByDownloadLink() {
        orderBy(AppInfoColumns.DOWNLOAD_LINK, false);
        return this;
    }

    public AppInfoSelection updates(String... value) {
        addEquals(AppInfoColumns.UPDATES, value);
        return this;
    }

    public AppInfoSelection updatesNot(String... value) {
        addNotEquals(AppInfoColumns.UPDATES, value);
        return this;
    }

    public AppInfoSelection updatesLike(String... value) {
        addLike(AppInfoColumns.UPDATES, value);
        return this;
    }

    public AppInfoSelection updatesContains(String... value) {
        addContains(AppInfoColumns.UPDATES, value);
        return this;
    }

    public AppInfoSelection updatesStartsWith(String... value) {
        addStartsWith(AppInfoColumns.UPDATES, value);
        return this;
    }

    public AppInfoSelection updatesEndsWith(String... value) {
        addEndsWith(AppInfoColumns.UPDATES, value);
        return this;
    }

    public AppInfoSelection orderByUpdates(boolean desc) {
        orderBy(AppInfoColumns.UPDATES, desc);
        return this;
    }

    public AppInfoSelection orderByUpdates() {
        orderBy(AppInfoColumns.UPDATES, false);
        return this;
    }

    public AppInfoSelection useAs(String... value) {
        addEquals(AppInfoColumns.USE_AS, value);
        return this;
    }

    public AppInfoSelection useAsNot(String... value) {
        addNotEquals(AppInfoColumns.USE_AS, value);
        return this;
    }

    public AppInfoSelection useAsLike(String... value) {
        addLike(AppInfoColumns.USE_AS, value);
        return this;
    }

    public AppInfoSelection useAsContains(String... value) {
        addContains(AppInfoColumns.USE_AS, value);
        return this;
    }

    public AppInfoSelection useAsStartsWith(String... value) {
        addStartsWith(AppInfoColumns.USE_AS, value);
        return this;
    }

    public AppInfoSelection useAsEndsWith(String... value) {
        addEndsWith(AppInfoColumns.USE_AS, value);
        return this;
    }

    public AppInfoSelection orderByUseAs(boolean desc) {
        orderBy(AppInfoColumns.USE_AS, desc);
        return this;
    }

    public AppInfoSelection orderByUseAs() {
        orderBy(AppInfoColumns.USE_AS, false);
        return this;
    }

    public AppInfoSelection expectedVersion(String... value) {
        addEquals(AppInfoColumns.EXPECTED_VERSION, value);
        return this;
    }

    public AppInfoSelection expectedVersionNot(String... value) {
        addNotEquals(AppInfoColumns.EXPECTED_VERSION, value);
        return this;
    }

    public AppInfoSelection expectedVersionLike(String... value) {
        addLike(AppInfoColumns.EXPECTED_VERSION, value);
        return this;
    }

    public AppInfoSelection expectedVersionContains(String... value) {
        addContains(AppInfoColumns.EXPECTED_VERSION, value);
        return this;
    }

    public AppInfoSelection expectedVersionStartsWith(String... value) {
        addStartsWith(AppInfoColumns.EXPECTED_VERSION, value);
        return this;
    }

    public AppInfoSelection expectedVersionEndsWith(String... value) {
        addEndsWith(AppInfoColumns.EXPECTED_VERSION, value);
        return this;
    }

    public AppInfoSelection orderByExpectedVersion(boolean desc) {
        orderBy(AppInfoColumns.EXPECTED_VERSION, desc);
        return this;
    }

    public AppInfoSelection orderByExpectedVersion() {
        orderBy(AppInfoColumns.EXPECTED_VERSION, false);
        return this;
    }

    public AppInfoSelection icon(String... value) {
        addEquals(AppInfoColumns.ICON, value);
        return this;
    }

    public AppInfoSelection iconNot(String... value) {
        addNotEquals(AppInfoColumns.ICON, value);
        return this;
    }

    public AppInfoSelection iconLike(String... value) {
        addLike(AppInfoColumns.ICON, value);
        return this;
    }

    public AppInfoSelection iconContains(String... value) {
        addContains(AppInfoColumns.ICON, value);
        return this;
    }

    public AppInfoSelection iconStartsWith(String... value) {
        addStartsWith(AppInfoColumns.ICON, value);
        return this;
    }

    public AppInfoSelection iconEndsWith(String... value) {
        addEndsWith(AppInfoColumns.ICON, value);
        return this;
    }

    public AppInfoSelection orderByIcon(boolean desc) {
        orderBy(AppInfoColumns.ICON, desc);
        return this;
    }

    public AppInfoSelection orderByIcon() {
        orderBy(AppInfoColumns.ICON, false);
        return this;
    }

    public AppInfoSelection currentVersion(String... value) {
        addEquals(AppInfoColumns.CURRENT_VERSION, value);
        return this;
    }

    public AppInfoSelection currentVersionNot(String... value) {
        addNotEquals(AppInfoColumns.CURRENT_VERSION, value);
        return this;
    }

    public AppInfoSelection currentVersionLike(String... value) {
        addLike(AppInfoColumns.CURRENT_VERSION, value);
        return this;
    }

    public AppInfoSelection currentVersionContains(String... value) {
        addContains(AppInfoColumns.CURRENT_VERSION, value);
        return this;
    }

    public AppInfoSelection currentVersionStartsWith(String... value) {
        addStartsWith(AppInfoColumns.CURRENT_VERSION, value);
        return this;
    }

    public AppInfoSelection currentVersionEndsWith(String... value) {
        addEndsWith(AppInfoColumns.CURRENT_VERSION, value);
        return this;
    }

    public AppInfoSelection orderByCurrentVersion(boolean desc) {
        orderBy(AppInfoColumns.CURRENT_VERSION, desc);
        return this;
    }

    public AppInfoSelection orderByCurrentVersion() {
        orderBy(AppInfoColumns.CURRENT_VERSION, false);
        return this;
    }

    public AppInfoSelection latestVersion(String... value) {
        addEquals(AppInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public AppInfoSelection latestVersionNot(String... value) {
        addNotEquals(AppInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public AppInfoSelection latestVersionLike(String... value) {
        addLike(AppInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public AppInfoSelection latestVersionContains(String... value) {
        addContains(AppInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public AppInfoSelection latestVersionStartsWith(String... value) {
        addStartsWith(AppInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public AppInfoSelection latestVersionEndsWith(String... value) {
        addEndsWith(AppInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public AppInfoSelection orderByLatestVersion(boolean desc) {
        orderBy(AppInfoColumns.LATEST_VERSION, desc);
        return this;
    }

    public AppInfoSelection orderByLatestVersion() {
        orderBy(AppInfoColumns.LATEST_VERSION, false);
        return this;
    }

    public AppInfoSelection installed(Boolean value) {
        addEquals(AppInfoColumns.INSTALLED, toObjectArray(value));
        return this;
    }

    public AppInfoSelection orderByInstalled(boolean desc) {
        orderBy(AppInfoColumns.INSTALLED, desc);
        return this;
    }

    public AppInfoSelection orderByInstalled() {
        orderBy(AppInfoColumns.INSTALLED, false);
        return this;
    }

    public AppInfoSelection mcerebrumSupported(Boolean value) {
        addEquals(AppInfoColumns.MCEREBRUM_SUPPORTED, toObjectArray(value));
        return this;
    }

    public AppInfoSelection orderByMcerebrumSupported(boolean desc) {
        orderBy(AppInfoColumns.MCEREBRUM_SUPPORTED, desc);
        return this;
    }

    public AppInfoSelection orderByMcerebrumSupported() {
        orderBy(AppInfoColumns.MCEREBRUM_SUPPORTED, false);
        return this;
    }

    public AppInfoSelection initialized(Boolean value) {
        addEquals(AppInfoColumns.INITIALIZED, toObjectArray(value));
        return this;
    }

    public AppInfoSelection orderByInitialized(boolean desc) {
        orderBy(AppInfoColumns.INITIALIZED, desc);
        return this;
    }

    public AppInfoSelection orderByInitialized() {
        orderBy(AppInfoColumns.INITIALIZED, false);
        return this;
    }
}
