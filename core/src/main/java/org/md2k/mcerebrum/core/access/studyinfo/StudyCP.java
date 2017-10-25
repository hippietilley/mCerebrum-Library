package org.md2k.mcerebrum.core.access.studyinfo;
/*
 * Copyright (c) 2016, The University of Memphis, MD2K Center
 * - Syed Monowar Hossain <monowar.hossain@gmail.com>
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

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.md2k.mcerebrum.core.access.SampleProviderSQLiteOpenHelper;
import org.md2k.mcerebrum.core.access.studyinfo.StudyInfoBean;
import org.md2k.mcerebrum.core.access.studyinfo.StudyInfoColumns;
import org.md2k.mcerebrum.core.access.studyinfo.StudyInfoContentValues;
import org.md2k.mcerebrum.core.access.studyinfo.StudyInfoCursor;
import org.md2k.mcerebrum.core.access.studyinfo.StudyInfoSelection;

public class StudyCP {
    private static StudyInfoBean read(Context context) {
        StudyInfoBean studyInfoBean = null;
        try {
            StudyInfoSelection studyInfoSelection = new StudyInfoSelection();
            StudyInfoCursor c = studyInfoSelection.query(context);
            if (c.moveToNext())
                studyInfoBean = StudyInfoBean.newInstance(c.getId(), c.getSid(), c.getType(), c.getTitle(), c.getSummary(), c.getDescription(), c.getVersion(), c.getIcon(), c.getCoverImage(), c.getStartAtBoot(), c.getStarted());
            c.close();
        } catch (Exception ignored) {
        }
        return studyInfoBean;
    }

    public static void set(Context context, String sid, String type, String title, String summary, String description, String version, String icon, String coverImage, boolean startAtBoot) {
        StudyInfoBean studyInfoBean = StudyInfoBean.newBuilder().sid(sid).type(type).title(title).summary(summary).description(description).version(version).icon(icon).coverImage(coverImage).startAtBoot(startAtBoot).build();
        insertOrUpdate(context, studyInfoBean);
    }

    public static void deleteTable(Context context) {
        try {
            SampleProviderSQLiteOpenHelper s = SampleProviderSQLiteOpenHelper.getInstance(context);
            SQLiteDatabase db = s.getWritableDatabase();
            db.execSQL("DROP TABLE IF EXISTS " + StudyInfoColumns.TABLE_NAME);
            db.execSQL(SampleProviderSQLiteOpenHelper.SQL_CREATE_TABLE_STUDY_INFO);
            StudyInfoSelection studyInfoSelection = new StudyInfoSelection();
            studyInfoSelection.delete(context);
        }catch (Exception e){

        }
    }

    private static void insertOrUpdate(Context context, StudyInfoBean studyInfoBean) {
        try {
            StudyInfoContentValues values = prepare(studyInfoBean);
            if (isEmpty(context))
                values.insert(context);
            else values.update(context, new StudyInfoSelection().sid(studyInfoBean.getSid()));
        }catch (Exception e){
            deleteTable(context);
            StudyInfoContentValues values = prepare(studyInfoBean);
            values.insert(context);
        }
    }

/*
    public void setFromCP(StudyInfoCursor studyInfoCursor) {
        studyInfoBean.setSid(studyInfoCursor.getSid());
        studyInfoBean.setType(studyInfoCursor.getType());
        studyInfoBean.setTitle(studyInfoCursor.getTitle());
        studyInfoBean.setSummary(studyInfoCursor.getSummary());
        studyInfoBean.setDescription(studyInfoCursor.getDescription());
        studyInfoBean.setVersion(studyInfoCursor.getVersion());
        studyInfoBean.setCoverImage(studyInfoCursor.getCoverImage());
        studyInfoBean.setIcon(studyInfoCursor.getIcon());
        studyInfoBean.setStartAtBoot(studyInfoCursor.getStartAtBoot());
        studyInfoBean.setStarted(studyInfoCursor.getStarted());
    }
*/

    private static boolean isEmpty(Context context) {
        int count = 0;
        StudyInfoSelection studyInfoSelection = new StudyInfoSelection();
        StudyInfoCursor c = studyInfoSelection.query(context);
        while (c.moveToNext()) {
            count++;
        }
        c.close();
        return count == 0;
    }

    private static StudyInfoContentValues prepare(StudyInfoBean studyInfoBean) {
        StudyInfoContentValues values = new StudyInfoContentValues();
        values.putSid(studyInfoBean.getSid());
        values.putType(studyInfoBean.getType());
        values.putTitle(studyInfoBean.getTitle());
        values.putSummary(studyInfoBean.getSummary());
        values.putDescription(studyInfoBean.getDescription());
        values.putVersion(studyInfoBean.getVersion());
        values.putCoverImage(studyInfoBean.getCoverImage());
        values.putIcon(studyInfoBean.getIcon());
        values.putStartAtBoot(studyInfoBean.getStartAtBoot());
        values.putStarted(studyInfoBean.getStarted());
        return values;
    }

    public static String getTitle(Context context) {
        try {
            StudyInfoBean studyInfoBean = read(context);
            if (studyInfoBean == null) return null;
            return studyInfoBean.getTitle();
        } catch (Exception e) {
            return null;
        }
    }
    public static String getSummary(Context context) {
        try {
            StudyInfoBean studyInfoBean = read(context);
            if (studyInfoBean == null) return null;
            return studyInfoBean.getSummary();
        } catch (Exception e) {
            return null;
        }
    }
    public static String getDescription(Context context) {
        try {
            StudyInfoBean studyInfoBean = read(context);
            if (studyInfoBean == null) return null;
            return studyInfoBean.getDescription();
        } catch (Exception e) {
            return null;
        }
    }

    public static String getVersion(Context context) {
        try {
            StudyInfoBean studyInfoBean = read(context);
            if (studyInfoBean == null) return null;
            return studyInfoBean.getVersion();
        } catch (Exception e) {
            return null;
        }
    }
    public static String getSid(Context context) {
        try {
            StudyInfoBean studyInfoBean = read(context);
            if (studyInfoBean == null) return null;
            return studyInfoBean.getSid();
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean getStartAtBoot(Context context) {
        try {
            StudyInfoBean studyInfoBean = read(context);
            if (studyInfoBean == null) return false;
            return studyInfoBean.getStartAtBoot();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean getStarted(Context context) {
        try {
            StudyInfoBean studyInfoBean = read(context);
            if (studyInfoBean == null) return false;
            return studyInfoBean.getStarted();
        } catch (Exception e) {
            return false;
        }
    }

    public static String getIcon(Context context) {
        StudyInfoBean studyInfoBean = read(context);
        if (studyInfoBean == null) return null;
        return studyInfoBean.getIcon();
    }

    public static String getCoverImage(Context context) {
        StudyInfoBean studyInfoBean = read(context);
        if (studyInfoBean == null) return null;
        return studyInfoBean.getCoverImage();
    }

    public static void setStarted(Context context, boolean started) {
        StudyInfoBean studyInfoBean = read(context);
        if(studyInfoBean!=null && studyInfoBean.getStarted()!=null && studyInfoBean.getStarted()==started) return;
        studyInfoBean.setStarted(started);
        insertOrUpdate(context, studyInfoBean);
    }
}
