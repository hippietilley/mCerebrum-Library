package org.md2k.mycontentprovider.app;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.md2k.mycontentprovider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code app} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class AppContentValues extends AbstractContentValues<AppContentValues> {
    @Override
    protected Uri baseUri() {
        return AppColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable AppSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable AppSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public AppContentValues putPackageName(@Nullable String value) {
        mContentValues.put(AppColumns.PACKAGE_NAME, value);
        return this;
    }

    public AppContentValues putPackageNameNull() {
        mContentValues.putNull(AppColumns.PACKAGE_NAME);
        return this;
    }

    public AppContentValues putConfigure(@Nullable String value) {
        mContentValues.put(AppColumns.CONFIGURE, value);
        return this;
    }

    public AppContentValues putConfigureNull() {
        mContentValues.putNull(AppColumns.CONFIGURE);
        return this;
    }

    public AppContentValues putReport(@Nullable String value) {
        mContentValues.put(AppColumns.REPORT, value);
        return this;
    }

    public AppContentValues putReportNull() {
        mContentValues.putNull(AppColumns.REPORT);
        return this;
    }

    public AppContentValues putClear(@Nullable String value) {
        mContentValues.put(AppColumns.CLEAR, value);
        return this;
    }

    public AppContentValues putClearNull() {
        mContentValues.putNull(AppColumns.CLEAR);
        return this;
    }

    public AppContentValues putRunBackground(@Nullable String value) {
        mContentValues.put(AppColumns.RUN_BACKGROUND, value);
        return this;
    }

    public AppContentValues putRunBackgroundNull() {
        mContentValues.putNull(AppColumns.RUN_BACKGROUND);
        return this;
    }

    public AppContentValues putPermission(@Nullable String value) {
        mContentValues.put(AppColumns.PERMISSION, value);
        return this;
    }

    public AppContentValues putPermissionNull() {
        mContentValues.putNull(AppColumns.PERMISSION);
        return this;
    }

    public AppContentValues putInitialize(@Nullable String value) {
        mContentValues.put(AppColumns.INITIALIZE, value);
        return this;
    }

    public AppContentValues putInitializeNull() {
        mContentValues.putNull(AppColumns.INITIALIZE);
        return this;
    }

    public AppContentValues putInitialized(@Nullable Boolean value) {
        mContentValues.put(AppColumns.INITIALIZED, value);
        return this;
    }

    public AppContentValues putInitializedNull() {
        mContentValues.putNull(AppColumns.INITIALIZED);
        return this;
    }

    public AppContentValues putConfigured(@Nullable Boolean value) {
        mContentValues.put(AppColumns.CONFIGURED, value);
        return this;
    }

    public AppContentValues putConfiguredNull() {
        mContentValues.putNull(AppColumns.CONFIGURED);
        return this;
    }

    public AppContentValues putConfigureMatch(@Nullable Boolean value) {
        mContentValues.put(AppColumns.CONFIGURE_MATCH, value);
        return this;
    }

    public AppContentValues putConfigureMatchNull() {
        mContentValues.putNull(AppColumns.CONFIGURE_MATCH);
        return this;
    }

    public AppContentValues putRunningTime(@Nullable Boolean value) {
        mContentValues.put(AppColumns.RUNNING_TIME, value);
        return this;
    }

    public AppContentValues putRunningTimeNull() {
        mContentValues.putNull(AppColumns.RUNNING_TIME);
        return this;
    }

    public AppContentValues putIsRunningBackground(@Nullable Boolean value) {
        mContentValues.put(AppColumns.IS_RUNNING_BACKGROUND, value);
        return this;
    }

    public AppContentValues putIsRunningBackgroundNull() {
        mContentValues.putNull(AppColumns.IS_RUNNING_BACKGROUND);
        return this;
    }

    public AppContentValues putPermissionOk(@Nullable Boolean value) {
        mContentValues.put(AppColumns.PERMISSION_OK, value);
        return this;
    }

    public AppContentValues putPermissionOkNull() {
        mContentValues.putNull(AppColumns.PERMISSION_OK);
        return this;
    }

    public AppContentValues putDatakitConnected(@Nullable Boolean value) {
        mContentValues.put(AppColumns.DATAKIT_CONNECTED, value);
        return this;
    }

    public AppContentValues putDatakitConnectedNull() {
        mContentValues.putNull(AppColumns.DATAKIT_CONNECTED);
        return this;
    }
}
