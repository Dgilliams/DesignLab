package com.damosdesigns.designlab.main;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.damosdesigns.designlab.R;

/**
 * Created by damosdesigns on 6/19/16.
 */
public class PayMeFragment extends Fragment {
    private View mRoot;
    private Vibrator vibe;

    //Permission Utils
    private final int SMS_PERMISSION_REQUEST_CODE = 1;
    private final int CALL_PHONE_PERMISSION_REQUEST_CODE = 2;

    private boolean mHasSMSPermission = false;
    private boolean mHasCallPermission = false;

    private EditText mRequesterName;
    private EditText mCustomMessage;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mRoot = inflater.inflate(R.layout.pay_me_fragment, container, false);

        mRequesterName = (EditText) mRoot.findViewById(R.id.quote_requester_name);
        mCustomMessage = (EditText) mRoot.findViewById(R.id.quote_custom_message);

        FloatingActionButton venmo_fab = (FloatingActionButton) mRoot.findViewById(R.id.venmo_fab);
        venmo_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.openVenmo(getContext());
            }
        });

        FloatingActionButton phone_fab = (FloatingActionButton) mRoot.findViewById(R.id.phone_fab);
        phone_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibe.vibrate(500);
                checkPhoneCallPermission(getActivity());
                Util.dialNumber(getContext());

            }
        });
        FloatingActionButton linkedIn_fab = (FloatingActionButton) mRoot.findViewById(R.id.linkedin_fab);
        linkedIn_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibe.vibrate(500);
                Util.openLinkedIn(getContext());
            }
        });


        FloatingActionButton email_fab = (FloatingActionButton) mRoot.findViewById(R.id.email_fab);
        email_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibe.vibrate(500);
                Util.sendEmail(getContext());
            }
        });

        FloatingActionButton fab = (FloatingActionButton) mRoot.findViewById(R.id.request_quote_card_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibe = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibe.vibrate(500);
                checkSMSPermission(getActivity());
                if (mHasSMSPermission) {
                    if (mCustomMessage.getText().length() > 0) {
                        Util.sendSMS(getContext(), "7727131983", "Message: " + mCustomMessage.getText() + "\n\n From: " + mRequesterName.getText());
                    } else {
                        Util.sendSMS(getContext(), "7727131983", "Message: Dev Opportunity from that app you made. From: Anonymous");
                    }
                } else {
                    checkSMSPermission(getActivity());
                    Toast.makeText(getContext(), "Permission to send SMS is disabled. Re-enable it in settings.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mRequesterName.requestFocus();

        return mRoot;

    }


    private void checkPhoneCallPermission(Activity activity) {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(activity,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.CALL_PHONE)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.CALL_PHONE},
                        CALL_PHONE_PERMISSION_REQUEST_CODE);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            mHasCallPermission = true;
        }
    }

    private void checkSMSPermission(Activity activity) {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(activity,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.SEND_SMS)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.SEND_SMS},
                        SMS_PERMISSION_REQUEST_CODE);

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.SEND_SMS},
                        SMS_PERMISSION_REQUEST_CODE);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            mHasSMSPermission = true;
        }
    }
}
