package com.damosdesigns.designlab.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

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
                Snackbar.make(findViewById(R.id.content_dev4_hire), "Check for SMS Permission", Snackbar.LENGTH_LONG);
                PermissionUtils.checkForSEND_SMSPermission(mActivity);
            }
        });
    }
}
