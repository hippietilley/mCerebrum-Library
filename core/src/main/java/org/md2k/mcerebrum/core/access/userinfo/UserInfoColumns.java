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

package org.md2k.mcerebrum.core.access.userinfo;

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
 * Provides columns for the user info table.
 */
@SuppressWarnings("unused")
public class UserInfoColumns implements BaseColumns {
    /** SQL database table name. <p><code>"user_info"</code></p> */
    public static final String TABLE_NAME = "user_info";

    /** Content resource identifier */
    public static final Uri CONTENT_URI = Uri.parse(SampleProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /** Primary key */
    public static final String _ID = BaseColumns._ID;

    /** User identifier */
    public static final String UID = "uid";

    /** User type */
    public static final String TYPE = "type";

    /** Username */
    public static final String USERNAME = "username";

    /** Default order <p>Default is null.</p> */
    public static final String DEFAULT_ORDER = null;

    /** String array of all coumns */
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            UID,
            TYPE,
            USERNAME
    };

    /**
     * Checks to see if the table has all the required columns.
     * <p>
     *     The user info table should have columns for:
     *     <ul>
     *         <li>UID</li>
     *         <li>Type</li>
     *         <li>Username</li>
     *         <li>_ID (Primary key)</li>
     *     </ul>
     * </p>
     * @param projection List of columns in the table.
     * @return
     */
    public static boolean hasColumns(String[] projection) {
        if (projection == null)
            return true;
        for (String c : projection) {
            if (c.equals(UID) || c.contains("." + UID))
                return true;
            if (c.equals(TYPE) || c.contains("." + TYPE))
                return true;
            if (c.equals(USERNAME) || c.contains("." + USERNAME))
                return true;
        }
        return false;
    }
}
