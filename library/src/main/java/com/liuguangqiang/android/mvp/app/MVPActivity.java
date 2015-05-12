package com.liuguangqiang.android.mvp.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.liuguangqiang.android.mvp.BaseUi;
import com.liuguangqiang.android.mvp.Presenter;

/**
 * Created by Eric on 15/5/11.
 */
public class MVPActivity extends ActionBarActivity {

    private Presenter presenter;
    private BaseUi baseUi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = setPresenter();
        baseUi = setUi();
    }

    public Presenter setPresenter() {
        return null;
    }

    public BaseUi setUi() {
        return null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter != null && baseUi != null)
            presenter.attach(baseUi);
    }

    @Override
    protected void onPause() {
        if (presenter != null && baseUi != null)
            presenter.detach(baseUi);
        super.onPause();
    }
    
}
