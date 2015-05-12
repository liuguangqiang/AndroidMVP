package com.liuguangqiang.android.sample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.liuguangqiang.android.mvp.BaseUi;
import com.liuguangqiang.android.mvp.Presenter;
import com.liuguangqiang.android.mvp.app.MVPActivity;
import com.liuguangqiang.android.sample.presenter.MainPresenter;
import com.liuguangqiang.android.sample.ui.MainUi;
import com.liuguangqiang.android.sample.ui.MainUiCallback;

public class MainActivity extends MVPActivity implements MainUi, View.OnClickListener {

    private Button btnSignIn;
    private EditText etUserName;
    private EditText etPassword;

    private MainUiCallback mCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public Presenter setPresenter() {
        return new MainPresenter();
    }

    @Override
    public BaseUi setUi() {
        return this;
    }

    @Override
    public void setUiCallback(MainUiCallback callback) {
        mCallback = callback;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sign:
                mCallback.login(etUserName.getText().toString(), etPassword.getText().toString());
                break;
        }
    }

    private void initView() {
        btnSignIn = (Button) findViewById(R.id.btn_sign);
        btnSignIn.setOnClickListener(this);
        etUserName = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
    }

    @Override
    public void showHello(String HelloMVP) {
        Toast.makeText(getApplicationContext(), HelloMVP, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showSignSuccess(String txt) {
        Toast.makeText(getApplicationContext(), txt, Toast.LENGTH_LONG).show();
    }
}
