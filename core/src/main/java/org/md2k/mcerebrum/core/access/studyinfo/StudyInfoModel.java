package org.md2k.mcerebrum.core.access.studyinfo;

// @formatter:off
import org.md2k.mcerebrum.core.access.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Study Information
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface StudyInfoModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Get the {@code sid} value.
     * Can be {@code null}.
     */
    @Nullable
    String getSid();

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
     * Get the {@code version} value.
     * Can be {@code null}.
     */
    @Nullable
    String getVersion();

    /**
     * Get the {@code icon} value.
     * Can be {@code null}.
     */
    @Nullable
    String getIcon();

    /**
     * Get the {@code cover_image} value.
     * Can be {@code null}.
     */
    @Nullable
    String getCoverImage();

    /**
     * Get the {@code start_at_boot} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getStartAtBoot();

    /**
     * Get the {@code started} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getStarted();
}
