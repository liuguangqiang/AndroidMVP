package com.liuguangqiang.android.mvp.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.liuguangqiang.android.mvp.BaseUi;
import com.liuguangqiang.android.mvp.Presenter;

/**
 * Created by Eric on 15/5/11.
 */
public class MVPFragment extends Fragment {

    private Presenter presenter;
    private BaseUi baseUi;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
    public void onResume() {
        super.onResume();
        if (presenter != null && baseUi != null)
            presenter.attach(baseUi);
    }

    @Override
    public void onPause() {
        if (presenter != null && baseUi != null)
            presenter.detach(baseUi);
        super.onPause();
    }

}
