/*
 * Copyright (c) 2018, The University of Memphis, MD2K Center of Excellence
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.md2k.mcerebrum.core.access.userinfo;

import org.md2k.mcerebrum.core.access.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Creates user information beans
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class UserInfoBean implements UserInfoModel {
    private long mId;
    private String mUid;
    private String mType;
    private String mUsername;

    /**
     * Returns the identifier (Primary key).
     * @return The identifier (Primary key).
     */
    @Override
    public long getId() {
        return mId;
    }

    /**
     * Sets the identifier (Primary key).
     * @param id The identifier (Primary key).
     */
    public void setId(long id) {
        mId = id;
    }

    /**
     * Returns the UID.
     * @return The UID.
     */
    @Nullable
    @Override
    public String getUid() {
        return mUid;
    }

    /**
     * Sets the UID.
     * @param uid The UID.
     */
    public void setUid(@Nullable String uid) {
        mUid = uid;
    }

    /**
     * Returns the user info type.
     * @return The user info type.
     */
    @Nullable
    @Override
    public String getType() {
        return mType;
    }

    /**
     * Sets the user info type.
     * @param type The user info type.
     */
    public void setType(@Nullable String type) {
        mType = type;
    }

    /**
     * Returns the username.
     * @return The username.
     */
    @Nullable
    @Override
    public String getUsername() {
        return mUsername;
    }

    /**
     * Sets the username.
     * @param username The username.
     */
    public void setUsername(@Nullable String username) {
        mUsername = username;
    }

    /**
     * Determines if the calling object is the same as the callee.
     * @param o Callee
     * @return Whether the objects are the same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserInfoBean bean = (UserInfoBean) o;
        return mId == bean.mId;
    }

    /**
     * Hashes the user identifier.
     * @return The hashed user identifier.
     */
    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    /**
     * Instantiate a new <code>UserInfoBean</code> with specified values.
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
     * Instantiate a new <code>UserInfoBean</code> with all the values copied from the given model.
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

    /**
     * Nested Builder class
     */
    public static class Builder {
        /**
         * Creates a new blank <code>UserInfoBean</code>.
         */
        private UserInfoBean mRes = new UserInfoBean();

        /**
         * Sets the identifier (Primary key).
         * @param id The identifier (Primary key).
         * @return The modified builder.
         */
        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        /**
         * Sets the user id.
         * @param uid The user id (can be null).
         * @return The modified builder.
         */

        public Builder uid(@Nullable String uid) {
            mRes.mUid = uid;
            return this;
        }

        /**
         * Sets the user type.
         * @param type The user type (can be null).
         * @return The modified builder.
         */
        public Builder type(@Nullable String type) {
            mRes.mType = type;
            return this;
        }

        /**
         * Sets the username.
         * @param username The username (can be null).
         * @return The modified builder.
         */
        public Builder username(@Nullable String username) {
            mRes.mUsername = username;
            return this;
        }

        /**
         * Builds a <code>UserInfoBean</code> with the desired configuration.
         * @return
         */
        public UserInfoBean build() {
            return mRes;
        }
    }

    /**
     * Returns a new Builder.
     * @return A new Builder.
     */
    public static Builder newBuilder() {
        return new Builder();
    }
}
