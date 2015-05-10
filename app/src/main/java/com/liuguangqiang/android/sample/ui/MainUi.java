package com.liuguangqiang.android.sample.ui;


import com.liuguangqiang.android.mvp.BaseUi;

/**
 * Created by Eric on 15/5/8.
 */
public interface MainUi extends BaseUi<MainUiCallback> {

    void showHello(String HelloMVP);

    void setHelloText(String txt);

}
