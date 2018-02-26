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

import org.md2k.mcerebrum.core.access.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Provides abstract methods for getting and setting application information fields.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface AppInfoModel extends BaseModel {

    /** Primary key. */
    long getId();

    /** Returns the name of the package. <p>Can be <code>null</code>.</p> */
    @Nullable
    String getPackageName();

    /** Returns the app type. <p>Can be <code>null</code>.</p> */
    @Nullable
    String getType();

    /** Returns the application title. <p>Can be <code>null</code>.</p> */
    @Nullable
    String getTitle();

    /** Returns the application summary. <p>Can be <code>null</code>.</p> */
    @Nullable
    String getSummary();

    /** Returns the app description. <p>Can be <code>null</code>.</p> */
    @Nullable
    String getDescription();

    /** Returns whether the app is used in <code>Study</code> or not. <p>Can be <code>null</code>.</p> */
    @Nullable
    Boolean getUseInStudy();

    /** Returns what the app is used as. <p>Can be <code>null</code>.</p> */
    @Nullable
    String getUseAs();

    /** Returns whether the app is installed or not. <p>Can be <code>null</code>.</p> */
    @Nullable
    Boolean getInstalled();

    /** Returns the download link for the app. <p>Can be <code>null</code>.</p> */
    @Nullable
    String getDownloadLink();

    /** Returns the update setting for the app. <p>Can be <code>null</code>.</p> */
    @Nullable
    String getUpdates();

    /** Returns the app's current version. <p>Can be <code>null</code>.</p> */
    @Nullable
    String getCurrentVersion();

    /** Returns the app's latest version. <p>Can be <code>null</code>.</p> */
    @Nullable
    String getLatestVersion();

    /** Returns the expected version of the app. <p>Can be <code>null</code>.</p> */
    @Nullable
    String getExpectedVersion();

    /** Returns the file path of the application icon. <p>Can be <code>null</code>.</p> */
    @Nullable
    String getIcon();

    /** Returns whether mCerebrum is supported by the app or not. <p>Can be <code>null</code>.</p> */
    @Nullable
    Boolean getMcerebrumSupported();

    /** <p>Can be <code>null</code>.</p> */
    @Nullable
    String getFuncInitialize();

    /**Return whether the app is initailizd or not. <p>Can be <code>null</code>.</p> */
    @Nullable
    Boolean getInitialized();

    /** <p>Can be <code>null</code>.</p> */
    @Nullable
    String getFuncUpdateInfo();

    /** <p>Can be <code>null</code>.</p> */
    @Nullable
    String getFuncConfigure();

    /** Returns whether the app is configured or not. <p>Can be <code>null</code>.</p> */
    @Nullable
    Boolean getConfigured();

    /** <p>Can be <code>null</code>.</p> */
    @Nullable
    Boolean getConfigureMatch();

    /** <p>Can be <code>null</code>.</p> */
    @Nullable
    String getFuncPermission();

    /** Returns whether the app has the appropriate permissions or not. <p>Can be <code>null</code>.</p> */
    @Nullable
    Boolean getPermissionOk();

    /** <p>Can be <code>null</code>.</p> */
    @Nullable
    String getFuncBackground();

    /** <p>Can be <code>null</code>.</p> */
    @Nullable
    Boolean getBackgroundRunningTime();

    /** Returns whether the app is running in the background. <p>Can be <code>null</code>.</p> */
    @Nullable
    Boolean getIsBackgroundRunning();

    /** <p>Can be <code>null</code>.</p> */
    @Nullable
    String getFuncReport();

    /** <p>Can be <code>null</code>.</p> */
    @Nullable
    String getFuncClear();

    /** Returns whether <code>DataKit</code> is connected. <p>Can be <code>null</code>.</p> */
    @Nullable
    Boolean getDatakitConnected();
}
