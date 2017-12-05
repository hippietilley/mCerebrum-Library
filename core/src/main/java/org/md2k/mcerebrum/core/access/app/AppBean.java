package org.md2k.mycontentprovider.app;

// @formatter:off
import org.md2k.mycontentprovider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Application Information
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class AppBean implements AppModel {
    private long mId;
    private String mPackageName;
    private String mConfigure;
    private String mReport;
    private String mClear;
    private String mRunBackground;
    private String mPermission;
    private String mInitialize;
    private Boolean mInitialized;
    private Boolean mConfigured;
    private Boolean mConfigureMatch;
    private Boolean mRunningTime;
    private Boolean mIsRunningBackground;
    private Boolean mPermissionOk;
    private Boolean mDatakitConnected;

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
     * Get the {@code configure} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getConfigure() {
        return mConfigure;
    }

    /**
     * Set the {@code configure} value.
     * Can be {@code null}.
     */
    public void setConfigure(@Nullable String configure) {
        mConfigure = configure;
    }

    /**
     * Get the {@code report} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getReport() {
        return mReport;
    }

    /**
     * Set the {@code report} value.
     * Can be {@code null}.
     */
    public void setReport(@Nullable String report) {
        mReport = report;
    }

    /**
     * Get the {@code clear} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getClear() {
        return mClear;
    }

    /**
     * Set the {@code clear} value.
     * Can be {@code null}.
     */
    public void setClear(@Nullable String clear) {
        mClear = clear;
    }

    /**
     * Get the {@code run_background} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getRunBackground() {
        return mRunBackground;
    }

    /**
     * Set the {@code run_background} value.
     * Can be {@code null}.
     */
    public void setRunBackground(@Nullable String runBackground) {
        mRunBackground = runBackground;
    }

    /**
     * Get the {@code permission} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPermission() {
        return mPermission;
    }

    /**
     * Set the {@code permission} value.
     * Can be {@code null}.
     */
    public void setPermission(@Nullable String permission) {
        mPermission = permission;
    }

    /**
     * Get the {@code initialize} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getInitialize() {
        return mInitialize;
    }

    /**
     * Set the {@code initialize} value.
     * Can be {@code null}.
     */
    public void setInitialize(@Nullable String initialize) {
        mInitialize = initialize;
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

    /**
     * Get the {@code configured} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getConfigured() {
        return mConfigured;
    }

    /**
     * Set the {@code configured} value.
     * Can be {@code null}.
     */
    public void setConfigured(@Nullable Boolean configured) {
        mConfigured = configured;
    }

    /**
     * Get the {@code configure_match} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getConfigureMatch() {
        return mConfigureMatch;
    }

    /**
     * Set the {@code configure_match} value.
     * Can be {@code null}.
     */
    public void setConfigureMatch(@Nullable Boolean configureMatch) {
        mConfigureMatch = configureMatch;
    }

    /**
     * Get the {@code running_time} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getRunningTime() {
        return mRunningTime;
    }

    /**
     * Set the {@code running_time} value.
     * Can be {@code null}.
     */
    public void setRunningTime(@Nullable Boolean runningTime) {
        mRunningTime = runningTime;
    }

    /**
     * Get the {@code is_running_background} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getIsRunningBackground() {
        return mIsRunningBackground;
    }

    /**
     * Set the {@code is_running_background} value.
     * Can be {@code null}.
     */
    public void setIsRunningBackground(@Nullable Boolean isRunningBackground) {
        mIsRunningBackground = isRunningBackground;
    }

    /**
     * Get the {@code permission_ok} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getPermissionOk() {
        return mPermissionOk;
    }

    /**
     * Set the {@code permission_ok} value.
     * Can be {@code null}.
     */
    public void setPermissionOk(@Nullable Boolean permissionOk) {
        mPermissionOk = permissionOk;
    }

    /**
     * Get the {@code datakit_connected} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getDatakitConnected() {
        return mDatakitConnected;
    }

    /**
     * Set the {@code datakit_connected} value.
     * Can be {@code null}.
     */
    public void setDatakitConnected(@Nullable Boolean datakitConnected) {
        mDatakitConnected = datakitConnected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppBean bean = (AppBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    /**
     * Instantiate a new AppBean with specified values.
     */
    @NonNull
    public static AppBean newInstance(long id, @Nullable String packageName, @Nullable String configure, @Nullable String report, @Nullable String clear, @Nullable String runBackground, @Nullable String permission, @Nullable String initialize, @Nullable Boolean initialized, @Nullable Boolean configured, @Nullable Boolean configureMatch, @Nullable Boolean runningTime, @Nullable Boolean isRunningBackground, @Nullable Boolean permissionOk, @Nullable Boolean datakitConnected) {
        AppBean res = new AppBean();
        res.mId = id;
        res.mPackageName = packageName;
        res.mConfigure = configure;
        res.mReport = report;
        res.mClear = clear;
        res.mRunBackground = runBackground;
        res.mPermission = permission;
        res.mInitialize = initialize;
        res.mInitialized = initialized;
        res.mConfigured = configured;
        res.mConfigureMatch = configureMatch;
        res.mRunningTime = runningTime;
        res.mIsRunningBackground = isRunningBackground;
        res.mPermissionOk = permissionOk;
        res.mDatakitConnected = datakitConnected;
        return res;
    }

    /**
     * Instantiate a new AppBean with all the values copied from the given model.
     */
    @NonNull
    public static AppBean copy(@NonNull AppModel from) {
        AppBean res = new AppBean();
        res.mId = from.getId();
        res.mPackageName = from.getPackageName();
        res.mConfigure = from.getConfigure();
        res.mReport = from.getReport();
        res.mClear = from.getClear();
        res.mRunBackground = from.getRunBackground();
        res.mPermission = from.getPermission();
        res.mInitialize = from.getInitialize();
        res.mInitialized = from.getInitialized();
        res.mConfigured = from.getConfigured();
        res.mConfigureMatch = from.getConfigureMatch();
        res.mRunningTime = from.getRunningTime();
        res.mIsRunningBackground = from.getIsRunningBackground();
        res.mPermissionOk = from.getPermissionOk();
        res.mDatakitConnected = from.getDatakitConnected();
        return res;
    }

    public static class Builder {
        private AppBean mRes = new AppBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
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
         * Set the {@code configure} value.
         * Can be {@code null}.
         */
        public Builder configure(@Nullable String configure) {
            mRes.mConfigure = configure;
            return this;
        }

        /**
         * Set the {@code report} value.
         * Can be {@code null}.
         */
        public Builder report(@Nullable String report) {
            mRes.mReport = report;
            return this;
        }

        /**
         * Set the {@code clear} value.
         * Can be {@code null}.
         */
        public Builder clear(@Nullable String clear) {
            mRes.mClear = clear;
            return this;
        }

        /**
         * Set the {@code run_background} value.
         * Can be {@code null}.
         */
        public Builder runBackground(@Nullable String runBackground) {
            mRes.mRunBackground = runBackground;
            return this;
        }

        /**
         * Set the {@code permission} value.
         * Can be {@code null}.
         */
        public Builder permission(@Nullable String permission) {
            mRes.mPermission = permission;
            return this;
        }

        /**
         * Set the {@code initialize} value.
         * Can be {@code null}.
         */
        public Builder initialize(@Nullable String initialize) {
            mRes.mInitialize = initialize;
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
         * Set the {@code configured} value.
         * Can be {@code null}.
         */
        public Builder configured(@Nullable Boolean configured) {
            mRes.mConfigured = configured;
            return this;
        }

        /**
         * Set the {@code configure_match} value.
         * Can be {@code null}.
         */
        public Builder configureMatch(@Nullable Boolean configureMatch) {
            mRes.mConfigureMatch = configureMatch;
            return this;
        }

        /**
         * Set the {@code running_time} value.
         * Can be {@code null}.
         */
        public Builder runningTime(@Nullable Boolean runningTime) {
            mRes.mRunningTime = runningTime;
            return this;
        }

        /**
         * Set the {@code is_running_background} value.
         * Can be {@code null}.
         */
        public Builder isRunningBackground(@Nullable Boolean isRunningBackground) {
            mRes.mIsRunningBackground = isRunningBackground;
            return this;
        }

        /**
         * Set the {@code permission_ok} value.
         * Can be {@code null}.
         */
        public Builder permissionOk(@Nullable Boolean permissionOk) {
            mRes.mPermissionOk = permissionOk;
            return this;
        }

        /**
         * Set the {@code datakit_connected} value.
         * Can be {@code null}.
         */
        public Builder datakitConnected(@Nullable Boolean datakitConnected) {
            mRes.mDatakitConnected = datakitConnected;
            return this;
        }

        /**
         * Get a new AppBean built with the given values.
         */
        public AppBean build() {
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
