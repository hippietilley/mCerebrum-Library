package org.md2k.mcerebrum.core.access.userinfo;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.md2k.mcerebrum.core.access.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code user_info} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class UserInfoContentValues extends AbstractContentValues<UserInfoContentValues> {
    @Override
    protected Uri baseUri() {
        return UserInfoColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable UserInfoSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable UserInfoSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public UserInfoContentValues putUid(@Nullable String value) {
        mContentValues.put(UserInfoColumns.UID, value);
        return this;
    }

    public UserInfoContentValues putUidNull() {
        mContentValues.putNull(UserInfoColumns.UID);
        return this;
    }

    public UserInfoContentValues putType(@Nullable String value) {
        mContentValues.put(UserInfoColumns.TYPE, value);
        return this;
    }

    public UserInfoContentValues putTypeNull() {
        mContentValues.putNull(UserInfoColumns.TYPE);
        return this;
    }

    public UserInfoContentValues putUsername(@Nullable String value) {
        mContentValues.put(UserInfoColumns.USERNAME, value);
        return this;
    }

    public UserInfoContentValues putUsernameNull() {
        mContentValues.putNull(UserInfoColumns.USERNAME);
        return this;
    }
}
