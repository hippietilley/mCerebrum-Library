package org.md2k.mcerebrum.commons.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.content.LocalBroadcastManager;

public class ActivityPermission extends Activity {
    private static final String TAG = ActivityPermission.class.getSimpleName();
    private static final int RESULT_MANAGE_OVERLAY_PERMISSION = 5469;
    private static final int RESULT_PERMISSION = 5470;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            close(true);
        } else {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, RESULT_MANAGE_OVERLAY_PERMISSION);
            } else {
                String list[] = PermissionInfo.getList(this);
                if (list != null)
                    requestPermissions(list, RESULT_PERMISSION);
                else
                    close(true);
            }
        }
    }

    void close(boolean result) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(PermissionInfo.INTENT_RESULT, result);
        setResult(Activity.RESULT_OK, resultIntent);
        Intent intent = new Intent(PermissionInfo.INTENT_PERMISSION);
        intent.putExtra(PermissionInfo.INTENT_PERMISSION_RESULT, result);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        finish();
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_MANAGE_OVERLAY_PERMISSION) {
            if (Settings.canDrawOverlays(this))
                requestPermissions(PermissionInfo.getList(getApplicationContext()), RESULT_PERMISSION);
            else
                close(false);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        boolean flag = true;
        switch (requestCode) {
            case RESULT_PERMISSION: {
                if (grantResults.length == 0) flag = false;
                else {
                    for (int grantResult : grantResults) {
                        if (grantResult == PackageManager.PERMISSION_DENIED) {
                            flag = false;
                            break;
                        }
                    }
                }
                close(flag);
            }
        }
    }
}