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
import org.md2k.system.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Application Information
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface AppInfoModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Get the {@code aid} value.
     * Can be {@code null}.
     */
    @Nullable
    String getAid();

    /**
     * Get the {@code type} value.
     * Can be {@code null}.
     */
    @Nullable
    String getType();

    /**
     * Get the {@code title} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTitle();

    /**
     * Get the {@code summary} value.
     * Can be {@code null}.
     */
    @Nullable
    String getSummary();

    /**
     * Get the {@code description} value.
     * Can be {@code null}.
     */
    @Nullable
    String getDescription();

    /**
     * Get the {@code package_name} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPackageName();

    /**
     * Get the {@code download_link} value.
     * Can be {@code null}.
     */
    @Nullable
    String getDownloadLink();

    /**
     * Get the {@code updates} value.
     * Can be {@code null}.
     */
    @Nullable
    String getUpdates();

    /**
     * not in use, required, optional
     * Can be {@code null}.
     */
    @Nullable
    String getUseAs();

    /**
     * Get the {@code expected_version} value.
     * Can be {@code null}.
     */
    @Nullable
    String getExpectedVersion();

    /**
     * Get the {@code icon} value.
     * Can be {@code null}.
     */
    @Nullable
    String getIcon();

    /**
     * Get the {@code current_version} value.
     * Can be {@code null}.
     */
    @Nullable
    String getCurrentVersion();

    /**
     * Get the {@code latest_version} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLatestVersion();

    /**
     * Get the {@code installed} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getInstalled();

    /**
     * Get the {@code mcerebrum_supported} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getMcerebrumSupported();

    /**
     * Get the {@code initialized} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getInitialized();
}
