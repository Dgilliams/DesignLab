package com.damosdesigns.designlab.main;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.damosdesigns.designlab.R;

public class Dev4HireActivity extends DesignLabBaseActivity {

    final Dev4HireActivity mActivity = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev4_hire);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ismSendSMS()){
                    Util.sendSMS(getApplicationContext(), "7727131983", "Hey Damo!");
                    Util.sendSMS(getApplicationContext(), "7727131983", "\uD83D\uDE17");
                }else {
                    PermissionUtils.checkForSEND_SMSPermission(mActivity);
                }
                //refer to the callback onRequestPermissionsResultBelow
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case Constants.PERMISSION_SEND_SMS: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    should be setting the sharedpreference here that allows the next line to send the text
                    setmSendSMS(true);
                } else {
                    setmSendSMS(false);
                    Toast.makeText(Dev4HireActivity.this, "SMS Permission denied", Toast.LENGTH_SHORT).show();
                    //permission denied, thats some shit
                    //disable whatever awesomeness you were about to enable
                }
                return;
            }
            //more cases
        }
    }
}
