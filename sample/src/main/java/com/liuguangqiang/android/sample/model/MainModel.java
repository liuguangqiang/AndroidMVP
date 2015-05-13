package com.liuguangqiang.android.sample.model;

import javax.inject.Inject;

/**
 * Created by Eric on 15/5/8.
 */
public class MainModel {

    @Inject
    public MainModel() {

    }

    public String getShowHello() {
        return "Hi! I am MVP.";
    }

    public String getSuccessTxt() {
        return "congratulations! Login successful!";
    }


}