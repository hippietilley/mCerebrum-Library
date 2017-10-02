/*
 * This source is part of the
 *      _____  ___   ____
 *  __ / / _ \/ _ | / __/___  _______ _
 * / // / , _/ __ |/ _/_/ _ \/ __/ _ `/
 * \___/_/|_/_/ |_/_/ (_)___/_/  \_, /
 *                              /___/
 * repository.
 *
 * Copyright (C) 2012-2017 Benoit 'BoD' Lubek (BoD@JRAF.org)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.md2k.system.provider.appinfo;

// @formatter:off
import android.net.Uri;
import android.provider.BaseColumns;

import org.md2k.system.provider.SampleProvider;
import org.md2k.system.provider.base.AbstractSelection;
import org.md2k.system.provider.appinfo.AppInfoColumns;
import org.md2k.system.provider.configinfo.ConfigInfoColumns;
import org.md2k.system.provider.studyinfo.StudyInfoColumns;
import org.md2k.system.provider.userinfo.UserInfoColumns;

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

    public static final String AID = "aid";

    public static final String TYPE = "type";

    public static final String TITLE = "title";

    public static final String SUMMARY = "summary";

    public static final String DESCRIPTION = "description";

    public static final String PACKAGE_NAME = "package_name";

    public static final String DOWNLOAD_LINK = "download_link";

    public static final String UPDATES = "updates";

    /**
     * not in use, required, optional
     */
    public static final String USE_AS = "use_as";

    public static final String EXPECTED_VERSION = "expected_version";

    public static final String ICON = "icon";

    public static final String CURRENT_VERSION = "current_version";

    public static final String LATEST_VERSION = "latest_version";

    public static final String INSTALLED = "installed";

    public static final String MCEREBRUM_SUPPORTED = "mcerebrum_supported";

    public static final String INITIALIZED = "initialized";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." + PACKAGE_NAME;

    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            AID,
            TYPE,
            TITLE,
            SUMMARY,
            DESCRIPTION,
            PACKAGE_NAME,
            DOWNLOAD_LINK,
            UPDATES,
            USE_AS,
            EXPECTED_VERSION,
            ICON,
            CURRENT_VERSION,
            LATEST_VERSION,
            INSTALLED,
            MCEREBRUM_SUPPORTED,
            INITIALIZED
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(AID) || c.contains("." + AID)) return true;
            if (c.equals(TYPE) || c.contains("." + TYPE)) return true;
            if (c.equals(TITLE) || c.contains("." + TITLE)) return true;
            if (c.equals(SUMMARY) || c.contains("." + SUMMARY)) return true;
            if (c.equals(DESCRIPTION) || c.contains("." + DESCRIPTION)) return true;
            if (c.equals(PACKAGE_NAME) || c.contains("." + PACKAGE_NAME)) return true;
            if (c.equals(DOWNLOAD_LINK) || c.contains("." + DOWNLOAD_LINK)) return true;
            if (c.equals(UPDATES) || c.contains("." + UPDATES)) return true;
            if (c.equals(USE_AS) || c.contains("." + USE_AS)) return true;
            if (c.equals(EXPECTED_VERSION) || c.contains("." + EXPECTED_VERSION)) return true;
            if (c.equals(ICON) || c.contains("." + ICON)) return true;
            if (c.equals(CURRENT_VERSION) || c.contains("." + CURRENT_VERSION)) return true;
            if (c.equals(LATEST_VERSION) || c.contains("." + LATEST_VERSION)) return true;
            if (c.equals(INSTALLED) || c.contains("." + INSTALLED)) return true;
            if (c.equals(MCEREBRUM_SUPPORTED) || c.contains("." + MCEREBRUM_SUPPORTED)) return true;
            if (c.equals(INITIALIZED) || c.contains("." + INITIALIZED)) return true;
        }
        return false;
    }

}
