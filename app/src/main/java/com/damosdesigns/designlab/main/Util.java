package com.damosdesigns.designlab.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.SmsManager;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.damosdesigns.designlab.R;

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

    public static int returnRandomMaterialColor(Context context){
        int[] androidColors = context.getResources().getIntArray(R.array.random_material_colors);
       return androidColors[new Random().nextInt(androidColors.length)];
    }

    public static boolean sendSMS(Context context, String phoneNumber, String msg){
        try{
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, msg, null, null);
            Toast.makeText(context, "Carrier Pidgeon sent to Damo", Toast.LENGTH_LONG).show();
            return true;
        } catch (Exception e) {
            Toast.makeText(context, "Dearest Apologies, message not sendable", Toast.LENGTH_LONG).show();
            return false;
        }
    }
}
