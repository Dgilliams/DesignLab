package com.damosdesigns.designlab.main;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by damosdesigns on 6/25/16.
 */
public  class PermissionUtils {

    public static void checkForSEND_SMSPermission(Activity activity) {
        checkForPermission(activity, Manifest.permission.SEND_SMS, Constants.PERMISSION_SEND_SMS);
    }

    public static void checkForPermission(Activity activity, String permission, final int RequestCallBack) {
        if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                //show an explanation to the user *asynchronously* dont, block

            } else {
                //no explanation needed, we can request the permission
                ActivityCompat.requestPermissions(activity, new String[]{permission}, Constants.PERMISSION_SEND_SMS);
            }
        }
    }
}
