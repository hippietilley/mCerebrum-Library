package org.md2k.mycontentprovider.app;

// @formatter:off
import android.net.Uri;
import android.provider.BaseColumns;

import org.md2k.mycontentprovider.SampleProvider;
import org.md2k.mycontentprovider.base.AbstractSelection;
import org.md2k.mycontentprovider.app.AppColumns;

/**
 * Application Information
 */
@SuppressWarnings("unused")
public class AppColumns implements BaseColumns {
    public static final String TABLE_NAME = "app";
    public static final Uri CONTENT_URI = Uri.parse(SampleProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String PACKAGE_NAME = "package_name";

    public static final String CONFIGURE = "configure";

    public static final String REPORT = "report";

    public static final String CLEAR = "clear";

    public static final String RUN_BACKGROUND = "run_background";

    public static final String PERMISSION = "permission";

    public static final String INITIALIZE = "initialize";

    public static final String INITIALIZED = "initialized";

    public static final String CONFIGURED = "configured";

    public static final String CONFIGURE_MATCH = "configure_match";

    public static final String RUNNING_TIME = "running_time";

    public static final String IS_RUNNING_BACKGROUND = "is_running_background";

    public static final String PERMISSION_OK = "permission_ok";

    public static final String DATAKIT_CONNECTED = "datakit_connected";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." + _ID;

    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            PACKAGE_NAME,
            CONFIGURE,
            REPORT,
            CLEAR,
            RUN_BACKGROUND,
            PERMISSION,
            INITIALIZE,
            INITIALIZED,
            CONFIGURED,
            CONFIGURE_MATCH,
            RUNNING_TIME,
            IS_RUNNING_BACKGROUND,
            PERMISSION_OK,
            DATAKIT_CONNECTED
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(PACKAGE_NAME) || c.contains("." + PACKAGE_NAME)) return true;
            if (c.equals(CONFIGURE) || c.contains("." + CONFIGURE)) return true;
            if (c.equals(REPORT) || c.contains("." + REPORT)) return true;
            if (c.equals(CLEAR) || c.contains("." + CLEAR)) return true;
            if (c.equals(RUN_BACKGROUND) || c.contains("." + RUN_BACKGROUND)) return true;
            if (c.equals(PERMISSION) || c.contains("." + PERMISSION)) return true;
            if (c.equals(INITIALIZE) || c.contains("." + INITIALIZE)) return true;
            if (c.equals(INITIALIZED) || c.contains("." + INITIALIZED)) return true;
            if (c.equals(CONFIGURED) || c.contains("." + CONFIGURED)) return true;
            if (c.equals(CONFIGURE_MATCH) || c.contains("." + CONFIGURE_MATCH)) return true;
            if (c.equals(RUNNING_TIME) || c.contains("." + RUNNING_TIME)) return true;
            if (c.equals(IS_RUNNING_BACKGROUND) || c.contains("." + IS_RUNNING_BACKGROUND)) return true;
            if (c.equals(PERMISSION_OK) || c.contains("." + PERMISSION_OK)) return true;
            if (c.equals(DATAKIT_CONNECTED) || c.contains("." + DATAKIT_CONNECTED)) return true;
        }
        return false;
    }

}
