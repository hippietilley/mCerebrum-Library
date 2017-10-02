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
package org.md2k.system.provider.studyinfo;

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
 * Study Information
 */
@SuppressWarnings("unused")
public class StudyInfoColumns implements BaseColumns {
    public static final String TABLE_NAME = "study_info";
    public static final Uri CONTENT_URI = Uri.parse(SampleProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String SID = "sid";

    public static final String TYPE = "type";

    public static final String TITLE = "title";

    public static final String SUMMARY = "summary";

    public static final String DESCRIPTION = "description";

    public static final String VERSION = "version";

    public static final String ICON = "icon";

    public static final String COVER_IMAGE = "cover_image";

    public static final String START_AT_BOOT = "start_at_boot";

    public static final String STARTED = "started";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." + SID;

    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            SID,
            TYPE,
            TITLE,
            SUMMARY,
            DESCRIPTION,
            VERSION,
            ICON,
            COVER_IMAGE,
            START_AT_BOOT,
            STARTED
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(SID) || c.contains("." + SID)) return true;
            if (c.equals(TYPE) || c.contains("." + TYPE)) return true;
            if (c.equals(TITLE) || c.contains("." + TITLE)) return true;
            if (c.equals(SUMMARY) || c.contains("." + SUMMARY)) return true;
            if (c.equals(DESCRIPTION) || c.contains("." + DESCRIPTION)) return true;
            if (c.equals(VERSION) || c.contains("." + VERSION)) return true;
            if (c.equals(ICON) || c.contains("." + ICON)) return true;
            if (c.equals(COVER_IMAGE) || c.contains("." + COVER_IMAGE)) return true;
            if (c.equals(START_AT_BOOT) || c.contains("." + START_AT_BOOT)) return true;
            if (c.equals(STARTED) || c.contains("." + STARTED)) return true;
        }
        return false;
    }

}
