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
import org.md2k.system.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Server information
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class ServerInfoBean implements ServerInfoModel {
    private long mId;
    private String mServerAddress;
    private String mUsername;
    private String mUuid;
    private String mPasswordHash;
    private String mToken;
    private String mFileName;
    private String mCurrentVersion;
    private String mLatestVersion;

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        return mId;
    }

    /**
     * Primary key.
     */
    public void setId(long id) {
        mId = id;
    }

    /**
     * Get the {@code server_address} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getServerAddress() {
        return mServerAddress;
    }

    /**
     * Set the {@code server_address} value.
     * Can be {@code null}.
     */
    public void setServerAddress(@Nullable String serverAddress) {
        mServerAddress = serverAddress;
    }

    /**
     * Get the {@code username} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getUsername() {
        return mUsername;
    }

    /**
     * Set the {@code username} value.
     * Can be {@code null}.
     */
    public void setUsername(@Nullable String username) {
        mUsername = username;
    }

    /**
     * Get the {@code uuid} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getUuid() {
        return mUuid;
    }

    /**
     * Set the {@code uuid} value.
     * Can be {@code null}.
     */
    public void setUuid(@Nullable String uuid) {
        mUuid = uuid;
    }

    /**
     * Get the {@code password_hash} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPasswordHash() {
        return mPasswordHash;
    }

    /**
     * Set the {@code password_hash} value.
     * Can be {@code null}.
     */
    public void setPasswordHash(@Nullable String passwordHash) {
        mPasswordHash = passwordHash;
    }

    /**
     * Get the {@code token} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getToken() {
        return mToken;
    }

    /**
     * Set the {@code token} value.
     * Can be {@code null}.
     */
    public void setToken(@Nullable String token) {
        mToken = token;
    }

    /**
     * Get the {@code file_name} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getFileName() {
        return mFileName;
    }

    /**
     * Set the {@code file_name} value.
     * Can be {@code null}.
     */
    public void setFileName(@Nullable String fileName) {
        mFileName = fileName;
    }

    /**
     * Get the {@code current_version} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getCurrentVersion() {
        return mCurrentVersion;
    }

    /**
     * Set the {@code current_version} value.
     * Can be {@code null}.
     */
    public void setCurrentVersion(@Nullable String currentVersion) {
        mCurrentVersion = currentVersion;
    }

    /**
     * Get the {@code latest_version} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getLatestVersion() {
        return mLatestVersion;
    }

    /**
     * Set the {@code latest_version} value.
     * Can be {@code null}.
     */
    public void setLatestVersion(@Nullable String latestVersion) {
        mLatestVersion = latestVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServerInfoBean bean = (ServerInfoBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    /**
     * Instantiate a new ServerInfoBean with specified values.
     */
    @NonNull
    public static ServerInfoBean newInstance(long id, @Nullable String serverAddress, @Nullable String username, @Nullable String uuid, @Nullable String passwordHash, @Nullable String token, @Nullable String fileName, @Nullable String currentVersion, @Nullable String latestVersion) {
        ServerInfoBean res = new ServerInfoBean();
        res.mId = id;
        res.mServerAddress = serverAddress;
        res.mUsername = username;
        res.mUuid = uuid;
        res.mPasswordHash = passwordHash;
        res.mToken = token;
        res.mFileName = fileName;
        res.mCurrentVersion = currentVersion;
        res.mLatestVersion = latestVersion;
        return res;
    }

    /**
     * Instantiate a new ServerInfoBean with all the values copied from the given model.
     */
    @NonNull
    public static ServerInfoBean copy(@NonNull ServerInfoModel from) {
        ServerInfoBean res = new ServerInfoBean();
        res.mId = from.getId();
        res.mServerAddress = from.getServerAddress();
        res.mUsername = from.getUsername();
        res.mUuid = from.getUuid();
        res.mPasswordHash = from.getPasswordHash();
        res.mToken = from.getToken();
        res.mFileName = from.getFileName();
        res.mCurrentVersion = from.getCurrentVersion();
        res.mLatestVersion = from.getLatestVersion();
        return res;
    }

    public static class Builder {
        private ServerInfoBean mRes = new ServerInfoBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        /**
         * Set the {@code server_address} value.
         * Can be {@code null}.
         */
        public Builder serverAddress(@Nullable String serverAddress) {
            mRes.mServerAddress = serverAddress;
            return this;
        }

        /**
         * Set the {@code username} value.
         * Can be {@code null}.
         */
        public Builder username(@Nullable String username) {
            mRes.mUsername = username;
            return this;
        }

        /**
         * Set the {@code uuid} value.
         * Can be {@code null}.
         */
        public Builder uuid(@Nullable String uuid) {
            mRes.mUuid = uuid;
            return this;
        }

        /**
         * Set the {@code password_hash} value.
         * Can be {@code null}.
         */
        public Builder passwordHash(@Nullable String passwordHash) {
            mRes.mPasswordHash = passwordHash;
            return this;
        }

        /**
         * Set the {@code token} value.
         * Can be {@code null}.
         */
        public Builder token(@Nullable String token) {
            mRes.mToken = token;
            return this;
        }

        /**
         * Set the {@code file_name} value.
         * Can be {@code null}.
         */
        public Builder fileName(@Nullable String fileName) {
            mRes.mFileName = fileName;
            return this;
        }

        /**
         * Set the {@code current_version} value.
         * Can be {@code null}.
         */
        public Builder currentVersion(@Nullable String currentVersion) {
            mRes.mCurrentVersion = currentVersion;
            return this;
        }

        /**
         * Set the {@code latest_version} value.
         * Can be {@code null}.
         */
        public Builder latestVersion(@Nullable String latestVersion) {
            mRes.mLatestVersion = latestVersion;
            return this;
        }

        /**
         * Get a new ServerInfoBean built with the given values.
         */
        public ServerInfoBean build() {
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
