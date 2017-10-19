package org.md2k.mcerebrum.core.access.serverinfo;

// @formatter:off
import org.md2k.mcerebrum.core.access.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Server information
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface ServerInfoModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Get the {@code server_address} value.
     * Can be {@code null}.
     */
    @Nullable
    String getServerAddress();

    /**
     * Get the {@code username} value.
     * Can be {@code null}.
     */
    @Nullable
    String getUsername();

    /**
     * Get the {@code uuid} value.
     * Can be {@code null}.
     */
    @Nullable
    String getUuid();

    /**
     * Get the {@code password_hash} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPasswordHash();

    /**
     * Get the {@code token} value.
     * Can be {@code null}.
     */
    @Nullable
    String getToken();

    /**
     * Get the {@code file_name} value.
     * Can be {@code null}.
     */
    @Nullable
    String getFileName();

    /**
     * Get the {@code current_version} value.
     * Can be {@code null}.
     */
    @Nullable
    String getCurrentVersion();

    /**
     * Get the {@code latest_version} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLatestVersion();
}
