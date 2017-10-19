package org.md2k.mcerebrum.core.access.appinfo;

// @formatter:off
import org.md2k.mcerebrum.core.access.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Application Information
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface AppInfoModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Get the {@code package_name} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPackageName();

    /**
     * MCEREBRUM, STUDY, DATAKIT,any other string
     * Can be {@code null}.
     */
    @Nullable
    String getType();

    /**
     * Get the {@code title} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTitle();

    /**
     * Get the {@code summary} value.
     * Can be {@code null}.
     */
    @Nullable
    String getSummary();

    /**
     * Get the {@code description} value.
     * Can be {@code null}.
     */
    @Nullable
    String getDescription();

    /**
     * Get the {@code use_in_study} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getUseInStudy();

    /**
     * not in use, required, optional
     * Can be {@code null}.
     */
    @Nullable
    String getUseAs();

    /**
     * Get the {@code installed} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getInstalled();

    /**
     * Get the {@code download_link} value.
     * Can be {@code null}.
     */
    @Nullable
    String getDownloadLink();

    /**
     * NOTIFY, AUTO, MANUAL
     * Can be {@code null}.
     */
    @Nullable
    String getUpdates();

    /**
     * Get the {@code current_version} value.
     * Can be {@code null}.
     */
    @Nullable
    String getCurrentVersion();

    /**
     * Get the {@code latest_version} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLatestVersion();

    /**
     * Get the {@code expected_version} value.
     * Can be {@code null}.
     */
    @Nullable
    String getExpectedVersion();

    /**
     * Get the {@code icon} value.
     * Can be {@code null}.
     */
    @Nullable
    String getIcon();

    /**
     * Get the {@code mcerebrum_supported} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getMcerebrumSupported();

    /**
     * Get the {@code func_initialize} value.
     * Can be {@code null}.
     */
    @Nullable
    String getFuncInitialize();

    /**
     * Get the {@code initialized} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getInitialized();

    /**
     * Get the {@code func_update_info} value.
     * Can be {@code null}.
     */
    @Nullable
    String getFuncUpdateInfo();

    /**
     * Get the {@code func_configure} value.
     * Can be {@code null}.
     */
    @Nullable
    String getFuncConfigure();

    /**
     * Get the {@code configured} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getConfigured();

    /**
     * Get the {@code configure_match} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getConfigureMatch();

    /**
     * Get the {@code func_permission} value.
     * Can be {@code null}.
     */
    @Nullable
    String getFuncPermission();

    /**
     * Get the {@code permission_ok} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getPermissionOk();

    /**
     * Get the {@code func_background} value.
     * Can be {@code null}.
     */
    @Nullable
    String getFuncBackground();

    /**
     * Get the {@code background_running_time} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getBackgroundRunningTime();

    /**
     * Get the {@code is_background_running} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getIsBackgroundRunning();

    /**
     * Get the {@code func_report} value.
     * Can be {@code null}.
     */
    @Nullable
    String getFuncReport();

    /**
     * Get the {@code func_clear} value.
     * Can be {@code null}.
     */
    @Nullable
    String getFuncClear();

    /**
     * Get the {@code datakit_connected} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getDatakitConnected();
}
