package org.md2k.mcerebrum.core.access.appinfo;

// @formatter:off

import android.content.ContentResolver;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;

import org.md2k.mcerebrum.core.access.base.AbstractSelection;

/**
 * App ContentProvider Selection class.
 * This class is auto-generated by Android ContentProvider Generator.
 * For more information see <a href="https://github.com/BoD/android-contentprovider-generator">GitHub</a>.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class AppInfoSelection extends AbstractSelection<AppInfoSelection> {
    @Override
    protected Uri baseUri() {
        return AppInfoColumns.CONTENT_URI;
    }

    public AppInfoCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new AppInfoCursor(cursor);
    }

    public AppInfoCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    public AppInfoCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new AppInfoCursor(cursor);
    }

    public AppInfoCursor query(Context context) {
        return query(context, null);
    }

    @Override
    public CursorLoader getCursorLoader(Context context, String[] projection) {
        return new CursorLoader(context, uri(), projection, sel(), args(), order()) {
            @Override
            public Cursor loadInBackground() {
                return new AppInfoCursor(super.loadInBackground());
            }
        };
    }


    public AppInfoSelection id(long... value) {
        addEquals("app_info." + AppInfoColumns._ID, toObjectArray(value));
        return this;
    }

    public AppInfoSelection idNot(long... value) {
        addNotEquals("app_info." + AppInfoColumns._ID, toObjectArray(value));
        return this;
    }

    public AppInfoSelection orderById(boolean desc) {
        orderBy("app_info." + AppInfoColumns._ID, desc);
        return this;
    }

    public AppInfoSelection orderById() {
        return orderById(false);
    }

    public AppInfoSelection packageName(String... value) {
        addEquals(AppInfoColumns.PACKAGE_NAME, value);
        return this;
    }

    public AppInfoSelection packageNameNot(String... value) {
        addNotEquals(AppInfoColumns.PACKAGE_NAME, value);
        return this;
    }

    public AppInfoSelection packageNameLike(String... value) {
        addLike(AppInfoColumns.PACKAGE_NAME, value);
        return this;
    }

    public AppInfoSelection packageNameContains(String... value) {
        addContains(AppInfoColumns.PACKAGE_NAME, value);
        return this;
    }

    public AppInfoSelection packageNameStartsWith(String... value) {
        addStartsWith(AppInfoColumns.PACKAGE_NAME, value);
        return this;
    }

    public AppInfoSelection packageNameEndsWith(String... value) {
        addEndsWith(AppInfoColumns.PACKAGE_NAME, value);
        return this;
    }

    public AppInfoSelection orderByPackageName(boolean desc) {
        orderBy(AppInfoColumns.PACKAGE_NAME, desc);
        return this;
    }

    public AppInfoSelection orderByPackageName() {
        orderBy(AppInfoColumns.PACKAGE_NAME, false);
        return this;
    }

    public AppInfoSelection type(String... value) {
        addEquals(AppInfoColumns.TYPE, value);
        return this;
    }

    public AppInfoSelection typeNot(String... value) {
        addNotEquals(AppInfoColumns.TYPE, value);
        return this;
    }

    public AppInfoSelection typeLike(String... value) {
        addLike(AppInfoColumns.TYPE, value);
        return this;
    }

    public AppInfoSelection typeContains(String... value) {
        addContains(AppInfoColumns.TYPE, value);
        return this;
    }

    public AppInfoSelection typeStartsWith(String... value) {
        addStartsWith(AppInfoColumns.TYPE, value);
        return this;
    }

    public AppInfoSelection typeEndsWith(String... value) {
        addEndsWith(AppInfoColumns.TYPE, value);
        return this;
    }

    public AppInfoSelection orderByType(boolean desc) {
        orderBy(AppInfoColumns.TYPE, desc);
        return this;
    }

    public AppInfoSelection orderByType() {
        orderBy(AppInfoColumns.TYPE, false);
        return this;
    }

    public AppInfoSelection title(String... value) {
        addEquals(AppInfoColumns.TITLE, value);
        return this;
    }

    public AppInfoSelection titleNot(String... value) {
        addNotEquals(AppInfoColumns.TITLE, value);
        return this;
    }

    public AppInfoSelection titleLike(String... value) {
        addLike(AppInfoColumns.TITLE, value);
        return this;
    }

    public AppInfoSelection titleContains(String... value) {
        addContains(AppInfoColumns.TITLE, value);
        return this;
    }

    public AppInfoSelection titleStartsWith(String... value) {
        addStartsWith(AppInfoColumns.TITLE, value);
        return this;
    }

    public AppInfoSelection titleEndsWith(String... value) {
        addEndsWith(AppInfoColumns.TITLE, value);
        return this;
    }

    public AppInfoSelection orderByTitle(boolean desc) {
        orderBy(AppInfoColumns.TITLE, desc);
        return this;
    }

    public AppInfoSelection orderByTitle() {
        orderBy(AppInfoColumns.TITLE, false);
        return this;
    }

    public AppInfoSelection summary(String... value) {
        addEquals(AppInfoColumns.SUMMARY, value);
        return this;
    }

    public AppInfoSelection summaryNot(String... value) {
        addNotEquals(AppInfoColumns.SUMMARY, value);
        return this;
    }

    public AppInfoSelection summaryLike(String... value) {
        addLike(AppInfoColumns.SUMMARY, value);
        return this;
    }

    public AppInfoSelection summaryContains(String... value) {
        addContains(AppInfoColumns.SUMMARY, value);
        return this;
    }

    public AppInfoSelection summaryStartsWith(String... value) {
        addStartsWith(AppInfoColumns.SUMMARY, value);
        return this;
    }

    public AppInfoSelection summaryEndsWith(String... value) {
        addEndsWith(AppInfoColumns.SUMMARY, value);
        return this;
    }

    public AppInfoSelection orderBySummary(boolean desc) {
        orderBy(AppInfoColumns.SUMMARY, desc);
        return this;
    }

    public AppInfoSelection orderBySummary() {
        orderBy(AppInfoColumns.SUMMARY, false);
        return this;
    }

    public AppInfoSelection description(String... value) {
        addEquals(AppInfoColumns.DESCRIPTION, value);
        return this;
    }

    public AppInfoSelection descriptionNot(String... value) {
        addNotEquals(AppInfoColumns.DESCRIPTION, value);
        return this;
    }

    public AppInfoSelection descriptionLike(String... value) {
        addLike(AppInfoColumns.DESCRIPTION, value);
        return this;
    }

    public AppInfoSelection descriptionContains(String... value) {
        addContains(AppInfoColumns.DESCRIPTION, value);
        return this;
    }

    public AppInfoSelection descriptionStartsWith(String... value) {
        addStartsWith(AppInfoColumns.DESCRIPTION, value);
        return this;
    }

    public AppInfoSelection descriptionEndsWith(String... value) {
        addEndsWith(AppInfoColumns.DESCRIPTION, value);
        return this;
    }

    public AppInfoSelection orderByDescription(boolean desc) {
        orderBy(AppInfoColumns.DESCRIPTION, desc);
        return this;
    }

    public AppInfoSelection orderByDescription() {
        orderBy(AppInfoColumns.DESCRIPTION, false);
        return this;
    }

    public AppInfoSelection useInStudy(Boolean value) {
        addEquals(AppInfoColumns.USE_IN_STUDY, toObjectArray(value));
        return this;
    }

    public AppInfoSelection orderByUseInStudy(boolean desc) {
        orderBy(AppInfoColumns.USE_IN_STUDY, desc);
        return this;
    }

    public AppInfoSelection orderByUseInStudy() {
        orderBy(AppInfoColumns.USE_IN_STUDY, false);
        return this;
    }

    public AppInfoSelection useAs(String... value) {
        addEquals(AppInfoColumns.USE_AS, value);
        return this;
    }

    public AppInfoSelection useAsNot(String... value) {
        addNotEquals(AppInfoColumns.USE_AS, value);
        return this;
    }

    public AppInfoSelection useAsLike(String... value) {
        addLike(AppInfoColumns.USE_AS, value);
        return this;
    }

    public AppInfoSelection useAsContains(String... value) {
        addContains(AppInfoColumns.USE_AS, value);
        return this;
    }

    public AppInfoSelection useAsStartsWith(String... value) {
        addStartsWith(AppInfoColumns.USE_AS, value);
        return this;
    }

    public AppInfoSelection useAsEndsWith(String... value) {
        addEndsWith(AppInfoColumns.USE_AS, value);
        return this;
    }

    public AppInfoSelection orderByUseAs(boolean desc) {
        orderBy(AppInfoColumns.USE_AS, desc);
        return this;
    }

    public AppInfoSelection orderByUseAs() {
        orderBy(AppInfoColumns.USE_AS, false);
        return this;
    }

    public AppInfoSelection installed(Boolean value) {
        addEquals(AppInfoColumns.INSTALLED, toObjectArray(value));
        return this;
    }

    public AppInfoSelection orderByInstalled(boolean desc) {
        orderBy(AppInfoColumns.INSTALLED, desc);
        return this;
    }

    public AppInfoSelection orderByInstalled() {
        orderBy(AppInfoColumns.INSTALLED, false);
        return this;
    }

    public AppInfoSelection downloadLink(String... value) {
        addEquals(AppInfoColumns.DOWNLOAD_LINK, value);
        return this;
    }

    public AppInfoSelection downloadLinkNot(String... value) {
        addNotEquals(AppInfoColumns.DOWNLOAD_LINK, value);
        return this;
    }

    public AppInfoSelection downloadLinkLike(String... value) {
        addLike(AppInfoColumns.DOWNLOAD_LINK, value);
        return this;
    }

    public AppInfoSelection downloadLinkContains(String... value) {
        addContains(AppInfoColumns.DOWNLOAD_LINK, value);
        return this;
    }

    public AppInfoSelection downloadLinkStartsWith(String... value) {
        addStartsWith(AppInfoColumns.DOWNLOAD_LINK, value);
        return this;
    }

    public AppInfoSelection downloadLinkEndsWith(String... value) {
        addEndsWith(AppInfoColumns.DOWNLOAD_LINK, value);
        return this;
    }

    public AppInfoSelection orderByDownloadLink(boolean desc) {
        orderBy(AppInfoColumns.DOWNLOAD_LINK, desc);
        return this;
    }

    public AppInfoSelection orderByDownloadLink() {
        orderBy(AppInfoColumns.DOWNLOAD_LINK, false);
        return this;
    }

    public AppInfoSelection updates(String... value) {
        addEquals(AppInfoColumns.UPDATES, value);
        return this;
    }

    public AppInfoSelection updatesNot(String... value) {
        addNotEquals(AppInfoColumns.UPDATES, value);
        return this;
    }

    public AppInfoSelection updatesLike(String... value) {
        addLike(AppInfoColumns.UPDATES, value);
        return this;
    }

    public AppInfoSelection updatesContains(String... value) {
        addContains(AppInfoColumns.UPDATES, value);
        return this;
    }

    public AppInfoSelection updatesStartsWith(String... value) {
        addStartsWith(AppInfoColumns.UPDATES, value);
        return this;
    }

    public AppInfoSelection updatesEndsWith(String... value) {
        addEndsWith(AppInfoColumns.UPDATES, value);
        return this;
    }

    public AppInfoSelection orderByUpdates(boolean desc) {
        orderBy(AppInfoColumns.UPDATES, desc);
        return this;
    }

    public AppInfoSelection orderByUpdates() {
        orderBy(AppInfoColumns.UPDATES, false);
        return this;
    }

    public AppInfoSelection currentVersion(String... value) {
        addEquals(AppInfoColumns.CURRENT_VERSION, value);
        return this;
    }

    public AppInfoSelection currentVersionNot(String... value) {
        addNotEquals(AppInfoColumns.CURRENT_VERSION, value);
        return this;
    }

    public AppInfoSelection currentVersionLike(String... value) {
        addLike(AppInfoColumns.CURRENT_VERSION, value);
        return this;
    }

    public AppInfoSelection currentVersionContains(String... value) {
        addContains(AppInfoColumns.CURRENT_VERSION, value);
        return this;
    }

    public AppInfoSelection currentVersionStartsWith(String... value) {
        addStartsWith(AppInfoColumns.CURRENT_VERSION, value);
        return this;
    }

    public AppInfoSelection currentVersionEndsWith(String... value) {
        addEndsWith(AppInfoColumns.CURRENT_VERSION, value);
        return this;
    }

    public AppInfoSelection orderByCurrentVersion(boolean desc) {
        orderBy(AppInfoColumns.CURRENT_VERSION, desc);
        return this;
    }

    public AppInfoSelection orderByCurrentVersion() {
        orderBy(AppInfoColumns.CURRENT_VERSION, false);
        return this;
    }

    public AppInfoSelection latestVersion(String... value) {
        addEquals(AppInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public AppInfoSelection latestVersionNot(String... value) {
        addNotEquals(AppInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public AppInfoSelection latestVersionLike(String... value) {
        addLike(AppInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public AppInfoSelection latestVersionContains(String... value) {
        addContains(AppInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public AppInfoSelection latestVersionStartsWith(String... value) {
        addStartsWith(AppInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public AppInfoSelection latestVersionEndsWith(String... value) {
        addEndsWith(AppInfoColumns.LATEST_VERSION, value);
        return this;
    }

    public AppInfoSelection orderByLatestVersion(boolean desc) {
        orderBy(AppInfoColumns.LATEST_VERSION, desc);
        return this;
    }

    public AppInfoSelection orderByLatestVersion() {
        orderBy(AppInfoColumns.LATEST_VERSION, false);
        return this;
    }

    public AppInfoSelection expectedVersion(String... value) {
        addEquals(AppInfoColumns.EXPECTED_VERSION, value);
        return this;
    }

    public AppInfoSelection expectedVersionNot(String... value) {
        addNotEquals(AppInfoColumns.EXPECTED_VERSION, value);
        return this;
    }

    public AppInfoSelection expectedVersionLike(String... value) {
        addLike(AppInfoColumns.EXPECTED_VERSION, value);
        return this;
    }

    public AppInfoSelection expectedVersionContains(String... value) {
        addContains(AppInfoColumns.EXPECTED_VERSION, value);
        return this;
    }

    public AppInfoSelection expectedVersionStartsWith(String... value) {
        addStartsWith(AppInfoColumns.EXPECTED_VERSION, value);
        return this;
    }

    public AppInfoSelection expectedVersionEndsWith(String... value) {
        addEndsWith(AppInfoColumns.EXPECTED_VERSION, value);
        return this;
    }

    public AppInfoSelection orderByExpectedVersion(boolean desc) {
        orderBy(AppInfoColumns.EXPECTED_VERSION, desc);
        return this;
    }

    public AppInfoSelection orderByExpectedVersion() {
        orderBy(AppInfoColumns.EXPECTED_VERSION, false);
        return this;
    }

    public AppInfoSelection icon(String... value) {
        addEquals(AppInfoColumns.ICON, value);
        return this;
    }

    public AppInfoSelection iconNot(String... value) {
        addNotEquals(AppInfoColumns.ICON, value);
        return this;
    }

    public AppInfoSelection iconLike(String... value) {
        addLike(AppInfoColumns.ICON, value);
        return this;
    }

    public AppInfoSelection iconContains(String... value) {
        addContains(AppInfoColumns.ICON, value);
        return this;
    }

    public AppInfoSelection iconStartsWith(String... value) {
        addStartsWith(AppInfoColumns.ICON, value);
        return this;
    }

    public AppInfoSelection iconEndsWith(String... value) {
        addEndsWith(AppInfoColumns.ICON, value);
        return this;
    }

    public AppInfoSelection orderByIcon(boolean desc) {
        orderBy(AppInfoColumns.ICON, desc);
        return this;
    }

    public AppInfoSelection orderByIcon() {
        orderBy(AppInfoColumns.ICON, false);
        return this;
    }

    public AppInfoSelection mcerebrumSupported(Boolean value) {
        addEquals(AppInfoColumns.MCEREBRUM_SUPPORTED, toObjectArray(value));
        return this;
    }

    public AppInfoSelection orderByMcerebrumSupported(boolean desc) {
        orderBy(AppInfoColumns.MCEREBRUM_SUPPORTED, desc);
        return this;
    }

    public AppInfoSelection orderByMcerebrumSupported() {
        orderBy(AppInfoColumns.MCEREBRUM_SUPPORTED, false);
        return this;
    }

    public AppInfoSelection funcInitialize(String... value) {
        addEquals(AppInfoColumns.FUNC_INITIALIZE, value);
        return this;
    }

    public AppInfoSelection funcInitializeNot(String... value) {
        addNotEquals(AppInfoColumns.FUNC_INITIALIZE, value);
        return this;
    }

    public AppInfoSelection funcInitializeLike(String... value) {
        addLike(AppInfoColumns.FUNC_INITIALIZE, value);
        return this;
    }

    public AppInfoSelection funcInitializeContains(String... value) {
        addContains(AppInfoColumns.FUNC_INITIALIZE, value);
        return this;
    }

    public AppInfoSelection funcInitializeStartsWith(String... value) {
        addStartsWith(AppInfoColumns.FUNC_INITIALIZE, value);
        return this;
    }

    public AppInfoSelection funcInitializeEndsWith(String... value) {
        addEndsWith(AppInfoColumns.FUNC_INITIALIZE, value);
        return this;
    }

    public AppInfoSelection orderByFuncInitialize(boolean desc) {
        orderBy(AppInfoColumns.FUNC_INITIALIZE, desc);
        return this;
    }

    public AppInfoSelection orderByFuncInitialize() {
        orderBy(AppInfoColumns.FUNC_INITIALIZE, false);
        return this;
    }

    public AppInfoSelection initialized(Boolean value) {
        addEquals(AppInfoColumns.INITIALIZED, toObjectArray(value));
        return this;
    }

    public AppInfoSelection orderByInitialized(boolean desc) {
        orderBy(AppInfoColumns.INITIALIZED, desc);
        return this;
    }

    public AppInfoSelection orderByInitialized() {
        orderBy(AppInfoColumns.INITIALIZED, false);
        return this;
    }

    public AppInfoSelection funcUpdateInfo(String... value) {
        addEquals(AppInfoColumns.FUNC_UPDATE_INFO, value);
        return this;
    }

    public AppInfoSelection funcUpdateInfoNot(String... value) {
        addNotEquals(AppInfoColumns.FUNC_UPDATE_INFO, value);
        return this;
    }

    public AppInfoSelection funcUpdateInfoLike(String... value) {
        addLike(AppInfoColumns.FUNC_UPDATE_INFO, value);
        return this;
    }

    public AppInfoSelection funcUpdateInfoContains(String... value) {
        addContains(AppInfoColumns.FUNC_UPDATE_INFO, value);
        return this;
    }

    public AppInfoSelection funcUpdateInfoStartsWith(String... value) {
        addStartsWith(AppInfoColumns.FUNC_UPDATE_INFO, value);
        return this;
    }

    public AppInfoSelection funcUpdateInfoEndsWith(String... value) {
        addEndsWith(AppInfoColumns.FUNC_UPDATE_INFO, value);
        return this;
    }

    public AppInfoSelection orderByFuncUpdateInfo(boolean desc) {
        orderBy(AppInfoColumns.FUNC_UPDATE_INFO, desc);
        return this;
    }

    public AppInfoSelection orderByFuncUpdateInfo() {
        orderBy(AppInfoColumns.FUNC_UPDATE_INFO, false);
        return this;
    }

    public AppInfoSelection funcConfigure(String... value) {
        addEquals(AppInfoColumns.FUNC_CONFIGURE, value);
        return this;
    }

    public AppInfoSelection funcConfigureNot(String... value) {
        addNotEquals(AppInfoColumns.FUNC_CONFIGURE, value);
        return this;
    }

    public AppInfoSelection funcConfigureLike(String... value) {
        addLike(AppInfoColumns.FUNC_CONFIGURE, value);
        return this;
    }

    public AppInfoSelection funcConfigureContains(String... value) {
        addContains(AppInfoColumns.FUNC_CONFIGURE, value);
        return this;
    }

    public AppInfoSelection funcConfigureStartsWith(String... value) {
        addStartsWith(AppInfoColumns.FUNC_CONFIGURE, value);
        return this;
    }

    public AppInfoSelection funcConfigureEndsWith(String... value) {
        addEndsWith(AppInfoColumns.FUNC_CONFIGURE, value);
        return this;
    }

    public AppInfoSelection orderByFuncConfigure(boolean desc) {
        orderBy(AppInfoColumns.FUNC_CONFIGURE, desc);
        return this;
    }

    public AppInfoSelection orderByFuncConfigure() {
        orderBy(AppInfoColumns.FUNC_CONFIGURE, false);
        return this;
    }

    public AppInfoSelection configured(Boolean value) {
        addEquals(AppInfoColumns.CONFIGURED, toObjectArray(value));
        return this;
    }

    public AppInfoSelection orderByConfigured(boolean desc) {
        orderBy(AppInfoColumns.CONFIGURED, desc);
        return this;
    }

    public AppInfoSelection orderByConfigured() {
        orderBy(AppInfoColumns.CONFIGURED, false);
        return this;
    }

    public AppInfoSelection configureMatch(Boolean value) {
        addEquals(AppInfoColumns.CONFIGURE_MATCH, toObjectArray(value));
        return this;
    }

    public AppInfoSelection orderByConfigureMatch(boolean desc) {
        orderBy(AppInfoColumns.CONFIGURE_MATCH, desc);
        return this;
    }

    public AppInfoSelection orderByConfigureMatch() {
        orderBy(AppInfoColumns.CONFIGURE_MATCH, false);
        return this;
    }

    public AppInfoSelection funcPermission(String... value) {
        addEquals(AppInfoColumns.FUNC_PERMISSION, value);
        return this;
    }

    public AppInfoSelection funcPermissionNot(String... value) {
        addNotEquals(AppInfoColumns.FUNC_PERMISSION, value);
        return this;
    }

    public AppInfoSelection funcPermissionLike(String... value) {
        addLike(AppInfoColumns.FUNC_PERMISSION, value);
        return this;
    }

    public AppInfoSelection funcPermissionContains(String... value) {
        addContains(AppInfoColumns.FUNC_PERMISSION, value);
        return this;
    }

    public AppInfoSelection funcPermissionStartsWith(String... value) {
        addStartsWith(AppInfoColumns.FUNC_PERMISSION, value);
        return this;
    }

    public AppInfoSelection funcPermissionEndsWith(String... value) {
        addEndsWith(AppInfoColumns.FUNC_PERMISSION, value);
        return this;
    }

    public AppInfoSelection orderByFuncPermission(boolean desc) {
        orderBy(AppInfoColumns.FUNC_PERMISSION, desc);
        return this;
    }

    public AppInfoSelection orderByFuncPermission() {
        orderBy(AppInfoColumns.FUNC_PERMISSION, false);
        return this;
    }

    public AppInfoSelection permissionOk(Boolean value) {
        addEquals(AppInfoColumns.PERMISSION_OK, toObjectArray(value));
        return this;
    }

    public AppInfoSelection orderByPermissionOk(boolean desc) {
        orderBy(AppInfoColumns.PERMISSION_OK, desc);
        return this;
    }

    public AppInfoSelection orderByPermissionOk() {
        orderBy(AppInfoColumns.PERMISSION_OK, false);
        return this;
    }

    public AppInfoSelection funcBackground(String... value) {
        addEquals(AppInfoColumns.FUNC_BACKGROUND, value);
        return this;
    }

    public AppInfoSelection funcBackgroundNot(String... value) {
        addNotEquals(AppInfoColumns.FUNC_BACKGROUND, value);
        return this;
    }

    public AppInfoSelection funcBackgroundLike(String... value) {
        addLike(AppInfoColumns.FUNC_BACKGROUND, value);
        return this;
    }

    public AppInfoSelection funcBackgroundContains(String... value) {
        addContains(AppInfoColumns.FUNC_BACKGROUND, value);
        return this;
    }

    public AppInfoSelection funcBackgroundStartsWith(String... value) {
        addStartsWith(AppInfoColumns.FUNC_BACKGROUND, value);
        return this;
    }

    public AppInfoSelection funcBackgroundEndsWith(String... value) {
        addEndsWith(AppInfoColumns.FUNC_BACKGROUND, value);
        return this;
    }

    public AppInfoSelection orderByFuncBackground(boolean desc) {
        orderBy(AppInfoColumns.FUNC_BACKGROUND, desc);
        return this;
    }

    public AppInfoSelection orderByFuncBackground() {
        orderBy(AppInfoColumns.FUNC_BACKGROUND, false);
        return this;
    }

    public AppInfoSelection backgroundRunningTime(Boolean value) {
        addEquals(AppInfoColumns.BACKGROUND_RUNNING_TIME, toObjectArray(value));
        return this;
    }

    public AppInfoSelection orderByBackgroundRunningTime(boolean desc) {
        orderBy(AppInfoColumns.BACKGROUND_RUNNING_TIME, desc);
        return this;
    }

    public AppInfoSelection orderByBackgroundRunningTime() {
        orderBy(AppInfoColumns.BACKGROUND_RUNNING_TIME, false);
        return this;
    }

    public AppInfoSelection isBackgroundRunning(Boolean value) {
        addEquals(AppInfoColumns.IS_BACKGROUND_RUNNING, toObjectArray(value));
        return this;
    }

    public AppInfoSelection orderByIsBackgroundRunning(boolean desc) {
        orderBy(AppInfoColumns.IS_BACKGROUND_RUNNING, desc);
        return this;
    }

    public AppInfoSelection orderByIsBackgroundRunning() {
        orderBy(AppInfoColumns.IS_BACKGROUND_RUNNING, false);
        return this;
    }

    public AppInfoSelection funcReport(String... value) {
        addEquals(AppInfoColumns.FUNC_REPORT, value);
        return this;
    }

    public AppInfoSelection funcReportNot(String... value) {
        addNotEquals(AppInfoColumns.FUNC_REPORT, value);
        return this;
    }

    public AppInfoSelection funcReportLike(String... value) {
        addLike(AppInfoColumns.FUNC_REPORT, value);
        return this;
    }

    public AppInfoSelection funcReportContains(String... value) {
        addContains(AppInfoColumns.FUNC_REPORT, value);
        return this;
    }

    public AppInfoSelection funcReportStartsWith(String... value) {
        addStartsWith(AppInfoColumns.FUNC_REPORT, value);
        return this;
    }

    public AppInfoSelection funcReportEndsWith(String... value) {
        addEndsWith(AppInfoColumns.FUNC_REPORT, value);
        return this;
    }

    public AppInfoSelection orderByFuncReport(boolean desc) {
        orderBy(AppInfoColumns.FUNC_REPORT, desc);
        return this;
    }

    public AppInfoSelection orderByFuncReport() {
        orderBy(AppInfoColumns.FUNC_REPORT, false);
        return this;
    }

    public AppInfoSelection funcClear(String... value) {
        addEquals(AppInfoColumns.FUNC_CLEAR, value);
        return this;
    }

    public AppInfoSelection funcClearNot(String... value) {
        addNotEquals(AppInfoColumns.FUNC_CLEAR, value);
        return this;
    }

    public AppInfoSelection funcClearLike(String... value) {
        addLike(AppInfoColumns.FUNC_CLEAR, value);
        return this;
    }

    public AppInfoSelection funcClearContains(String... value) {
        addContains(AppInfoColumns.FUNC_CLEAR, value);
        return this;
    }

    public AppInfoSelection funcClearStartsWith(String... value) {
        addStartsWith(AppInfoColumns.FUNC_CLEAR, value);
        return this;
    }

    public AppInfoSelection funcClearEndsWith(String... value) {
        addEndsWith(AppInfoColumns.FUNC_CLEAR, value);
        return this;
    }

    public AppInfoSelection orderByFuncClear(boolean desc) {
        orderBy(AppInfoColumns.FUNC_CLEAR, desc);
        return this;
    }

    public AppInfoSelection orderByFuncClear() {
        orderBy(AppInfoColumns.FUNC_CLEAR, false);
        return this;
    }

    public AppInfoSelection datakitConnected(Boolean value) {
        addEquals(AppInfoColumns.DATAKIT_CONNECTED, toObjectArray(value));
        return this;
    }

    public AppInfoSelection orderByDatakitConnected(boolean desc) {
        orderBy(AppInfoColumns.DATAKIT_CONNECTED, desc);
        return this;
    }

    public AppInfoSelection orderByDatakitConnected() {
        orderBy(AppInfoColumns.DATAKIT_CONNECTED, false);
        return this;
    }
}
