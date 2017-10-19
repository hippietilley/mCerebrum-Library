package org.md2k.mcerebrum.core.access.appinfo;

// @formatter:off
import org.md2k.mcerebrum.core.access.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Application Information
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
class AppInfoBean implements AppInfoModel {
    private long mId;
    private String mPackageName;
    private String mType;
    private String mTitle;
    private String mSummary;
    private String mDescription;
    private Boolean mUseInStudy;
    private String mUseAs;
    private Boolean mInstalled;
    private String mDownloadLink;
    private String mUpdates;
    private String mCurrentVersion;
    private String mLatestVersion;
    private String mExpectedVersion;
    private String mIcon;
    private Boolean mMcerebrumSupported;
    private String mFuncInitialize;
    private Boolean mInitialized;
    private String mFuncUpdateInfo;
    private String mFuncConfigure;
    private Boolean mConfigured;
    private Boolean mConfigureMatch;
    private String mFuncPermission;
    private Boolean mPermissionOk;
    private String mFuncBackground;
    private Boolean mBackgroundRunningTime;
    private Boolean mIsBackgroundRunning;
    private String mFuncReport;
    private String mFuncClear;
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
     * MCEREBRUM, STUDY, DATAKIT,any other string
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getType() {
        return mType;
    }

    /**
     * MCEREBRUM, STUDY, DATAKIT,any other string
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
     * Get the {@code use_in_study} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getUseInStudy() {
        return mUseInStudy;
    }

    /**
     * Set the {@code use_in_study} value.
     * Can be {@code null}.
     */
    public void setUseInStudy(@Nullable Boolean useInStudy) {
        mUseInStudy = useInStudy;
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
     * Get the {@code func_initialize} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getFuncInitialize() {
        return mFuncInitialize;
    }

    /**
     * Set the {@code func_initialize} value.
     * Can be {@code null}.
     */
    public void setFuncInitialize(@Nullable String funcInitialize) {
        mFuncInitialize = funcInitialize;
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
     * Get the {@code func_update_info} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getFuncUpdateInfo() {
        return mFuncUpdateInfo;
    }

    /**
     * Set the {@code func_update_info} value.
     * Can be {@code null}.
     */
    public void setFuncUpdateInfo(@Nullable String funcUpdateInfo) {
        mFuncUpdateInfo = funcUpdateInfo;
    }

    /**
     * Get the {@code func_configure} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getFuncConfigure() {
        return mFuncConfigure;
    }

    /**
     * Set the {@code func_configure} value.
     * Can be {@code null}.
     */
    public void setFuncConfigure(@Nullable String funcConfigure) {
        mFuncConfigure = funcConfigure;
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
     * Get the {@code func_permission} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getFuncPermission() {
        return mFuncPermission;
    }

    /**
     * Set the {@code func_permission} value.
     * Can be {@code null}.
     */
    public void setFuncPermission(@Nullable String funcPermission) {
        mFuncPermission = funcPermission;
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
     * Get the {@code func_background} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getFuncBackground() {
        return mFuncBackground;
    }

    /**
     * Set the {@code func_background} value.
     * Can be {@code null}.
     */
    public void setFuncBackground(@Nullable String funcBackground) {
        mFuncBackground = funcBackground;
    }

    /**
     * Get the {@code background_running_time} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getBackgroundRunningTime() {
        return mBackgroundRunningTime;
    }

    /**
     * Set the {@code background_running_time} value.
     * Can be {@code null}.
     */
    public void setBackgroundRunningTime(@Nullable Boolean backgroundRunningTime) {
        mBackgroundRunningTime = backgroundRunningTime;
    }

    /**
     * Get the {@code is_background_running} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getIsBackgroundRunning() {
        return mIsBackgroundRunning;
    }

    /**
     * Set the {@code is_background_running} value.
     * Can be {@code null}.
     */
    public void setIsBackgroundRunning(@Nullable Boolean isBackgroundRunning) {
        mIsBackgroundRunning = isBackgroundRunning;
    }

    /**
     * Get the {@code func_report} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getFuncReport() {
        return mFuncReport;
    }

    /**
     * Set the {@code func_report} value.
     * Can be {@code null}.
     */
    public void setFuncReport(@Nullable String funcReport) {
        mFuncReport = funcReport;
    }

    /**
     * Get the {@code func_clear} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getFuncClear() {
        return mFuncClear;
    }

    /**
     * Set the {@code func_clear} value.
     * Can be {@code null}.
     */
    public void setFuncClear(@Nullable String funcClear) {
        mFuncClear = funcClear;
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
    public static AppInfoBean newInstance(long id, @Nullable String packageName, @Nullable String type, @Nullable String title, @Nullable String summary, @Nullable String description, @Nullable Boolean useInStudy, @Nullable String useAs, @Nullable Boolean installed, @Nullable String downloadLink, @Nullable String updates, @Nullable String currentVersion, @Nullable String latestVersion, @Nullable String expectedVersion, @Nullable String icon, @Nullable Boolean mcerebrumSupported, @Nullable String funcInitialize, @Nullable Boolean initialized, @Nullable String funcUpdateInfo, @Nullable String funcConfigure, @Nullable Boolean configured, @Nullable Boolean configureMatch, @Nullable String funcPermission, @Nullable Boolean permissionOk, @Nullable String funcBackground, @Nullable Boolean backgroundRunningTime, @Nullable Boolean isBackgroundRunning, @Nullable String funcReport, @Nullable String funcClear, @Nullable Boolean datakitConnected) {
        AppInfoBean res = new AppInfoBean();
        res.mId = id;
        res.mPackageName = packageName;
        res.mType = type;
        res.mTitle = title;
        res.mSummary = summary;
        res.mDescription = description;
        res.mUseInStudy = useInStudy;
        res.mUseAs = useAs;
        res.mInstalled = installed;
        res.mDownloadLink = downloadLink;
        res.mUpdates = updates;
        res.mCurrentVersion = currentVersion;
        res.mLatestVersion = latestVersion;
        res.mExpectedVersion = expectedVersion;
        res.mIcon = icon;
        res.mMcerebrumSupported = mcerebrumSupported;
        res.mFuncInitialize = funcInitialize;
        res.mInitialized = initialized;
        res.mFuncUpdateInfo = funcUpdateInfo;
        res.mFuncConfigure = funcConfigure;
        res.mConfigured = configured;
        res.mConfigureMatch = configureMatch;
        res.mFuncPermission = funcPermission;
        res.mPermissionOk = permissionOk;
        res.mFuncBackground = funcBackground;
        res.mBackgroundRunningTime = backgroundRunningTime;
        res.mIsBackgroundRunning = isBackgroundRunning;
        res.mFuncReport = funcReport;
        res.mFuncClear = funcClear;
        res.mDatakitConnected = datakitConnected;
        return res;
    }

    /**
     * Instantiate a new AppInfoBean with all the values copied from the given model.
     */
    @NonNull
    public static AppInfoBean copy(@NonNull AppInfoModel from) {
        AppInfoBean res = new AppInfoBean();
        res.mId = from.getId();
        res.mPackageName = from.getPackageName();
        res.mType = from.getType();
        res.mTitle = from.getTitle();
        res.mSummary = from.getSummary();
        res.mDescription = from.getDescription();
        res.mUseInStudy = from.getUseInStudy();
        res.mUseAs = from.getUseAs();
        res.mInstalled = from.getInstalled();
        res.mDownloadLink = from.getDownloadLink();
        res.mUpdates = from.getUpdates();
        res.mCurrentVersion = from.getCurrentVersion();
        res.mLatestVersion = from.getLatestVersion();
        res.mExpectedVersion = from.getExpectedVersion();
        res.mIcon = from.getIcon();
        res.mMcerebrumSupported = from.getMcerebrumSupported();
        res.mFuncInitialize = from.getFuncInitialize();
        res.mInitialized = from.getInitialized();
        res.mFuncUpdateInfo = from.getFuncUpdateInfo();
        res.mFuncConfigure = from.getFuncConfigure();
        res.mConfigured = from.getConfigured();
        res.mConfigureMatch = from.getConfigureMatch();
        res.mFuncPermission = from.getFuncPermission();
        res.mPermissionOk = from.getPermissionOk();
        res.mFuncBackground = from.getFuncBackground();
        res.mBackgroundRunningTime = from.getBackgroundRunningTime();
        res.mIsBackgroundRunning = from.getIsBackgroundRunning();
        res.mFuncReport = from.getFuncReport();
        res.mFuncClear = from.getFuncClear();
        res.mDatakitConnected = from.getDatakitConnected();
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
         * Set the {@code package_name} value.
         * Can be {@code null}.
         */
        public Builder packageName(@Nullable String packageName) {
            mRes.mPackageName = packageName;
            return this;
        }

        /**
         * MCEREBRUM, STUDY, DATAKIT,any other string
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
         * Set the {@code use_in_study} value.
         * Can be {@code null}.
         */
        public Builder useInStudy(@Nullable Boolean useInStudy) {
            mRes.mUseInStudy = useInStudy;
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
         * Set the {@code installed} value.
         * Can be {@code null}.
         */
        public Builder installed(@Nullable Boolean installed) {
            mRes.mInstalled = installed;
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
         * NOTIFY, AUTO, MANUAL
         * Can be {@code null}.
         */
        public Builder updates(@Nullable String updates) {
            mRes.mUpdates = updates;
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
         * Set the {@code mcerebrum_supported} value.
         * Can be {@code null}.
         */
        public Builder mcerebrumSupported(@Nullable Boolean mcerebrumSupported) {
            mRes.mMcerebrumSupported = mcerebrumSupported;
            return this;
        }

        /**
         * Set the {@code func_initialize} value.
         * Can be {@code null}.
         */
        public Builder funcInitialize(@Nullable String funcInitialize) {
            mRes.mFuncInitialize = funcInitialize;
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
         * Set the {@code func_update_info} value.
         * Can be {@code null}.
         */
        public Builder funcUpdateInfo(@Nullable String funcUpdateInfo) {
            mRes.mFuncUpdateInfo = funcUpdateInfo;
            return this;
        }

        /**
         * Set the {@code func_configure} value.
         * Can be {@code null}.
         */
        public Builder funcConfigure(@Nullable String funcConfigure) {
            mRes.mFuncConfigure = funcConfigure;
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
         * Set the {@code func_permission} value.
         * Can be {@code null}.
         */
        public Builder funcPermission(@Nullable String funcPermission) {
            mRes.mFuncPermission = funcPermission;
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
         * Set the {@code func_background} value.
         * Can be {@code null}.
         */
        public Builder funcBackground(@Nullable String funcBackground) {
            mRes.mFuncBackground = funcBackground;
            return this;
        }

        /**
         * Set the {@code background_running_time} value.
         * Can be {@code null}.
         */
        public Builder backgroundRunningTime(@Nullable Boolean backgroundRunningTime) {
            mRes.mBackgroundRunningTime = backgroundRunningTime;
            return this;
        }

        /**
         * Set the {@code is_background_running} value.
         * Can be {@code null}.
         */
        public Builder isBackgroundRunning(@Nullable Boolean isBackgroundRunning) {
            mRes.mIsBackgroundRunning = isBackgroundRunning;
            return this;
        }

        /**
         * Set the {@code func_report} value.
         * Can be {@code null}.
         */
        public Builder funcReport(@Nullable String funcReport) {
            mRes.mFuncReport = funcReport;
            return this;
        }

        /**
         * Set the {@code func_clear} value.
         * Can be {@code null}.
         */
        public Builder funcClear(@Nullable String funcClear) {
            mRes.mFuncClear = funcClear;
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
