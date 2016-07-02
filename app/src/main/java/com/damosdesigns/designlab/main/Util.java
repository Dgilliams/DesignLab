package com.damosdesigns.designlab.main;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.damosdesigns.designlab.R;

import java.util.List;
import java.util.Random;

/**
 * Created by damosdesigns on 6/19/16.
 */
public class Util {
    public static void launchPlaystore(Context context, String appPackageName) {
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

    public static int returnRandomMaterialColor(Context context) {
        int[] androidColors = context.getResources().getIntArray(R.array.random_material_colors);
        return androidColors[new Random().nextInt(androidColors.length)];
    }

    public static void dialNumber(Context context) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:7727131983"));
        //permission checked already
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // Consider calling   ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        context.startActivity(callIntent);
    }

    public static void openVenmo(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("venmo://dgilliams"));
        final PackageManager packageManager = context.getPackageManager();
        final List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (list.isEmpty()) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.venmo.com/dgilliams"));
        }
        context.startActivity(intent);
    }


    public static void openLinkedIn(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://damien-gilliams-2b178389"));
        final PackageManager packageManager = context.getPackageManager();
        final List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (list.isEmpty()) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.linkedin.com/profile/view?id=damien-gilliams-2b178389"));
        }
        context.startActivity(intent);
    }

    public static void sendEmail(Context context){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"DamosDesigns@Gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "I need an Android Developer!");
//        i.putExtra(Intent.EXTRA_TEXT   , "body of email");
        try {
            context.startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "Sorry! There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean sendSMS(Context context, String phoneNumber, String msg) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, msg, null, null);
            Toast.makeText(context, "Message Sent To Damien!", Toast.LENGTH_LONG).show();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "Dearest Apologies, message not sendable. Please try again later!", Toast.LENGTH_LONG).show();
            return false;
        }
    }
}
