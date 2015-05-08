package com.liuguangqiang.android.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.liuguangqiang.android.sample.presenter.MainPresenter;
import com.liuguangqiang.android.sample.ui.MainUi;
import com.liuguangqiang.android.sample.ui.MainUiCallback;


public class MainActivity extends ActionBarActivity implements MainUi {

    Presenter mPresenter;
    MainUiCallback mCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainPresenter();
    }

    @Override
    public void setUiCallback(MainUiCallback callback) {
        mCallback = callback;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.attach(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.detach(this);
    }

    @Override
    public void showHello(String HelloMVP) {
        Toast.makeText(getApplicationContext(), HelloMVP, Toast.LENGTH_LONG).show();
    }

}
