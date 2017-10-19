package org.md2k.mcerebrum.core.access.configinfo;

// @formatter:off
import org.md2k.mcerebrum.core.access.base.BaseModel;

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
    private String mDownloadFrom;
    private String mDownloadLink;

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
     * NOTIFY, AUTO, MANUAL
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getUpdates() {
        return mUpdates;
    }

    /**
     * NOTIFY, AUTO, MANUAL
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
     * server, url
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDownloadFrom() {
        return mDownloadFrom;
    }

    /**
     * server, url
     * Can be {@code null}.
     */
    public void setDownloadFrom(@Nullable String downloadFrom) {
        mDownloadFrom = downloadFrom;
    }

    /**
     * .json, .zip
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDownloadLink() {
        return mDownloadLink;
    }

    /**
     * .json, .zip
     * Can be {@code null}.
     */
    public void setDownloadLink(@Nullable String downloadLink) {
        mDownloadLink = downloadLink;
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
    public static ConfigInfoBean newInstance(long id, @Nullable String cid, @Nullable String type, @Nullable String title, @Nullable String summary, @Nullable String description, @Nullable String versions, @Nullable String updates, @Nullable String expectedVersion, @Nullable String latestVersion, @Nullable String downloadFrom, @Nullable String downloadLink) {
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
        res.mDownloadFrom = downloadFrom;
        res.mDownloadLink = downloadLink;
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
        res.mDownloadFrom = from.getDownloadFrom();
        res.mDownloadLink = from.getDownloadLink();
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
         * NOTIFY, AUTO, MANUAL
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
         * server, url
         * Can be {@code null}.
         */
        public Builder downloadFrom(@Nullable String downloadFrom) {
            mRes.mDownloadFrom = downloadFrom;
            return this;
        }

        /**
         * .json, .zip
         * Can be {@code null}.
         */
        public Builder downloadLink(@Nullable String downloadLink) {
            mRes.mDownloadLink = downloadLink;
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
