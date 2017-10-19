package org.md2k.mcerebrum.core.access.configinfo;

// @formatter:off
import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.md2k.mcerebrum.core.access.base.AbstractCursor;

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
     * NOTIFY, AUTO, MANUAL
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
     * server, url
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDownloadFrom() {
        String res = getStringOrNull(ConfigInfoColumns.DOWNLOAD_FROM);
        return res;
    }

    /**
     * .json, .zip
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDownloadLink() {
        String res = getStringOrNull(ConfigInfoColumns.DOWNLOAD_LINK);
        return res;
    }
}
