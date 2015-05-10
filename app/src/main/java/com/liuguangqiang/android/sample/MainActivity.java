package com.liuguangqiang.android.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.liuguangqiang.android.mvp.Presenter;
import com.liuguangqiang.android.sample.presenter.MainPresenter;
import com.liuguangqiang.android.sample.ui.MainUi;
import com.liuguangqiang.android.sample.ui.MainUiCallback;


public class MainActivity extends ActionBarActivity implements MainUi, View.OnClickListener {

    private Button btnTest;
    private TextView tvTest;

    Presenter mPresenter;
    MainUiCallback mCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainPresenter();
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test:
                mCallback.printHello();
                break;
        }
    }

    private void initView() {
        btnTest = (Button) findViewById(R.id.btn_test);
        tvTest = (TextView) findViewById(R.id.tv_test);
        btnTest.setOnClickListener(this);
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

    @Override
    public void setHelloText(String txt) {
        tvTest.setText(txt);
    }
}
