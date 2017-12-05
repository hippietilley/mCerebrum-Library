package org.md2k.mycontentprovider.app;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.CursorLoader;

import org.md2k.mycontentprovider.base.AbstractSelection;

/**
 * Selection for the {@code app} table.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class AppSelection extends AbstractSelection<AppSelection> {
    @Override
    protected Uri baseUri() {
        return AppColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code AppCursor} object, which is positioned before the first entry, or null.
     */
    public AppCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new AppCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public AppCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code AppCursor} object, which is positioned before the first entry, or null.
     */
    public AppCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new AppCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public AppCursor query(Context context) {
        return query(context, null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public CursorLoader getCursorLoader(Context context, String[] projection) {
        return new CursorLoader(context, uri(), projection, sel(), args(), order()) {
            @Override
            public Cursor loadInBackground() {
                return new AppCursor(super.loadInBackground());
            }
        };
    }


    public AppSelection id(long... value) {
        addEquals("app." + AppColumns._ID, toObjectArray(value));
        return this;
    }

    public AppSelection idNot(long... value) {
        addNotEquals("app." + AppColumns._ID, toObjectArray(value));
        return this;
    }

    public AppSelection orderById(boolean desc) {
        orderBy("app." + AppColumns._ID, desc);
        return this;
    }

    public AppSelection orderById() {
        return orderById(false);
    }

    public AppSelection packageName(String... value) {
        addEquals(AppColumns.PACKAGE_NAME, value);
        return this;
    }

    public AppSelection packageNameNot(String... value) {
        addNotEquals(AppColumns.PACKAGE_NAME, value);
        return this;
    }

    public AppSelection packageNameLike(String... value) {
        addLike(AppColumns.PACKAGE_NAME, value);
        return this;
    }

    public AppSelection packageNameContains(String... value) {
        addContains(AppColumns.PACKAGE_NAME, value);
        return this;
    }

    public AppSelection packageNameStartsWith(String... value) {
        addStartsWith(AppColumns.PACKAGE_NAME, value);
        return this;
    }

    public AppSelection packageNameEndsWith(String... value) {
        addEndsWith(AppColumns.PACKAGE_NAME, value);
        return this;
    }

    public AppSelection orderByPackageName(boolean desc) {
        orderBy(AppColumns.PACKAGE_NAME, desc);
        return this;
    }

    public AppSelection orderByPackageName() {
        orderBy(AppColumns.PACKAGE_NAME, false);
        return this;
    }

    public AppSelection configure(String... value) {
        addEquals(AppColumns.CONFIGURE, value);
        return this;
    }

    public AppSelection configureNot(String... value) {
        addNotEquals(AppColumns.CONFIGURE, value);
        return this;
    }

    public AppSelection configureLike(String... value) {
        addLike(AppColumns.CONFIGURE, value);
        return this;
    }

    public AppSelection configureContains(String... value) {
        addContains(AppColumns.CONFIGURE, value);
        return this;
    }

    public AppSelection configureStartsWith(String... value) {
        addStartsWith(AppColumns.CONFIGURE, value);
        return this;
    }

    public AppSelection configureEndsWith(String... value) {
        addEndsWith(AppColumns.CONFIGURE, value);
        return this;
    }

    public AppSelection orderByConfigure(boolean desc) {
        orderBy(AppColumns.CONFIGURE, desc);
        return this;
    }

    public AppSelection orderByConfigure() {
        orderBy(AppColumns.CONFIGURE, false);
        return this;
    }

    public AppSelection report(String... value) {
        addEquals(AppColumns.REPORT, value);
        return this;
    }

    public AppSelection reportNot(String... value) {
        addNotEquals(AppColumns.REPORT, value);
        return this;
    }

    public AppSelection reportLike(String... value) {
        addLike(AppColumns.REPORT, value);
        return this;
    }

    public AppSelection reportContains(String... value) {
        addContains(AppColumns.REPORT, value);
        return this;
    }

    public AppSelection reportStartsWith(String... value) {
        addStartsWith(AppColumns.REPORT, value);
        return this;
    }

    public AppSelection reportEndsWith(String... value) {
        addEndsWith(AppColumns.REPORT, value);
        return this;
    }

    public AppSelection orderByReport(boolean desc) {
        orderBy(AppColumns.REPORT, desc);
        return this;
    }

    public AppSelection orderByReport() {
        orderBy(AppColumns.REPORT, false);
        return this;
    }

    public AppSelection clear(String... value) {
        addEquals(AppColumns.CLEAR, value);
        return this;
    }

    public AppSelection clearNot(String... value) {
        addNotEquals(AppColumns.CLEAR, value);
        return this;
    }

    public AppSelection clearLike(String... value) {
        addLike(AppColumns.CLEAR, value);
        return this;
    }

    public AppSelection clearContains(String... value) {
        addContains(AppColumns.CLEAR, value);
        return this;
    }

    public AppSelection clearStartsWith(String... value) {
        addStartsWith(AppColumns.CLEAR, value);
        return this;
    }

    public AppSelection clearEndsWith(String... value) {
        addEndsWith(AppColumns.CLEAR, value);
        return this;
    }

    public AppSelection orderByClear(boolean desc) {
        orderBy(AppColumns.CLEAR, desc);
        return this;
    }

    public AppSelection orderByClear() {
        orderBy(AppColumns.CLEAR, false);
        return this;
    }

    public AppSelection runBackground(String... value) {
        addEquals(AppColumns.RUN_BACKGROUND, value);
        return this;
    }

    public AppSelection runBackgroundNot(String... value) {
        addNotEquals(AppColumns.RUN_BACKGROUND, value);
        return this;
    }

    public AppSelection runBackgroundLike(String... value) {
        addLike(AppColumns.RUN_BACKGROUND, value);
        return this;
    }

    public AppSelection runBackgroundContains(String... value) {
        addContains(AppColumns.RUN_BACKGROUND, value);
        return this;
    }

    public AppSelection runBackgroundStartsWith(String... value) {
        addStartsWith(AppColumns.RUN_BACKGROUND, value);
        return this;
    }

    public AppSelection runBackgroundEndsWith(String... value) {
        addEndsWith(AppColumns.RUN_BACKGROUND, value);
        return this;
    }

    public AppSelection orderByRunBackground(boolean desc) {
        orderBy(AppColumns.RUN_BACKGROUND, desc);
        return this;
    }

    public AppSelection orderByRunBackground() {
        orderBy(AppColumns.RUN_BACKGROUND, false);
        return this;
    }

    public AppSelection permission(String... value) {
        addEquals(AppColumns.PERMISSION, value);
        return this;
    }

    public AppSelection permissionNot(String... value) {
        addNotEquals(AppColumns.PERMISSION, value);
        return this;
    }

    public AppSelection permissionLike(String... value) {
        addLike(AppColumns.PERMISSION, value);
        return this;
    }

    public AppSelection permissionContains(String... value) {
        addContains(AppColumns.PERMISSION, value);
        return this;
    }

    public AppSelection permissionStartsWith(String... value) {
        addStartsWith(AppColumns.PERMISSION, value);
        return this;
    }

    public AppSelection permissionEndsWith(String... value) {
        addEndsWith(AppColumns.PERMISSION, value);
        return this;
    }

    public AppSelection orderByPermission(boolean desc) {
        orderBy(AppColumns.PERMISSION, desc);
        return this;
    }

    public AppSelection orderByPermission() {
        orderBy(AppColumns.PERMISSION, false);
        return this;
    }

    public AppSelection initialize(String... value) {
        addEquals(AppColumns.INITIALIZE, value);
        return this;
    }

    public AppSelection initializeNot(String... value) {
        addNotEquals(AppColumns.INITIALIZE, value);
        return this;
    }

    public AppSelection initializeLike(String... value) {
        addLike(AppColumns.INITIALIZE, value);
        return this;
    }

    public AppSelection initializeContains(String... value) {
        addContains(AppColumns.INITIALIZE, value);
        return this;
    }

    public AppSelection initializeStartsWith(String... value) {
        addStartsWith(AppColumns.INITIALIZE, value);
        return this;
    }

    public AppSelection initializeEndsWith(String... value) {
        addEndsWith(AppColumns.INITIALIZE, value);
        return this;
    }

    public AppSelection orderByInitialize(boolean desc) {
        orderBy(AppColumns.INITIALIZE, desc);
        return this;
    }

    public AppSelection orderByInitialize() {
        orderBy(AppColumns.INITIALIZE, false);
        return this;
    }

    public AppSelection initialized(Boolean value) {
        addEquals(AppColumns.INITIALIZED, toObjectArray(value));
        return this;
    }

    public AppSelection orderByInitialized(boolean desc) {
        orderBy(AppColumns.INITIALIZED, desc);
        return this;
    }

    public AppSelection orderByInitialized() {
        orderBy(AppColumns.INITIALIZED, false);
        return this;
    }

    public AppSelection configured(Boolean value) {
        addEquals(AppColumns.CONFIGURED, toObjectArray(value));
        return this;
    }

    public AppSelection orderByConfigured(boolean desc) {
        orderBy(AppColumns.CONFIGURED, desc);
        return this;
    }

    public AppSelection orderByConfigured() {
        orderBy(AppColumns.CONFIGURED, false);
        return this;
    }

    public AppSelection configureMatch(Boolean value) {
        addEquals(AppColumns.CONFIGURE_MATCH, toObjectArray(value));
        return this;
    }

    public AppSelection orderByConfigureMatch(boolean desc) {
        orderBy(AppColumns.CONFIGURE_MATCH, desc);
        return this;
    }

    public AppSelection orderByConfigureMatch() {
        orderBy(AppColumns.CONFIGURE_MATCH, false);
        return this;
    }

    public AppSelection runningTime(Boolean value) {
        addEquals(AppColumns.RUNNING_TIME, toObjectArray(value));
        return this;
    }

    public AppSelection orderByRunningTime(boolean desc) {
        orderBy(AppColumns.RUNNING_TIME, desc);
        return this;
    }

    public AppSelection orderByRunningTime() {
        orderBy(AppColumns.RUNNING_TIME, false);
        return this;
    }

    public AppSelection isRunningBackground(Boolean value) {
        addEquals(AppColumns.IS_RUNNING_BACKGROUND, toObjectArray(value));
        return this;
    }

    public AppSelection orderByIsRunningBackground(boolean desc) {
        orderBy(AppColumns.IS_RUNNING_BACKGROUND, desc);
        return this;
    }

    public AppSelection orderByIsRunningBackground() {
        orderBy(AppColumns.IS_RUNNING_BACKGROUND, false);
        return this;
    }

    public AppSelection permissionOk(Boolean value) {
        addEquals(AppColumns.PERMISSION_OK, toObjectArray(value));
        return this;
    }

    public AppSelection orderByPermissionOk(boolean desc) {
        orderBy(AppColumns.PERMISSION_OK, desc);
        return this;
    }

    public AppSelection orderByPermissionOk() {
        orderBy(AppColumns.PERMISSION_OK, false);
        return this;
    }

    public AppSelection datakitConnected(Boolean value) {
        addEquals(AppColumns.DATAKIT_CONNECTED, toObjectArray(value));
        return this;
    }

    public AppSelection orderByDatakitConnected(boolean desc) {
        orderBy(AppColumns.DATAKIT_CONNECTED, desc);
        return this;
    }

    public AppSelection orderByDatakitConnected() {
        orderBy(AppColumns.DATAKIT_CONNECTED, false);
        return this;
    }
}
