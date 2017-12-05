package org.md2k.mycontentprovider.app;

// @formatter:off
import org.md2k.mycontentprovider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Application Information
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface AppModel extends BaseModel {

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
     * Get the {@code configure} value.
     * Can be {@code null}.
     */
    @Nullable
    String getConfigure();

    /**
     * Get the {@code report} value.
     * Can be {@code null}.
     */
    @Nullable
    String getReport();

    /**
     * Get the {@code clear} value.
     * Can be {@code null}.
     */
    @Nullable
    String getClear();

    /**
     * Get the {@code run_background} value.
     * Can be {@code null}.
     */
    @Nullable
    String getRunBackground();

    /**
     * Get the {@code permission} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPermission();

    /**
     * Get the {@code initialize} value.
     * Can be {@code null}.
     */
    @Nullable
    String getInitialize();

    /**
     * Get the {@code initialized} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getInitialized();

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
     * Get the {@code running_time} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getRunningTime();

    /**
     * Get the {@code is_running_background} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getIsRunningBackground();

    /**
     * Get the {@code permission_ok} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getPermissionOk();

    /**
     * Get the {@code datakit_connected} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getDatakitConnected();
}
