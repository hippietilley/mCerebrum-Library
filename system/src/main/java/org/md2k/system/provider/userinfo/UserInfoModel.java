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
package org.md2k.system.provider.userinfo;

// @formatter:off
import org.md2k.system.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * User information
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface UserInfoModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Get the {@code uid} value.
     * Can be {@code null}.
     */
    @Nullable
    String getUid();

    /**
     * Get the {@code type} value.
     * Can be {@code null}.
     */
    @Nullable
    String getType();

    /**
     * Get the {@code username} value.
     * Can be {@code null}.
     */
    @Nullable
    String getUsername();

    /**
     * Get the {@code logged_in} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getLoggedIn();

    /**
     * Get the {@code token} value.
     * Can be {@code null}.
     */
    @Nullable
    String getToken();

    /**
     * Get the {@code password_hash} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPasswordHash();
}
