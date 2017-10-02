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

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Application Information
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class AppInfoBean implements AppInfoModel {
    private long mId;
    private String mAid;
    private String mType;
    private String mTitle;
    private String mSummary;
    private String mDescription;
    private String mPackageName;
    private String mDownloadLink;
    private String mUpdates;
    private String mUseAs;
    private String mExpectedVersion;
    private String mIcon;
    private String mCurrentVersion;
    private String mLatestVersion;
    private Boolean mInstalled;
    private Boolean mMcerebrumSupported;
    private Boolean mInitialized;

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
     * Get the {@code aid} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getAid() {
        return mAid;
    }

    /**
     * Set the {@code aid} value.
     * Can be {@code null}.
     */
    public void setAid(@Nullable String aid) {
        mAid = aid;
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
     * Get the {@code package_name} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPackageName() {
        return mPackageName;
    }

    /**
     * Set the {@code package_name} value.
     * Can be {@code null}.
     */
    public void setPackageName(@Nullable String packageName) {
        mPackageName = packageName;
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
     * not in use, required, optional
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getUseAs() {
        return mUseAs;
    }

    /**
     * not in use, required, optional
     * Can be {@code null}.
     */
    public void setUseAs(@Nullable String useAs) {
        mUseAs = useAs;
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
     * Get the {@code icon} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getIcon() {
        return mIcon;
    }

    /**
     * Set the {@code icon} value.
     * Can be {@code null}.
     */
    public void setIcon(@Nullable String icon) {
        mIcon = icon;
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

    /**
     * Get the {@code installed} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getInstalled() {
        return mInstalled;
    }

    /**
     * Set the {@code installed} value.
     * Can be {@code null}.
     */
    public void setInstalled(@Nullable Boolean installed) {
        mInstalled = installed;
    }

    /**
     * Get the {@code mcerebrum_supported} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getMcerebrumSupported() {
        return mMcerebrumSupported;
    }

    /**
     * Set the {@code mcerebrum_supported} value.
     * Can be {@code null}.
     */
    public void setMcerebrumSupported(@Nullable Boolean mcerebrumSupported) {
        mMcerebrumSupported = mcerebrumSupported;
    }

    /**
     * Get the {@code initialized} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getInitialized() {
        return mInitialized;
    }

    /**
     * Set the {@code initialized} value.
     * Can be {@code null}.
     */
    public void setInitialized(@Nullable Boolean initialized) {
        mInitialized = initialized;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppInfoBean bean = (AppInfoBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    /**
     * Instantiate a new AppInfoBean with specified values.
     */
    @NonNull
    public static AppInfoBean newInstance(long id, @Nullable String aid, @Nullable String type, @Nullable String title, @Nullable String summary, @Nullable String description, @Nullable String packageName, @Nullable String downloadLink, @Nullable String updates, @Nullable String useAs, @Nullable String expectedVersion, @Nullable String icon, @Nullable String currentVersion, @Nullable String latestVersion, @Nullable Boolean installed, @Nullable Boolean mcerebrumSupported, @Nullable Boolean initialized) {
        AppInfoBean res = new AppInfoBean();
        res.mId = id;
        res.mAid = aid;
        res.mType = type;
        res.mTitle = title;
        res.mSummary = summary;
        res.mDescription = description;
        res.mPackageName = packageName;
        res.mDownloadLink = downloadLink;
        res.mUpdates = updates;
        res.mUseAs = useAs;
        res.mExpectedVersion = expectedVersion;
        res.mIcon = icon;
        res.mCurrentVersion = currentVersion;
        res.mLatestVersion = latestVersion;
        res.mInstalled = installed;
        res.mMcerebrumSupported = mcerebrumSupported;
        res.mInitialized = initialized;
        return res;
    }

    /**
     * Instantiate a new AppInfoBean with all the values copied from the given model.
     */
    @NonNull
    public static AppInfoBean copy(@NonNull AppInfoModel from) {
        AppInfoBean res = new AppInfoBean();
        res.mId = from.getId();
        res.mAid = from.getAid();
        res.mType = from.getType();
        res.mTitle = from.getTitle();
        res.mSummary = from.getSummary();
        res.mDescription = from.getDescription();
        res.mPackageName = from.getPackageName();
        res.mDownloadLink = from.getDownloadLink();
        res.mUpdates = from.getUpdates();
        res.mUseAs = from.getUseAs();
        res.mExpectedVersion = from.getExpectedVersion();
        res.mIcon = from.getIcon();
        res.mCurrentVersion = from.getCurrentVersion();
        res.mLatestVersion = from.getLatestVersion();
        res.mInstalled = from.getInstalled();
        res.mMcerebrumSupported = from.getMcerebrumSupported();
        res.mInitialized = from.getInitialized();
        return res;
    }

    public static class Builder {
        private AppInfoBean mRes = new AppInfoBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        /**
         * Set the {@code aid} value.
         * Can be {@code null}.
         */
        public Builder aid(@Nullable String aid) {
            mRes.mAid = aid;
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
         * Set the {@code package_name} value.
         * Can be {@code null}.
         */
        public Builder packageName(@Nullable String packageName) {
            mRes.mPackageName = packageName;
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
         * Set the {@code updates} value.
         * Can be {@code null}.
         */
        public Builder updates(@Nullable String updates) {
            mRes.mUpdates = updates;
            return this;
        }

        /**
         * not in use, required, optional
         * Can be {@code null}.
         */
        public Builder useAs(@Nullable String useAs) {
            mRes.mUseAs = useAs;
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
         * Set the {@code icon} value.
         * Can be {@code null}.
         */
        public Builder icon(@Nullable String icon) {
            mRes.mIcon = icon;
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
         * Set the {@code installed} value.
         * Can be {@code null}.
         */
        public Builder installed(@Nullable Boolean installed) {
            mRes.mInstalled = installed;
            return this;
        }

        /**
         * Set the {@code mcerebrum_supported} value.
         * Can be {@code null}.
         */
        public Builder mcerebrumSupported(@Nullable Boolean mcerebrumSupported) {
            mRes.mMcerebrumSupported = mcerebrumSupported;
            return this;
        }

        /**
         * Set the {@code initialized} value.
         * Can be {@code null}.
         */
        public Builder initialized(@Nullable Boolean initialized) {
            mRes.mInitialized = initialized;
            return this;
        }

        /**
         * Get a new AppInfoBean built with the given values.
         */
        public AppInfoBean build() {
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
