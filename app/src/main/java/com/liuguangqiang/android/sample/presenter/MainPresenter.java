package com.liuguangqiang.android.sample.presenter;

import com.liuguangqiang.android.mvp.Presenter;
import com.liuguangqiang.android.sample.model.MainModel;
import com.liuguangqiang.android.sample.ui.MainUi;
import com.liuguangqiang.android.sample.ui.MainUiCallback;

/**
 * Created by Eric on 15/5/8.
 */
public class MainPresenter extends Presenter<MainUi, MainUiCallback> {

    private MainModel mMainModel;

    public MainPresenter() {
        mMainModel = new MainModel();
    }

    @Override
    protected void populateUi(MainUi ui) {
        ui.showHello(mMainModel.getShowHello());
    }

    @Override
    protected MainUiCallback createUiCallback(final MainUi ui) {
        return new MainUiCallback() {
            @Override
            public void login(String username, String password) {
                //TODO login
                ui.showSignSuccess(mMainModel.getSuccessTxt());
            }
        };
    }

}
