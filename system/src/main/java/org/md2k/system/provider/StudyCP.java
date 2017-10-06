package org.md2k.system.provider;
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
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import org.md2k.system.provider.studyinfo.StudyInfoBean;
import org.md2k.system.provider.studyinfo.StudyInfoContentValues;
import org.md2k.system.provider.studyinfo.StudyInfoCursor;
import org.md2k.system.provider.studyinfo.StudyInfoSelection;

import java.io.IOException;

public class StudyCP{
    private StudyInfoBean studyInfoBean;

    public StudyCP() {
        studyInfoBean = new StudyInfoBean();
    }

    public void set(Context context, String sid, String type, String title, String summary, String description, String version,String icon, String coverImage, boolean startAtBoot) {
        studyInfoBean.setSid(sid);
        studyInfoBean.setType(type);
        studyInfoBean.setTitle(title);
        studyInfoBean.setSummary(summary);
        studyInfoBean.setDescription(description);
        studyInfoBean.setVersion(version);
        studyInfoBean.setIcon(icon);
        studyInfoBean.setCoverImage(coverImage);
        studyInfoBean.setStartAtBoot(startAtBoot);
        insertOrUpdate(context);
    }

    public void delete(Context context) {
        StudyInfoSelection studyInfoSelection = new StudyInfoSelection();
        studyInfoSelection.delete(context);
    }

    public void insertOrUpdate(Context context) {
        StudyInfoContentValues values = prepare();
        if(isEmpty(context))
        values.insert(context);
        else values.update(context, new StudyInfoSelection().sid(studyInfoBean.getSid()));
    }

    public boolean read(Context context) {
        try {
            StudyInfoSelection studyInfoSelection = new StudyInfoSelection();
            StudyInfoCursor c = studyInfoSelection.query(context);
            if (c.moveToNext()) {
                setFromCP(c);
                c.close();
                return true;
            } else {
                c.close();
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

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

    public boolean isEmpty(Context context) {
        int count = 0;
        StudyInfoSelection studyInfoSelection = new StudyInfoSelection();
        StudyInfoCursor c = studyInfoSelection.query(context);
        while (c.moveToNext()) {
            count++;
        }
        c.close();
        return count == 0;
    }

    private StudyInfoContentValues prepare() {
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

    public String getTitle() {
        return studyInfoBean.getTitle();
    }

    public String getType() {
        return studyInfoBean.getType();
    }

    public boolean getStartAtBoot() {
        try{
            return studyInfoBean.getStartAtBoot();
        }catch (Exception e){
            return false;
        }
    }
    public boolean getStarted(){
        try {
            return studyInfoBean.getStarted();
        }catch (Exception e){
            return false;
        }
    }

    public String getIcon() {
        return studyInfoBean.getIcon();
    }

    public String getCoverImage() {
        return studyInfoBean.getCoverImage();
    }

    public void setStarted(Context context, boolean started) {
        studyInfoBean.setStarted(started);
        insertOrUpdate(context);
    }
}
