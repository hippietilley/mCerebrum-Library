package org.md2k.mcerebrum.core.access.userinfo;

// @formatter:off
import org.md2k.mcerebrum.core.access.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * User information
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class UserInfoBean implements UserInfoModel {
    private long mId;
    private String mUid;
    private String mType;
    private String mUsername;

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
     * Get the {@code uid} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getUid() {
        return mUid;
    }

    /**
     * Set the {@code uid} value.
     * Can be {@code null}.
     */
    public void setUid(@Nullable String uid) {
        mUid = uid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfoBean bean = (UserInfoBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    /**
     * Instantiate a new UserInfoBean with specified values.
     */
    @NonNull
    public static UserInfoBean newInstance(long id, @Nullable String uid, @Nullable String type, @Nullable String username) {
        UserInfoBean res = new UserInfoBean();
        res.mId = id;
        res.mUid = uid;
        res.mType = type;
        res.mUsername = username;
        return res;
    }

    /**
     * Instantiate a new UserInfoBean with all the values copied from the given model.
     */
    @NonNull
    public static UserInfoBean copy(@NonNull UserInfoModel from) {
        UserInfoBean res = new UserInfoBean();
        res.mId = from.getId();
        res.mUid = from.getUid();
        res.mType = from.getType();
        res.mUsername = from.getUsername();
        return res;
    }

    public static class Builder {
        private UserInfoBean mRes = new UserInfoBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        /**
         * Set the {@code uid} value.
         * Can be {@code null}.
         */
        public Builder uid(@Nullable String uid) {
            mRes.mUid = uid;
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
         * Set the {@code username} value.
         * Can be {@code null}.
         */
        public Builder username(@Nullable String username) {
            mRes.mUsername = username;
            return this;
        }

        /**
         * Get a new UserInfoBean built with the given values.
         */
        public UserInfoBean build() {
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
