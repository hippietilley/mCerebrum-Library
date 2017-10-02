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
import org.md2k.system.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Configuration Information
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface ConfigInfoModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Get the {@code cid} value.
     * Can be {@code null}.
     */
    @Nullable
    String getCid();

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
     * Get the {@code versions} value.
     * Can be {@code null}.
     */
    @Nullable
    String getVersions();

    /**
     * Get the {@code updates} value.
     * Can be {@code null}.
     */
    @Nullable
    String getUpdates();

    /**
     * Get the {@code expected_version} value.
     * Can be {@code null}.
     */
    @Nullable
    String getExpectedVersion();

    /**
     * Get the {@code latest_version} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLatestVersion();

    /**
     * Get the {@code download_link} value.
     * Can be {@code null}.
     */
    @Nullable
    String getDownloadLink();

    /**
     * Get the {@code last_updated} value.
     * Can be {@code null}.
     */
    @Nullable
    Long getLastUpdated();
}
