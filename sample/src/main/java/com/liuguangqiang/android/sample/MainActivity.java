package com.liuguangqiang.android.sample;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.liuguangqiang.android.mvp.BaseUi;
import com.liuguangqiang.android.mvp.Presenter;
import com.liuguangqiang.android.mvp.app.MVPActivity;
import com.liuguangqiang.android.sample.presenter.MainPresenter;
import com.liuguangqiang.android.sample.ui.MainUi;
import com.liuguangqiang.android.sample.ui.MainUiCallback;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends MVPActivity implements MainUi {

    @InjectView(R.id.et_username)
    EditText etUserName;

    @InjectView(R.id.et_password)
    EditText etPassword;

    private MainUiCallback mCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @Override
    public Presenter setPresenter() {
        return new MainPresenter(getApplicationContext());
    }

    @Override
    public BaseUi setUi() {
        return this;
    }

    @Override
    public void setUiCallback(MainUiCallback callback) {
        mCallback = callback;
    }

    @OnClick(R.id.btn_sign)
    public void onClickLogin() {
        mCallback.login(etUserName.getText().toString(), etPassword.getText().toString());
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
