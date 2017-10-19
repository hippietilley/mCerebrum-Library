package org.md2k.mcerebrum.core.access.configinfo;

// @formatter:off
import org.md2k.mcerebrum.core.access.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Configuration Information
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface ConfigInfoModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Get the {@code cid} value.
     * Can be {@code null}.
     */
    @Nullable
    String getCid();

    /**
     * Get the {@code type} value.
     * Can be {@code null}.
     */
    @Nullable
    String getType();

    /**
     * Get the {@code title} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTitle();

    /**
     * Get the {@code summary} value.
     * Can be {@code null}.
     */
    @Nullable
    String getSummary();

    /**
     * Get the {@code description} value.
     * Can be {@code null}.
     */
    @Nullable
    String getDescription();

    /**
     * Get the {@code versions} value.
     * Can be {@code null}.
     */
    @Nullable
    String getVersions();

    /**
     * NOTIFY, AUTO, MANUAL
     * Can be {@code null}.
     */
    @Nullable
    String getUpdates();

    /**
     * Get the {@code expected_version} value.
     * Can be {@code null}.
     */
    @Nullable
    String getExpectedVersion();

    /**
     * Get the {@code latest_version} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLatestVersion();

    /**
     * server, url
     * Can be {@code null}.
     */
    @Nullable
    String getDownloadFrom();

    /**
     * .json, .zip
     * Can be {@code null}.
     */
    @Nullable
    String getDownloadLink();
}
