package com.damosdesigns.designlab.main;

import android.graphics.drawable.Drawable;

/**
 * Created by damosdesigns on 6/19/16.
 */
public class Project {
    private String Url;
    private Drawable mLogo;
    private String mTitle;
    //private DefinedAction

    public Project(String title){
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

    public void setmLogo(Drawable mLogo) {
        this.mLogo = mLogo;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }


}
