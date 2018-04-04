package org.md2k.mcerebrum.core.access.appinfo;

import org.md2k.mcerebrum.core.access.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * App ContentProvider Bean class.
 * This class is auto-generated by Android ContentProvider Generator.
 * For more information see <a href="https://github.com/BoD/android-contentprovider-generator">GitHub</a>.
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

    @Override
    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    @Nullable
    @Override
    public String getPackageName() {
        return mPackageName;
    }

    public void setPackageName(@Nullable String packageName) {
        mPackageName = packageName;
    }

    @Nullable
    @Override
    public String getType() {
        return mType;
    }

    public void setType(@Nullable String type) {
        mType = type;
    }

    @Nullable
    @Override
    public String getTitle() {
        return mTitle;
    }

    public void setTitle(@Nullable String title) {
        mTitle = title;
    }

    @Nullable
    @Override
    public String getSummary() {
        return mSummary;
    }

    public void setSummary(@Nullable String summary) {
        mSummary = summary;
    }

    @Nullable
    @Override
    public String getDescription() {
        return mDescription;
    }

    public void setDescription(@Nullable String description) {
        mDescription = description;
    }

    @Nullable
    @Override
    public Boolean getUseInStudy() {
        return mUseInStudy;
    }

    public void setUseInStudy(@Nullable Boolean useInStudy) {
        mUseInStudy = useInStudy;
    }

    @Nullable
    @Override
    public String getUseAs() {
        return mUseAs;
    }

    public void setUseAs(@Nullable String useAs) {
        mUseAs = useAs;
    }

    @Nullable
    @Override
    public Boolean getInstalled() {
        return mInstalled;
    }

    public void setInstalled(@Nullable Boolean installed) {
        mInstalled = installed;
    }

    @Nullable
    @Override
    public String getDownloadLink() {
        return mDownloadLink;
    }

    public void setDownloadLink(@Nullable String downloadLink) {
        mDownloadLink = downloadLink;
    }

    @Nullable
    @Override
    public String getUpdates() {
        return mUpdates;
    }

    public void setUpdates(@Nullable String updates) {
        mUpdates = updates;
    }

    @Nullable
    @Override
    public String getCurrentVersion() {
        return mCurrentVersion;
    }

    public void setCurrentVersion(@Nullable String currentVersion) {
        mCurrentVersion = currentVersion;
    }

    @Nullable
    @Override
    public String getLatestVersion() {
        return mLatestVersion;
    }

    public void setLatestVersion(@Nullable String latestVersion) {
        mLatestVersion = latestVersion;
    }

    @Nullable
    @Override
    public String getExpectedVersion() {
        return mExpectedVersion;
    }

    public void setExpectedVersion(@Nullable String expectedVersion) {
        mExpectedVersion = expectedVersion;
    }

    @Nullable
    @Override
    public String getIcon() {
        return mIcon;
    }

    public void setIcon(@Nullable String icon) {
        mIcon = icon;
    }

    @Nullable
    @Override
    public Boolean getMcerebrumSupported() {
        return mMcerebrumSupported;
    }

    public void setMcerebrumSupported(@Nullable Boolean mcerebrumSupported) {
        mMcerebrumSupported = mcerebrumSupported;
    }

    @Nullable
    @Override
    public String getFuncInitialize() {
        return mFuncInitialize;
    }

    public void setFuncInitialize(@Nullable String funcInitialize) {
        mFuncInitialize = funcInitialize;
    }

    @Nullable
    @Override
    public Boolean getInitialized() {
        return mInitialized;
    }

    public void setInitialized(@Nullable Boolean initialized) {
        mInitialized = initialized;
    }

    @Nullable
    @Override
    public String getFuncUpdateInfo() {
        return mFuncUpdateInfo;
    }

    public void setFuncUpdateInfo(@Nullable String funcUpdateInfo) {
        mFuncUpdateInfo = funcUpdateInfo;
    }

    @Nullable
    @Override
    public String getFuncConfigure() {
        return mFuncConfigure;
    }

    public void setFuncConfigure(@Nullable String funcConfigure) {
        mFuncConfigure = funcConfigure;
    }

    @Nullable
    @Override
    public Boolean getConfigured() {
        return mConfigured;
    }

    public void setConfigured(@Nullable Boolean configured) {
        mConfigured = configured;
    }

    @Nullable
    @Override
    public Boolean getConfigureMatch() {
        return mConfigureMatch;
    }

    public void setConfigureMatch(@Nullable Boolean configureMatch) {
        mConfigureMatch = configureMatch;
    }

    @Nullable
    @Override
    public String getFuncPermission() {
        return mFuncPermission;
    }

    public void setFuncPermission(@Nullable String funcPermission) {
        mFuncPermission = funcPermission;
    }

    @Nullable
    @Override
    public Boolean getPermissionOk() {
        return mPermissionOk;
    }

    public void setPermissionOk(@Nullable Boolean permissionOk) {
        mPermissionOk = permissionOk;
    }

    @Nullable
    @Override
    public String getFuncBackground() {
        return mFuncBackground;
    }

    public void setFuncBackground(@Nullable String funcBackground) {
        mFuncBackground = funcBackground;
    }

    @Nullable
    @Override
    public Boolean getBackgroundRunningTime() {
        return mBackgroundRunningTime;
    }

    public void setBackgroundRunningTime(@Nullable Boolean backgroundRunningTime) {
        mBackgroundRunningTime = backgroundRunningTime;
    }

    @Nullable
    @Override
    public Boolean getIsBackgroundRunning() {
        return mIsBackgroundRunning;
    }

    public void setIsBackgroundRunning(@Nullable Boolean isBackgroundRunning) {
        mIsBackgroundRunning = isBackgroundRunning;
    }

    @Nullable
    @Override
    public String getFuncReport() {
        return mFuncReport;
    }

    public void setFuncReport(@Nullable String funcReport) {
        mFuncReport = funcReport;
    }

    @Nullable
    @Override
    public String getFuncClear() {
        return mFuncClear;
    }

    public void setFuncClear(@Nullable String funcClear) {
        mFuncClear = funcClear;
    }

    @Nullable
    @Override
    public Boolean getDatakitConnected() {
        return mDatakitConnected;
    }

    public void setDatakitConnected(@Nullable Boolean datakitConnected) {
        mDatakitConnected = datakitConnected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AppInfoBean bean = (AppInfoBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

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

        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        public Builder packageName(@Nullable String packageName) {
            mRes.mPackageName = packageName;
            return this;
        }

        public Builder type(@Nullable String type) {
            mRes.mType = type;
            return this;
        }

        public Builder title(@Nullable String title) {
            mRes.mTitle = title;
            return this;
        }

        public Builder summary(@Nullable String summary) {
            mRes.mSummary = summary;
            return this;
        }

        public Builder description(@Nullable String description) {
            mRes.mDescription = description;
            return this;
        }

        public Builder useInStudy(@Nullable Boolean useInStudy) {
            mRes.mUseInStudy = useInStudy;
            return this;
        }

        public Builder useAs(@Nullable String useAs) {
            mRes.mUseAs = useAs;
            return this;
        }

        public Builder installed(@Nullable Boolean installed) {
            mRes.mInstalled = installed;
            return this;
        }

        public Builder downloadLink(@Nullable String downloadLink) {
            mRes.mDownloadLink = downloadLink;
            return this;
        }

        public Builder updates(@Nullable String updates) {
            mRes.mUpdates = updates;
            return this;
        }

        public Builder currentVersion(@Nullable String currentVersion) {
            mRes.mCurrentVersion = currentVersion;
            return this;
        }

        public Builder latestVersion(@Nullable String latestVersion) {
            mRes.mLatestVersion = latestVersion;
            return this;
        }

        public Builder expectedVersion(@Nullable String expectedVersion) {
            mRes.mExpectedVersion = expectedVersion;
            return this;
        }

        public Builder icon(@Nullable String icon) {
            mRes.mIcon = icon;
            return this;
        }

        public Builder mcerebrumSupported(@Nullable Boolean mcerebrumSupported) {
            mRes.mMcerebrumSupported = mcerebrumSupported;
            return this;
        }

        public Builder funcInitialize(@Nullable String funcInitialize) {
            mRes.mFuncInitialize = funcInitialize;
            return this;
        }

        public Builder initialized(@Nullable Boolean initialized) {
            mRes.mInitialized = initialized;
            return this;
        }

        public Builder funcUpdateInfo(@Nullable String funcUpdateInfo) {
            mRes.mFuncUpdateInfo = funcUpdateInfo;
            return this;
        }

        public Builder funcConfigure(@Nullable String funcConfigure) {
            mRes.mFuncConfigure = funcConfigure;
            return this;
        }

        public Builder configured(@Nullable Boolean configured) {
            mRes.mConfigured = configured;
            return this;
        }

        public Builder configureMatch(@Nullable Boolean configureMatch) {
            mRes.mConfigureMatch = configureMatch;
            return this;
        }

        public Builder funcPermission(@Nullable String funcPermission) {
            mRes.mFuncPermission = funcPermission;
            return this;
        }

        public Builder permissionOk(@Nullable Boolean permissionOk) {
            mRes.mPermissionOk = permissionOk;
            return this;
        }

        public Builder funcBackground(@Nullable String funcBackground) {
            mRes.mFuncBackground = funcBackground;
            return this;
        }

        public Builder backgroundRunningTime(@Nullable Boolean backgroundRunningTime) {
            mRes.mBackgroundRunningTime = backgroundRunningTime;
            return this;
        }

        public Builder isBackgroundRunning(@Nullable Boolean isBackgroundRunning) {
            mRes.mIsBackgroundRunning = isBackgroundRunning;
            return this;
        }

        public Builder funcReport(@Nullable String funcReport) {
            mRes.mFuncReport = funcReport;
            return this;
        }

        public Builder funcClear(@Nullable String funcClear) {
            mRes.mFuncClear = funcClear;
            return this;
        }

        public Builder datakitConnected(@Nullable Boolean datakitConnected) {
            mRes.mDatakitConnected = datakitConnected;
            return this;
        }

        public AppInfoBean build() {
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
