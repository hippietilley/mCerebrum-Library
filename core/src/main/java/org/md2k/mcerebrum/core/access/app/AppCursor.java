package org.md2k.mycontentprovider.app;

// @formatter:off
import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.md2k.mycontentprovider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code app} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class AppCursor extends AbstractCursor implements AppModel {
    public AppCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(AppColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code package_name} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPackageName() {
        String res = getStringOrNull(AppColumns.PACKAGE_NAME);
        return res;
    }

    /**
     * Get the {@code configure} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getConfigure() {
        String res = getStringOrNull(AppColumns.CONFIGURE);
        return res;
    }

    /**
     * Get the {@code report} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getReport() {
        String res = getStringOrNull(AppColumns.REPORT);
        return res;
    }

    /**
     * Get the {@code clear} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getClear() {
        String res = getStringOrNull(AppColumns.CLEAR);
        return res;
    }

    /**
     * Get the {@code run_background} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getRunBackground() {
        String res = getStringOrNull(AppColumns.RUN_BACKGROUND);
        return res;
    }

    /**
     * Get the {@code permission} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPermission() {
        String res = getStringOrNull(AppColumns.PERMISSION);
        return res;
    }

    /**
     * Get the {@code initialize} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getInitialize() {
        String res = getStringOrNull(AppColumns.INITIALIZE);
        return res;
    }

    /**
     * Get the {@code initialized} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getInitialized() {
        Boolean res = getBooleanOrNull(AppColumns.INITIALIZED);
        return res;
    }

    /**
     * Get the {@code configured} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getConfigured() {
        Boolean res = getBooleanOrNull(AppColumns.CONFIGURED);
        return res;
    }

    /**
     * Get the {@code configure_match} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getConfigureMatch() {
        Boolean res = getBooleanOrNull(AppColumns.CONFIGURE_MATCH);
        return res;
    }

    /**
     * Get the {@code running_time} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getRunningTime() {
        Boolean res = getBooleanOrNull(AppColumns.RUNNING_TIME);
        return res;
    }

    /**
     * Get the {@code is_running_background} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getIsRunningBackground() {
        Boolean res = getBooleanOrNull(AppColumns.IS_RUNNING_BACKGROUND);
        return res;
    }

    /**
     * Get the {@code permission_ok} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getPermissionOk() {
        Boolean res = getBooleanOrNull(AppColumns.PERMISSION_OK);
        return res;
    }

    /**
     * Get the {@code datakit_connected} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getDatakitConnected() {
        Boolean res = getBooleanOrNull(AppColumns.DATAKIT_CONNECTED);
        return res;
    }
}
