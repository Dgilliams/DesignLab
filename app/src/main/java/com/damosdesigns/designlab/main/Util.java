package com.damosdesigns.designlab.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

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
}
