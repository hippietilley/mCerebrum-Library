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
package org.md2k.system.provider.serverinfo;

// @formatter:off
import android.net.Uri;
import android.provider.BaseColumns;

import org.md2k.system.provider.SampleProvider;
import org.md2k.system.provider.base.AbstractSelection;
import org.md2k.system.provider.appinfo.AppInfoColumns;
import org.md2k.system.provider.configinfo.ConfigInfoColumns;
import org.md2k.system.provider.serverinfo.ServerInfoColumns;
import org.md2k.system.provider.studyinfo.StudyInfoColumns;
import org.md2k.system.provider.userinfo.UserInfoColumns;

/**
 * Server information
 */
@SuppressWarnings("unused")
public class ServerInfoColumns implements BaseColumns {
    public static final String TABLE_NAME = "server_info";
    public static final Uri CONTENT_URI = Uri.parse(SampleProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String SERVER_ADDRESS = "server_address";

    public static final String USERNAME = "username";

    public static final String UUID = "uuid";

    public static final String PASSWORD_HASH = "password_hash";

    public static final String TOKEN = "token";

    public static final String FILE_NAME = "file_name";

    public static final String CURRENT_VERSION = "current_version";

    public static final String LATEST_VERSION = "latest_version";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            SERVER_ADDRESS,
            USERNAME,
            UUID,
            PASSWORD_HASH,
            TOKEN,
            FILE_NAME,
            CURRENT_VERSION,
            LATEST_VERSION
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(SERVER_ADDRESS) || c.contains("." + SERVER_ADDRESS)) return true;
            if (c.equals(USERNAME) || c.contains("." + USERNAME)) return true;
            if (c.equals(UUID) || c.contains("." + UUID)) return true;
            if (c.equals(PASSWORD_HASH) || c.contains("." + PASSWORD_HASH)) return true;
            if (c.equals(TOKEN) || c.contains("." + TOKEN)) return true;
            if (c.equals(FILE_NAME) || c.contains("." + FILE_NAME)) return true;
            if (c.equals(CURRENT_VERSION) || c.contains("." + CURRENT_VERSION)) return true;
            if (c.equals(LATEST_VERSION) || c.contains("." + LATEST_VERSION)) return true;
        }
        return false;
    }

}
