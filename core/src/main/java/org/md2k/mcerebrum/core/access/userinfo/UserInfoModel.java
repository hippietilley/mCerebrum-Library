package org.md2k.mcerebrum.core.access.userinfo;

// @formatter:off
import org.md2k.mcerebrum.core.access.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * User information
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface UserInfoModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Get the {@code uid} value.
     * Can be {@code null}.
     */
    @Nullable
    String getUid();

    /**
     * Get the {@code type} value.
     * Can be {@code null}.
     */
    @Nullable
    String getType();

    /**
     * Get the {@code username} value.
     * Can be {@code null}.
     */
    @Nullable
    String getUsername();
}
