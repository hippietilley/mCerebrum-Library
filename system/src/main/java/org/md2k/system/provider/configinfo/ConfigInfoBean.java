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
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class ConfigInfoBean implements ConfigInfoModel {
    private long mId;
    private String mCid;
    private String mType;
    private String mTitle;
    private String mSummary;
    private String mDescription;
    private String mVersions;
    private String mUpdates;
    private String mExpectedVersion;
    private String mLatestVersion;
    private String mDownloadLink;
    private String mLastUpdated;
    private String mFileName;

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
     * Get the {@code cid} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getCid() {
        return mCid;
    }

    /**
     * Set the {@code cid} value.
     * Can be {@code null}.
     */
    public void setCid(@Nullable String cid) {
        mCid = cid;
    }

    /**
     * Get the {@code type} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getType() {
        return mType;
    }

    /**
     * Set the {@code type} value.
     * Can be {@code null}.
     */
    public void setType(@Nullable String type) {
        mType = type;
    }

    /**
     * Get the {@code title} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTitle() {
        return mTitle;
    }

    /**
     * Set the {@code title} value.
     * Can be {@code null}.
     */
    public void setTitle(@Nullable String title) {
        mTitle = title;
    }

    /**
     * Get the {@code summary} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getSummary() {
        return mSummary;
    }

    /**
     * Set the {@code summary} value.
     * Can be {@code null}.
     */
    public void setSummary(@Nullable String summary) {
        mSummary = summary;
    }

    /**
     * Get the {@code description} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDescription() {
        return mDescription;
    }

    /**
     * Set the {@code description} value.
     * Can be {@code null}.
     */
    public void setDescription(@Nullable String description) {
        mDescription = description;
    }

    /**
     * Get the {@code versions} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getVersions() {
        return mVersions;
    }

    /**
     * Set the {@code versions} value.
     * Can be {@code null}.
     */
    public void setVersions(@Nullable String versions) {
        mVersions = versions;
    }

    /**
     * Get the {@code updates} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getUpdates() {
        return mUpdates;
    }

    /**
     * Set the {@code updates} value.
     * Can be {@code null}.
     */
    public void setUpdates(@Nullable String updates) {
        mUpdates = updates;
    }

    /**
     * Get the {@code expected_version} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getExpectedVersion() {
        return mExpectedVersion;
    }

    /**
     * Set the {@code expected_version} value.
     * Can be {@code null}.
     */
    public void setExpectedVersion(@Nullable String expectedVersion) {
        mExpectedVersion = expectedVersion;
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

    /**
     * Get the {@code download_link} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDownloadLink() {
        return mDownloadLink;
    }

    /**
     * Set the {@code download_link} value.
     * Can be {@code null}.
     */
    public void setDownloadLink(@Nullable String downloadLink) {
        mDownloadLink = downloadLink;
    }

    /**
     * Get the {@code last_updated} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getLastUpdated() {
        return mLastUpdated;
    }

    /**
     * Set the {@code last_updated} value.
     * Can be {@code null}.
     */
    public void setLastUpdated(@Nullable String lastUpdated) {
        mLastUpdated = lastUpdated;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigInfoBean bean = (ConfigInfoBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    /**
     * Instantiate a new ConfigInfoBean with specified values.
     */
    @NonNull
    public static ConfigInfoBean newInstance(long id, @Nullable String cid, @Nullable String type, @Nullable String title, @Nullable String summary, @Nullable String description, @Nullable String versions, @Nullable String updates, @Nullable String expectedVersion, @Nullable String latestVersion, @Nullable String downloadLink, @Nullable String lastUpdated, @Nullable String fileName) {
        ConfigInfoBean res = new ConfigInfoBean();
        res.mId = id;
        res.mCid = cid;
        res.mType = type;
        res.mTitle = title;
        res.mSummary = summary;
        res.mDescription = description;
        res.mVersions = versions;
        res.mUpdates = updates;
        res.mExpectedVersion = expectedVersion;
        res.mLatestVersion = latestVersion;
        res.mDownloadLink = downloadLink;
        res.mLastUpdated = lastUpdated;
        res.mFileName = fileName;
        return res;
    }

    /**
     * Instantiate a new ConfigInfoBean with all the values copied from the given model.
     */
    @NonNull
    public static ConfigInfoBean copy(@NonNull ConfigInfoModel from) {
        ConfigInfoBean res = new ConfigInfoBean();
        res.mId = from.getId();
        res.mCid = from.getCid();
        res.mType = from.getType();
        res.mTitle = from.getTitle();
        res.mSummary = from.getSummary();
        res.mDescription = from.getDescription();
        res.mVersions = from.getVersions();
        res.mUpdates = from.getUpdates();
        res.mExpectedVersion = from.getExpectedVersion();
        res.mLatestVersion = from.getLatestVersion();
        res.mDownloadLink = from.getDownloadLink();
        res.mLastUpdated = from.getLastUpdated();
        res.mFileName = from.getFileName();
        return res;
    }

    public static class Builder {
        private ConfigInfoBean mRes = new ConfigInfoBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        /**
         * Set the {@code cid} value.
         * Can be {@code null}.
         */
        public Builder cid(@Nullable String cid) {
            mRes.mCid = cid;
            return this;
        }

        /**
         * Set the {@code type} value.
         * Can be {@code null}.
         */
        public Builder type(@Nullable String type) {
            mRes.mType = type;
            return this;
        }

        /**
         * Set the {@code title} value.
         * Can be {@code null}.
         */
        public Builder title(@Nullable String title) {
            mRes.mTitle = title;
            return this;
        }

        /**
         * Set the {@code summary} value.
         * Can be {@code null}.
         */
        public Builder summary(@Nullable String summary) {
            mRes.mSummary = summary;
            return this;
        }

        /**
         * Set the {@code description} value.
         * Can be {@code null}.
         */
        public Builder description(@Nullable String description) {
            mRes.mDescription = description;
            return this;
        }

        /**
         * Set the {@code versions} value.
         * Can be {@code null}.
         */
        public Builder versions(@Nullable String versions) {
            mRes.mVersions = versions;
            return this;
        }

        /**
         * Set the {@code updates} value.
         * Can be {@code null}.
         */
        public Builder updates(@Nullable String updates) {
            mRes.mUpdates = updates;
            return this;
        }

        /**
         * Set the {@code expected_version} value.
         * Can be {@code null}.
         */
        public Builder expectedVersion(@Nullable String expectedVersion) {
            mRes.mExpectedVersion = expectedVersion;
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
         * Set the {@code download_link} value.
         * Can be {@code null}.
         */
        public Builder downloadLink(@Nullable String downloadLink) {
            mRes.mDownloadLink = downloadLink;
            return this;
        }

        /**
         * Set the {@code last_updated} value.
         * Can be {@code null}.
         */
        public Builder lastUpdated(@Nullable String lastUpdated) {
            mRes.mLastUpdated = lastUpdated;
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
         * Get a new ConfigInfoBean built with the given values.
         */
        public ConfigInfoBean build() {
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
