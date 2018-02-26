/*
 * Copyright (c) 2018, The University of Memphis, MD2K Center of Excellence
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.md2k.mcerebrum.core.access.appinfo;

import android.net.Uri;
import android.provider.BaseColumns;

import org.md2k.mcerebrum.core.access.SampleProvider;
import org.md2k.mcerebrum.core.access.base.AbstractSelection;
import org.md2k.mcerebrum.core.access.appinfo.AppInfoColumns;
import org.md2k.mcerebrum.core.access.configinfo.ConfigInfoColumns;
import org.md2k.mcerebrum.core.access.serverinfo.ServerInfoColumns;
import org.md2k.mcerebrum.core.access.studyinfo.StudyInfoColumns;
import org.md2k.mcerebrum.core.access.userinfo.UserInfoColumns;

/**
 * Application Information
 */
@SuppressWarnings("unused")
public class AppInfoColumns implements BaseColumns {
    public static final String TABLE_NAME = "app_info";
    public static final Uri CONTENT_URI = Uri.parse(SampleProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String PACKAGE_NAME = "package_name";

    /**
     * MCEREBRUM, STUDY, DATAKIT,any other string
     */
    public static final String TYPE = "type";

    public static final String TITLE = "title";

    public static final String SUMMARY = "summary";

    public static final String DESCRIPTION = "description";

    public static final String USE_IN_STUDY = "use_in_study";

    /**
     * not in use, required, optional
     */
    public static final String USE_AS = "use_as";

    public static final String INSTALLED = "installed";

    public static final String DOWNLOAD_LINK = "download_link";

    /**
     * NOTIFY, AUTO, MANUAL
     */
    public static final String UPDATES = "updates";

    public static final String CURRENT_VERSION = "current_version";

    public static final String LATEST_VERSION = "latest_version";

    public static final String EXPECTED_VERSION = "expected_version";

    public static final String ICON = "icon";

    public static final String MCEREBRUM_SUPPORTED = "mcerebrum_supported";

    public static final String FUNC_INITIALIZE = "func_initialize";

    public static final String INITIALIZED = "initialized";

    public static final String FUNC_UPDATE_INFO = "func_update_info";

    public static final String FUNC_CONFIGURE = "func_configure";

    public static final String CONFIGURED = "configured";

    public static final String CONFIGURE_MATCH = "configure_match";

    public static final String FUNC_PERMISSION = "func_permission";

    public static final String PERMISSION_OK = "permission_ok";

    public static final String FUNC_BACKGROUND = "func_background";

    public static final String BACKGROUND_RUNNING_TIME = "background_running_time";

    public static final String IS_BACKGROUND_RUNNING = "is_background_running";

    public static final String FUNC_REPORT = "func_report";

    public static final String FUNC_CLEAR = "func_clear";

    public static final String DATAKIT_CONNECTED = "datakit_connected";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." + _ID;

    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            PACKAGE_NAME,
            TYPE,
            TITLE,
            SUMMARY,
            DESCRIPTION,
            USE_IN_STUDY,
            USE_AS,
            INSTALLED,
            DOWNLOAD_LINK,
            UPDATES,
            CURRENT_VERSION,
            LATEST_VERSION,
            EXPECTED_VERSION,
            ICON,
            MCEREBRUM_SUPPORTED,
            FUNC_INITIALIZE,
            INITIALIZED,
            FUNC_UPDATE_INFO,
            FUNC_CONFIGURE,
            CONFIGURED,
            CONFIGURE_MATCH,
            FUNC_PERMISSION,
            PERMISSION_OK,
            FUNC_BACKGROUND,
            BACKGROUND_RUNNING_TIME,
            IS_BACKGROUND_RUNNING,
            FUNC_REPORT,
            FUNC_CLEAR,
            DATAKIT_CONNECTED
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null)
            return true;
        for (String c : projection) {
            if (c.equals(PACKAGE_NAME) || c.contains("." + PACKAGE_NAME)) return true;
            if (c.equals(TYPE) || c.contains("." + TYPE)) return true;
            if (c.equals(TITLE) || c.contains("." + TITLE)) return true;
            if (c.equals(SUMMARY) || c.contains("." + SUMMARY)) return true;
            if (c.equals(DESCRIPTION) || c.contains("." + DESCRIPTION)) return true;
            if (c.equals(USE_IN_STUDY) || c.contains("." + USE_IN_STUDY)) return true;
            if (c.equals(USE_AS) || c.contains("." + USE_AS)) return true;
            if (c.equals(INSTALLED) || c.contains("." + INSTALLED)) return true;
            if (c.equals(DOWNLOAD_LINK) || c.contains("." + DOWNLOAD_LINK)) return true;
            if (c.equals(UPDATES) || c.contains("." + UPDATES)) return true;
            if (c.equals(CURRENT_VERSION) || c.contains("." + CURRENT_VERSION)) return true;
            if (c.equals(LATEST_VERSION) || c.contains("." + LATEST_VERSION)) return true;
            if (c.equals(EXPECTED_VERSION) || c.contains("." + EXPECTED_VERSION)) return true;
            if (c.equals(ICON) || c.contains("." + ICON)) return true;
            if (c.equals(MCEREBRUM_SUPPORTED) || c.contains("." + MCEREBRUM_SUPPORTED)) return true;
            if (c.equals(FUNC_INITIALIZE) || c.contains("." + FUNC_INITIALIZE)) return true;
            if (c.equals(INITIALIZED) || c.contains("." + INITIALIZED)) return true;
            if (c.equals(FUNC_UPDATE_INFO) || c.contains("." + FUNC_UPDATE_INFO)) return true;
            if (c.equals(FUNC_CONFIGURE) || c.contains("." + FUNC_CONFIGURE)) return true;
            if (c.equals(CONFIGURED) || c.contains("." + CONFIGURED)) return true;
            if (c.equals(CONFIGURE_MATCH) || c.contains("." + CONFIGURE_MATCH)) return true;
            if (c.equals(FUNC_PERMISSION) || c.contains("." + FUNC_PERMISSION)) return true;
            if (c.equals(PERMISSION_OK) || c.contains("." + PERMISSION_OK)) return true;
            if (c.equals(FUNC_BACKGROUND) || c.contains("." + FUNC_BACKGROUND)) return true;
            if (c.equals(BACKGROUND_RUNNING_TIME) || c.contains("." + BACKGROUND_RUNNING_TIME)) return true;
            if (c.equals(IS_BACKGROUND_RUNNING) || c.contains("." + IS_BACKGROUND_RUNNING)) return true;
            if (c.equals(FUNC_REPORT) || c.contains("." + FUNC_REPORT)) return true;
            if (c.equals(FUNC_CLEAR) || c.contains("." + FUNC_CLEAR)) return true;
            if (c.equals(DATAKIT_CONNECTED) || c.contains("." + DATAKIT_CONNECTED)) return true;
        }
        return false;
    }
}
