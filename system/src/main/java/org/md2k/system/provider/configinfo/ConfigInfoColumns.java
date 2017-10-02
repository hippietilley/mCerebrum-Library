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
package org.md2k.system.provider.configinfo;

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
 * Configuration Information
 */
@SuppressWarnings("unused")
public class ConfigInfoColumns implements BaseColumns {
    public static final String TABLE_NAME = "config_info";
    public static final Uri CONTENT_URI = Uri.parse(SampleProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String CID = "cid";

    public static final String TYPE = "type";

    public static final String TITLE = "title";

    public static final String SUMMARY = "summary";

    public static final String DESCRIPTION = "description";

    public static final String VERSIONS = "versions";

    public static final String UPDATES = "updates";

    public static final String EXPECTED_VERSION = "expected_version";

    public static final String LATEST_VERSION = "latest_version";

    public static final String DOWNLOAD_LINK = "download_link";

    public static final String LAST_UPDATED = "last_updated";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            CID,
            TYPE,
            TITLE,
            SUMMARY,
            DESCRIPTION,
            VERSIONS,
            UPDATES,
            EXPECTED_VERSION,
            LATEST_VERSION,
            DOWNLOAD_LINK,
            LAST_UPDATED
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(CID) || c.contains("." + CID)) return true;
            if (c.equals(TYPE) || c.contains("." + TYPE)) return true;
            if (c.equals(TITLE) || c.contains("." + TITLE)) return true;
            if (c.equals(SUMMARY) || c.contains("." + SUMMARY)) return true;
            if (c.equals(DESCRIPTION) || c.contains("." + DESCRIPTION)) return true;
            if (c.equals(VERSIONS) || c.contains("." + VERSIONS)) return true;
            if (c.equals(UPDATES) || c.contains("." + UPDATES)) return true;
            if (c.equals(EXPECTED_VERSION) || c.contains("." + EXPECTED_VERSION)) return true;
            if (c.equals(LATEST_VERSION) || c.contains("." + LATEST_VERSION)) return true;
            if (c.equals(DOWNLOAD_LINK) || c.contains("." + DOWNLOAD_LINK)) return true;
            if (c.equals(LAST_UPDATED) || c.contains("." + LAST_UPDATED)) return true;
        }
        return false;
    }

}
