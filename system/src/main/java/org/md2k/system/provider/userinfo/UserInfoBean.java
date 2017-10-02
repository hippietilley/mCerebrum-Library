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
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class UserInfoBean implements UserInfoModel {
    private long mId;
    private String mUid;
    private String mType;
    private String mUsername;
    private Boolean mLoggedIn;
    private String mToken;
    private String mPasswordHash;

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

    /**
     * Get the {@code logged_in} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getLoggedIn() {
        return mLoggedIn;
    }

    /**
     * Set the {@code logged_in} value.
     * Can be {@code null}.
     */
    public void setLoggedIn(@Nullable Boolean loggedIn) {
        mLoggedIn = loggedIn;
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
    public static UserInfoBean newInstance(long id, @Nullable String uid, @Nullable String type, @Nullable String username, @Nullable Boolean loggedIn, @Nullable String token, @Nullable String passwordHash) {
        UserInfoBean res = new UserInfoBean();
        res.mId = id;
        res.mUid = uid;
        res.mType = type;
        res.mUsername = username;
        res.mLoggedIn = loggedIn;
        res.mToken = token;
        res.mPasswordHash = passwordHash;
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
        res.mLoggedIn = from.getLoggedIn();
        res.mToken = from.getToken();
        res.mPasswordHash = from.getPasswordHash();
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
         * Set the {@code logged_in} value.
         * Can be {@code null}.
         */
        public Builder loggedIn(@Nullable Boolean loggedIn) {
            mRes.mLoggedIn = loggedIn;
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
         * Set the {@code password_hash} value.
         * Can be {@code null}.
         */
        public Builder passwordHash(@Nullable String passwordHash) {
            mRes.mPasswordHash = passwordHash;
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
