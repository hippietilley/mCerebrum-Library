package org.md2k.mcerebrum.core.access.serverinfo;

// @formatter:off
import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.md2k.mcerebrum.core.access.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code server_info} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class ServerInfoCursor extends AbstractCursor implements ServerInfoModel {
    public ServerInfoCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(ServerInfoColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code server_address} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getServerAddress() {
        String res = getStringOrNull(ServerInfoColumns.SERVER_ADDRESS);
        return res;
    }

    /**
     * Get the {@code username} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getUsername() {
        String res = getStringOrNull(ServerInfoColumns.USERNAME);
        return res;
    }

    /**
     * Get the {@code uuid} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getUuid() {
        String res = getStringOrNull(ServerInfoColumns.UUID);
        return res;
    }

    /**
     * Get the {@code password_hash} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPasswordHash() {
        String res = getStringOrNull(ServerInfoColumns.PASSWORD_HASH);
        return res;
    }

    /**
     * Get the {@code token} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getToken() {
        String res = getStringOrNull(ServerInfoColumns.TOKEN);
        return res;
    }

    /**
     * Get the {@code file_name} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getFileName() {
        String res = getStringOrNull(ServerInfoColumns.FILE_NAME);
        return res;
    }

    /**
     * Get the {@code current_version} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getCurrentVersion() {
        String res = getStringOrNull(ServerInfoColumns.CURRENT_VERSION);
        return res;
    }

    /**
     * Get the {@code latest_version} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getLatestVersion() {
        String res = getStringOrNull(ServerInfoColumns.LATEST_VERSION);
        return res;
    }
}
