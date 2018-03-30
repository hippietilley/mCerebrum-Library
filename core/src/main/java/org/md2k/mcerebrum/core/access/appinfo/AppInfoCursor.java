package org.md2k.mcerebrum.core.access.appinfo;

// @formatter:off
import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.md2k.mcerebrum.core.access.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code app_info} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class AppInfoCursor extends AbstractCursor implements AppInfoModel {
    public AppInfoCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(AppInfoColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, " +
                    "which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code package_name} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPackageName() {
        String res = getStringOrNull(AppInfoColumns.PACKAGE_NAME);
        return res;
    }

    /**
     * MCEREBRUM, STUDY, DATAKIT,any other string
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getType() {
        String res = getStringOrNull(AppInfoColumns.TYPE);
        return res;
    }

    /**
     * Get the {@code title} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTitle() {
        String res = getStringOrNull(AppInfoColumns.TITLE);
        return res;
    }

    /**
     * Get the {@code summary} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getSummary() {
        String res = getStringOrNull(AppInfoColumns.SUMMARY);
        return res;
    }

    /**
     * Get the {@code description} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDescription() {
        String res = getStringOrNull(AppInfoColumns.DESCRIPTION);
        return res;
    }

    /**
     * Get the {@code use_in_study} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getUseInStudy() {
        Boolean res = getBooleanOrNull(AppInfoColumns.USE_IN_STUDY);
        return res;
    }

    /**
     * not in use, required, optional
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getUseAs() {
        String res = getStringOrNull(AppInfoColumns.USE_AS);
        return res;
    }

    /**
     * Get the {@code installed} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getInstalled() {
        Boolean res = getBooleanOrNull(AppInfoColumns.INSTALLED);
        return res;
    }

    /**
     * Get the {@code download_link} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDownloadLink() {
        String res = getStringOrNull(AppInfoColumns.DOWNLOAD_LINK);
        return res;
    }

    /**
     * NOTIFY, AUTO, MANUAL
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getUpdates() {
        String res = getStringOrNull(AppInfoColumns.UPDATES);
        return res;
    }

    /**
     * Get the {@code current_version} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getCurrentVersion() {
        String res = getStringOrNull(AppInfoColumns.CURRENT_VERSION);
        return res;
    }

    /**
     * Get the {@code latest_version} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getLatestVersion() {
        String res = getStringOrNull(AppInfoColumns.LATEST_VERSION);
        return res;
    }

    /**
     * Get the {@code expected_version} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getExpectedVersion() {
        String res = getStringOrNull(AppInfoColumns.EXPECTED_VERSION);
        return res;
    }

    /**
     * Get the {@code icon} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getIcon() {
        String res = getStringOrNull(AppInfoColumns.ICON);
        return res;
    }

    /**
     * Get the {@code mcerebrum_supported} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getMcerebrumSupported() {
        Boolean res = getBooleanOrNull(AppInfoColumns.MCEREBRUM_SUPPORTED);
        return res;
    }

    /**
     * Get the {@code func_initialize} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getFuncInitialize() {
        String res = getStringOrNull(AppInfoColumns.FUNC_INITIALIZE);
        return res;
    }

    /**
     * Get the {@code initialized} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getInitialized() {
        Boolean res = getBooleanOrNull(AppInfoColumns.INITIALIZED);
        return res;
    }

    /**
     * Get the {@code func_update_info} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getFuncUpdateInfo() {
        String res = getStringOrNull(AppInfoColumns.FUNC_UPDATE_INFO);
        return res;
    }

    /**
     * Get the {@code func_configure} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getFuncConfigure() {
        String res = getStringOrNull(AppInfoColumns.FUNC_CONFIGURE);
        return res;
    }

    /**
     * Get the {@code configured} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getConfigured() {
        Boolean res = getBooleanOrNull(AppInfoColumns.CONFIGURED);
        return res;
    }

    /**
     * Get the {@code configure_match} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getConfigureMatch() {
        Boolean res = getBooleanOrNull(AppInfoColumns.CONFIGURE_MATCH);
        return res;
    }

    /**
     * Get the {@code func_permission} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getFuncPermission() {
        String res = getStringOrNull(AppInfoColumns.FUNC_PERMISSION);
        return res;
    }

    /**
     * Get the {@code permission_ok} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getPermissionOk() {
        Boolean res = getBooleanOrNull(AppInfoColumns.PERMISSION_OK);
        return res;
    }

    /**
     * Get the {@code func_background} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getFuncBackground() {
        String res = getStringOrNull(AppInfoColumns.FUNC_BACKGROUND);
        return res;
    }

    /**
     * Get the {@code background_running_time} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getBackgroundRunningTime() {
        Boolean res = getBooleanOrNull(AppInfoColumns.BACKGROUND_RUNNING_TIME);
        return res;
    }

    /**
     * Get the {@code is_background_running} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getIsBackgroundRunning() {
        Boolean res = getBooleanOrNull(AppInfoColumns.IS_BACKGROUND_RUNNING);
        return res;
    }

    /**
     * Get the {@code func_report} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getFuncReport() {
        String res = getStringOrNull(AppInfoColumns.FUNC_REPORT);
        return res;
    }

    /**
     * Get the {@code func_clear} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getFuncClear() {
        String res = getStringOrNull(AppInfoColumns.FUNC_CLEAR);
        return res;
    }

    /**
     * Get the {@code datakit_connected} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getDatakitConnected() {
        Boolean res = getBooleanOrNull(AppInfoColumns.DATAKIT_CONNECTED);
        return res;
    }
}
