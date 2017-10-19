package org.md2k.mcerebrum.core.access.studyinfo;

// @formatter:off
import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.md2k.mcerebrum.core.access.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code study_info} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class StudyInfoCursor extends AbstractCursor implements StudyInfoModel {
    public StudyInfoCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(StudyInfoColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code sid} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getSid() {
        String res = getStringOrNull(StudyInfoColumns.SID);
        return res;
    }

    /**
     * Get the {@code type} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getType() {
        String res = getStringOrNull(StudyInfoColumns.TYPE);
        return res;
    }

    /**
     * Get the {@code title} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTitle() {
        String res = getStringOrNull(StudyInfoColumns.TITLE);
        return res;
    }

    /**
     * Get the {@code summary} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getSummary() {
        String res = getStringOrNull(StudyInfoColumns.SUMMARY);
        return res;
    }

    /**
     * Get the {@code description} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDescription() {
        String res = getStringOrNull(StudyInfoColumns.DESCRIPTION);
        return res;
    }

    /**
     * Get the {@code version} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getVersion() {
        String res = getStringOrNull(StudyInfoColumns.VERSION);
        return res;
    }

    /**
     * Get the {@code icon} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getIcon() {
        String res = getStringOrNull(StudyInfoColumns.ICON);
        return res;
    }

    /**
     * Get the {@code cover_image} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getCoverImage() {
        String res = getStringOrNull(StudyInfoColumns.COVER_IMAGE);
        return res;
    }

    /**
     * Get the {@code start_at_boot} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getStartAtBoot() {
        Boolean res = getBooleanOrNull(StudyInfoColumns.START_AT_BOOT);
        return res;
    }

    /**
     * Get the {@code started} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getStarted() {
        Boolean res = getBooleanOrNull(StudyInfoColumns.STARTED);
        return res;
    }
}
