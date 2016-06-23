package com.damosdesigns.designlab.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.damosdesigns.designlab.R;

/**
 * Created by damosdesigns on 6/19/16.
 */
public class Project {
    private String Url;
    private Drawable mLogo;
    private String mTitle;
    private String mID;


    public String getmID() {
        return mID;
    }

    public void setmID(String mID) {
        this.mID = mID;
    }


    public Project(String title, String id) {
        mID = id;
        mTitle = title;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public Drawable getmLogo() {
        return mLogo;
    }

    public void setmLogo(Context context, int  mLogo) {
        this.mLogo = ContextCompat.getDrawable(context, mLogo);
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }


}
