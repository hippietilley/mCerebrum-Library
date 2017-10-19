package org.md2k.mcerebrum.core.access.studyinfo;

// @formatter:off
import org.md2k.mcerebrum.core.access.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Study Information
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class StudyInfoBean implements StudyInfoModel {
    private long mId;
    private String mSid;
    private String mType;
    private String mTitle;
    private String mSummary;
    private String mDescription;
    private String mVersion;
    private String mIcon;
    private String mCoverImage;
    private Boolean mStartAtBoot;
    private Boolean mStarted;

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
     * Get the {@code sid} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getSid() {
        return mSid;
    }

    /**
     * Set the {@code sid} value.
     * Can be {@code null}.
     */
    public void setSid(@Nullable String sid) {
        mSid = sid;
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
     * Get the {@code version} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getVersion() {
        return mVersion;
    }

    /**
     * Set the {@code version} value.
     * Can be {@code null}.
     */
    public void setVersion(@Nullable String version) {
        mVersion = version;
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
     * Get the {@code cover_image} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getCoverImage() {
        return mCoverImage;
    }

    /**
     * Set the {@code cover_image} value.
     * Can be {@code null}.
     */
    public void setCoverImage(@Nullable String coverImage) {
        mCoverImage = coverImage;
    }

    /**
     * Get the {@code start_at_boot} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getStartAtBoot() {
        return mStartAtBoot;
    }

    /**
     * Set the {@code start_at_boot} value.
     * Can be {@code null}.
     */
    public void setStartAtBoot(@Nullable Boolean startAtBoot) {
        mStartAtBoot = startAtBoot;
    }

    /**
     * Get the {@code started} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getStarted() {
        return mStarted;
    }

    /**
     * Set the {@code started} value.
     * Can be {@code null}.
     */
    public void setStarted(@Nullable Boolean started) {
        mStarted = started;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudyInfoBean bean = (StudyInfoBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    /**
     * Instantiate a new StudyInfoBean with specified values.
     */
    @NonNull
    public static StudyInfoBean newInstance(long id, @Nullable String sid, @Nullable String type, @Nullable String title, @Nullable String summary, @Nullable String description, @Nullable String version, @Nullable String icon, @Nullable String coverImage, @Nullable Boolean startAtBoot, @Nullable Boolean started) {
        StudyInfoBean res = new StudyInfoBean();
        res.mId = id;
        res.mSid = sid;
        res.mType = type;
        res.mTitle = title;
        res.mSummary = summary;
        res.mDescription = description;
        res.mVersion = version;
        res.mIcon = icon;
        res.mCoverImage = coverImage;
        res.mStartAtBoot = startAtBoot;
        res.mStarted = started;
        return res;
    }

    /**
     * Instantiate a new StudyInfoBean with all the values copied from the given model.
     */
    @NonNull
    public static StudyInfoBean copy(@NonNull StudyInfoModel from) {
        StudyInfoBean res = new StudyInfoBean();
        res.mId = from.getId();
        res.mSid = from.getSid();
        res.mType = from.getType();
        res.mTitle = from.getTitle();
        res.mSummary = from.getSummary();
        res.mDescription = from.getDescription();
        res.mVersion = from.getVersion();
        res.mIcon = from.getIcon();
        res.mCoverImage = from.getCoverImage();
        res.mStartAtBoot = from.getStartAtBoot();
        res.mStarted = from.getStarted();
        return res;
    }

    public static class Builder {
        private StudyInfoBean mRes = new StudyInfoBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        /**
         * Set the {@code sid} value.
         * Can be {@code null}.
         */
        public Builder sid(@Nullable String sid) {
            mRes.mSid = sid;
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
         * Set the {@code version} value.
         * Can be {@code null}.
         */
        public Builder version(@Nullable String version) {
            mRes.mVersion = version;
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
         * Set the {@code cover_image} value.
         * Can be {@code null}.
         */
        public Builder coverImage(@Nullable String coverImage) {
            mRes.mCoverImage = coverImage;
            return this;
        }

        /**
         * Set the {@code start_at_boot} value.
         * Can be {@code null}.
         */
        public Builder startAtBoot(@Nullable Boolean startAtBoot) {
            mRes.mStartAtBoot = startAtBoot;
            return this;
        }

        /**
         * Set the {@code started} value.
         * Can be {@code null}.
         */
        public Builder started(@Nullable Boolean started) {
            mRes.mStarted = started;
            return this;
        }

        /**
         * Get a new StudyInfoBean built with the given values.
         */
        public StudyInfoBean build() {
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
