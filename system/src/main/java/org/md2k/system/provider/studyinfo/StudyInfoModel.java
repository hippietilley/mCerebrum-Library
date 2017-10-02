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
import org.md2k.system.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Study Information
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface StudyInfoModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Get the {@code sid} value.
     * Can be {@code null}.
     */
    @Nullable
    String getSid();

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
     * Get the {@code version} value.
     * Can be {@code null}.
     */
    @Nullable
    String getVersion();

    /**
     * Get the {@code icon} value.
     * Can be {@code null}.
     */
    @Nullable
    String getIcon();

    /**
     * Get the {@code cover_image} value.
     * Can be {@code null}.
     */
    @Nullable
    String getCoverImage();

    /**
     * Get the {@code start_at_boot} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getStartAtBoot();

    /**
     * Get the {@code started} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getStarted();
}
