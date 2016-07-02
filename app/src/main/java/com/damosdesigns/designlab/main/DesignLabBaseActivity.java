package com.damosdesigns.designlab.main;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by damosdesigns on 6/25/16.
 */
public class DesignLabBaseActivity extends AppCompatActivity {

    private boolean mSendSMS = false;

    public boolean ismSendSMS() {
        return mSendSMS;
    }

    public void setmSendSMS(boolean mSendSMS) {
        this.mSendSMS = mSendSMS;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences settings = getSharedPreferences(Constants.SHARED_PREFERENCES, 0);
        boolean sendSms = settings.getBoolean("sendSMS", false);
        setmSendSMS(sendSms);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences settings = getSharedPreferences(Constants.SHARED_PREFERENCES, 0);
        SharedPreferences.Editor eddy = settings.edit();
        eddy.putBoolean("sendSMS", mSendSMS);
        eddy.commit();
    }
}

