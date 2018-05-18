package org.md2k.mcerebrum.core.access;

// @formatter:off

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import org.md2k.mcerebrum.core.access.appinfo.AppInfoColumns;
import org.md2k.mcerebrum.core.access.base.BaseContentProvider;

import java.util.Arrays;

public class SampleProvider extends BaseContentProvider {
    private static final String TAG = SampleProvider.class.getSimpleName();

    private static final boolean DEBUG = BuildConfig.DEBUG;

    private static final String TYPE_CURSOR_ITEM = "vnd.android.cursor.item/";
    private static final String TYPE_CURSOR_DIR = "vnd.android.cursor.dir/";

    public static final String AUTHORITY = "org.md2k.mcerebrum.provider";
    public static final String CONTENT_URI_BASE = "content://" + AUTHORITY;

    private static final int URI_TYPE_APP_INFO = 0;
    private static final int URI_TYPE_APP_INFO_ID = 1;

    private static final int URI_TYPE_CONFIG_INFO = 2;
    private static final int URI_TYPE_CONFIG_INFO_ID = 3;

    private static final int URI_TYPE_SERVER_INFO = 4;
    private static final int URI_TYPE_SERVER_INFO_ID = 5;

    private static final int URI_TYPE_STUDY_INFO = 6;
    private static final int URI_TYPE_STUDY_INFO_ID = 7;

    private static final int URI_TYPE_USER_INFO = 8;
    private static final int URI_TYPE_USER_INFO_ID = 9;



    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        URI_MATCHER.addURI(AUTHORITY, AppInfoColumns.TABLE_NAME, URI_TYPE_APP_INFO);
        URI_MATCHER.addURI(AUTHORITY, AppInfoColumns.TABLE_NAME + "/#", URI_TYPE_APP_INFO_ID);
    }

    @Override
    protected SQLiteOpenHelper createSqLiteOpenHelper() {
        return SampleProviderSQLiteOpenHelper.getInstance(getContext());
    }

    @Override
    protected boolean hasDebug() {
        return DEBUG;
    }

    @Override
    public String getType(Uri uri) {
        int match = URI_MATCHER.match(uri);
        switch (match) {
            case URI_TYPE_APP_INFO:
                return TYPE_CURSOR_DIR + AppInfoColumns.TABLE_NAME;
            case URI_TYPE_APP_INFO_ID:
                return TYPE_CURSOR_ITEM + AppInfoColumns.TABLE_NAME;

        }
        return null;
    }

    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        if (DEBUG) Log.d(TAG, "insert uri=" + uri + " values=" + values);
        return super.insert(uri, values);
    }

    @Override
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] values) {
        if (DEBUG) Log.d(TAG, "bulkInsert uri=" + uri + " values.length=" + values.length);
        return super.bulkInsert(uri, values);
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "update uri=" + uri + " values=" + values + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.update(uri, values, selection, selectionArgs);
    }

    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "delete uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.delete(uri, selection, selectionArgs);
    }

    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        if (DEBUG)
            Log.d(TAG, "query uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs) + " sortOrder=" + sortOrder
                    + " groupBy=" + uri.getQueryParameter(QUERY_GROUP_BY) + " having=" + uri.getQueryParameter(QUERY_HAVING) + " limit=" + uri.getQueryParameter(QUERY_LIMIT));
        return super.query(uri, projection, selection, selectionArgs, sortOrder);
    }

    @Override
    protected QueryParams getQueryParams(Uri uri, String selection, String[] projection) {
        QueryParams res = new QueryParams();
        String id = null;
        int matchedId = URI_MATCHER.match(uri);
        switch (matchedId) {
            case URI_TYPE_APP_INFO:
            case URI_TYPE_APP_INFO_ID:
                res.table = AppInfoColumns.TABLE_NAME;
                res.idColumn = AppInfoColumns._ID;
                res.tablesWithJoins = AppInfoColumns.TABLE_NAME;
                res.orderBy = AppInfoColumns.DEFAULT_ORDER;
                break;
            default:
                throw new IllegalArgumentException("The uri '" + uri + "' is not supported by this ContentProvider");
        }

        switch (matchedId) {
            case URI_TYPE_APP_INFO_ID:
            case URI_TYPE_CONFIG_INFO_ID:
            case URI_TYPE_SERVER_INFO_ID:
            case URI_TYPE_STUDY_INFO_ID:
            case URI_TYPE_USER_INFO_ID:
                id = uri.getLastPathSegment();
        }
        if (id != null) {
            if (selection != null) {
                res.selection = res.table + "." + res.idColumn + "=" + id + " and (" + selection + ")";
            } else {
                res.selection = res.table + "." + res.idColumn + "=" + id;
            }
        } else {
            res.selection = selection;
        }
        return res;
    }
}
