package org.md2k.mcerebrum.core.access;

// @formatter:off

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import org.md2k.mcerebrum.core.access.appinfo.AppInfoColumns;
import org.md2k.mcerebrum.core.access.base.BaseSQLiteOpenHelperCallbacks;

public class SampleProviderSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = SampleProviderSQLiteOpenHelper.class.getSimpleName();

    public static final String DATABASE_FILE_NAME = "sample.db";
    private static final int DATABASE_VERSION = 1;
    private static SampleProviderSQLiteOpenHelper sInstance;
    private final Context mContext;
    private final BaseSQLiteOpenHelperCallbacks mOpenHelperCallbacks;

    public static final String SQL_CREATE_TABLE_APP_INFO = "CREATE TABLE IF NOT EXISTS "
            + AppInfoColumns.TABLE_NAME + " ( "
            + AppInfoColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + AppInfoColumns.PACKAGE_NAME + " TEXT, "
            + AppInfoColumns.TYPE + " TEXT DEFAULT 'other', "
            + AppInfoColumns.TITLE + " TEXT, "
            + AppInfoColumns.SUMMARY + " TEXT, "
            + AppInfoColumns.DESCRIPTION + " TEXT, "
            + AppInfoColumns.USE_IN_STUDY + " INTEGER DEFAULT 0, "
            + AppInfoColumns.USE_AS + " TEXT DEFAULT 'optional', "
            + AppInfoColumns.INSTALLED + " INTEGER DEFAULT 0, "
            + AppInfoColumns.DOWNLOAD_LINK + " TEXT, "
            + AppInfoColumns.UPDATES + " TEXT DEFAULT 'notify', "
            + AppInfoColumns.CURRENT_VERSION + " TEXT, "
            + AppInfoColumns.LATEST_VERSION + " TEXT, "
            + AppInfoColumns.EXPECTED_VERSION + " TEXT, "
            + AppInfoColumns.ICON + " TEXT, "
            + AppInfoColumns.MCEREBRUM_SUPPORTED + " INTEGER DEFAULT 0, "
            + AppInfoColumns.FUNC_INITIALIZE + " TEXT, "
            + AppInfoColumns.INITIALIZED + " INTEGER DEFAULT 0, "
            + AppInfoColumns.FUNC_UPDATE_INFO + " TEXT, "
            + AppInfoColumns.FUNC_CONFIGURE + " TEXT, "
            + AppInfoColumns.CONFIGURED + " INTEGER DEFAULT 0, "
            + AppInfoColumns.CONFIGURE_MATCH + " INTEGER DEFAULT 0, "
            + AppInfoColumns.FUNC_PERMISSION + " TEXT, "
            + AppInfoColumns.PERMISSION_OK + " INTEGER DEFAULT 0, "
            + AppInfoColumns.FUNC_BACKGROUND + " TEXT, "
            + AppInfoColumns.BACKGROUND_RUNNING_TIME + " INTEGER DEFAULT 0, "
            + AppInfoColumns.IS_BACKGROUND_RUNNING + " INTEGER DEFAULT 0, "
            + AppInfoColumns.FUNC_REPORT + " TEXT, "
            + AppInfoColumns.FUNC_CLEAR + " TEXT, "
            + AppInfoColumns.DATAKIT_CONNECTED + " INTEGER DEFAULT 0 "
            + ", CONSTRAINT unique_name UNIQUE (package_name) ON CONFLICT REPLACE"
            + " );";


    public static SampleProviderSQLiteOpenHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = newInstance(context.getApplicationContext());
        }
        return sInstance;
    }

    private static SampleProviderSQLiteOpenHelper newInstance(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return newInstancePreHoneycomb(context);
        }
        return newInstancePostHoneycomb(context);
    }


    /*
     * Pre Honeycomb.
     */
    private static SampleProviderSQLiteOpenHelper newInstancePreHoneycomb(Context context) {
        return new SampleProviderSQLiteOpenHelper(context);
    }

    private SampleProviderSQLiteOpenHelper(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
        mContext = context;
        mOpenHelperCallbacks = new SampleSQLiteOpenHelperCallbacks();
    }


    /*
     * Post Honeycomb.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private static SampleProviderSQLiteOpenHelper newInstancePostHoneycomb(Context context) {
        return new SampleProviderSQLiteOpenHelper(context, new DefaultDatabaseErrorHandler());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private SampleProviderSQLiteOpenHelper(Context context, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION, errorHandler);
        mContext = context;
        mOpenHelperCallbacks = new SampleSQLiteOpenHelperCallbacks();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate");
        mOpenHelperCallbacks.onPreCreate(mContext, db);
        db.execSQL(SQL_CREATE_TABLE_APP_INFO);
        mOpenHelperCallbacks.onPostCreate(mContext, db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            setForeignKeyConstraintsEnabled(db);
        }
        mOpenHelperCallbacks.onOpen(mContext, db);
    }

    private void setForeignKeyConstraintsEnabled(SQLiteDatabase db) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            setForeignKeyConstraintsEnabledPreJellyBean(db);
        } else {
            setForeignKeyConstraintsEnabledPostJellyBean(db);
        }
    }

    private void setForeignKeyConstraintsEnabledPreJellyBean(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setForeignKeyConstraintsEnabledPostJellyBean(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        mOpenHelperCallbacks.onUpgrade(mContext, db, oldVersion, newVersion);
    }
}
