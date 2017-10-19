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

import org.md2k.mcerebrum.core.access.base.BaseSQLiteOpenHelperCallbacks;
import org.md2k.mcerebrum.core.access.SampleSQLiteOpenHelperCallbacks;
import org.md2k.mcerebrum.core.access.BuildConfig;
import org.md2k.mcerebrum.core.access.appinfo.AppInfoColumns;
import org.md2k.mcerebrum.core.access.configinfo.ConfigInfoColumns;
import org.md2k.mcerebrum.core.access.serverinfo.ServerInfoColumns;
import org.md2k.mcerebrum.core.access.studyinfo.StudyInfoColumns;
import org.md2k.mcerebrum.core.access.userinfo.UserInfoColumns;

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

    public static final String SQL_CREATE_TABLE_CONFIG_INFO = "CREATE TABLE IF NOT EXISTS "
            + ConfigInfoColumns.TABLE_NAME + " ( "
            + ConfigInfoColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ConfigInfoColumns.CID + " TEXT, "
            + ConfigInfoColumns.TYPE + " TEXT, "
            + ConfigInfoColumns.TITLE + " TEXT, "
            + ConfigInfoColumns.SUMMARY + " TEXT, "
            + ConfigInfoColumns.DESCRIPTION + " TEXT, "
            + ConfigInfoColumns.VERSIONS + " TEXT, "
            + ConfigInfoColumns.UPDATES + " TEXT DEFAULT 'manual', "
            + ConfigInfoColumns.EXPECTED_VERSION + " TEXT, "
            + ConfigInfoColumns.LATEST_VERSION + " TEXT, "
            + ConfigInfoColumns.DOWNLOAD_FROM + " TEXT DEFAULT 'url', "
            + ConfigInfoColumns.DOWNLOAD_LINK + " TEXT "
            + ", CONSTRAINT unique_name UNIQUE (cid, type) ON CONFLICT REPLACE"
            + " );";

    public static final String SQL_CREATE_TABLE_SERVER_INFO = "CREATE TABLE IF NOT EXISTS "
            + ServerInfoColumns.TABLE_NAME + " ( "
            + ServerInfoColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ServerInfoColumns.SERVER_ADDRESS + " TEXT, "
            + ServerInfoColumns.USERNAME + " TEXT, "
            + ServerInfoColumns.UUID + " TEXT, "
            + ServerInfoColumns.PASSWORD_HASH + " TEXT, "
            + ServerInfoColumns.TOKEN + " TEXT, "
            + ServerInfoColumns.FILE_NAME + " TEXT, "
            + ServerInfoColumns.CURRENT_VERSION + " TEXT, "
            + ServerInfoColumns.LATEST_VERSION + " TEXT "
            + ", CONSTRAINT unique_name UNIQUE (username) ON CONFLICT REPLACE"
            + " );";

    public static final String SQL_CREATE_TABLE_STUDY_INFO = "CREATE TABLE IF NOT EXISTS "
            + StudyInfoColumns.TABLE_NAME + " ( "
            + StudyInfoColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + StudyInfoColumns.SID + " TEXT, "
            + StudyInfoColumns.TYPE + " TEXT DEFAULT 'FREEBIE', "
            + StudyInfoColumns.TITLE + " TEXT, "
            + StudyInfoColumns.SUMMARY + " TEXT, "
            + StudyInfoColumns.DESCRIPTION + " TEXT, "
            + StudyInfoColumns.VERSION + " TEXT, "
            + StudyInfoColumns.ICON + " TEXT, "
            + StudyInfoColumns.COVER_IMAGE + " TEXT, "
            + StudyInfoColumns.START_AT_BOOT + " INTEGER, "
            + StudyInfoColumns.STARTED + " INTEGER "
            + ", CONSTRAINT unique_name UNIQUE (sid, type) ON CONFLICT REPLACE"
            + " );";

    public static final String SQL_CREATE_TABLE_USER_INFO = "CREATE TABLE IF NOT EXISTS "
            + UserInfoColumns.TABLE_NAME + " ( "
            + UserInfoColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + UserInfoColumns.UID + " TEXT, "
            + UserInfoColumns.TYPE + " TEXT, "
            + UserInfoColumns.USERNAME + " TEXT "
            + ", CONSTRAINT unique_name UNIQUE (uid) ON CONFLICT REPLACE"
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
        db.execSQL(SQL_CREATE_TABLE_CONFIG_INFO);
        db.execSQL(SQL_CREATE_TABLE_SERVER_INFO);
        db.execSQL(SQL_CREATE_TABLE_STUDY_INFO);
        db.execSQL(SQL_CREATE_TABLE_USER_INFO);
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
