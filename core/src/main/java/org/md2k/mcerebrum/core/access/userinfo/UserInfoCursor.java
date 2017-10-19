package org.md2k.mcerebrum.core.access.userinfo;

// @formatter:off
import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.md2k.mcerebrum.core.access.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code user_info} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class UserInfoCursor extends AbstractCursor implements UserInfoModel {
    public UserInfoCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(UserInfoColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code uid} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getUid() {
        String res = getStringOrNull(UserInfoColumns.UID);
        return res;
    }

    /**
     * Get the {@code type} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getType() {
        String res = getStringOrNull(UserInfoColumns.TYPE);
        return res;
    }

    /**
     * Get the {@code username} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getUsername() {
        String res = getStringOrNull(UserInfoColumns.USERNAME);
        return res;
    }
}
