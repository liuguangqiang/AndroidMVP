package com.liuguangqiang.android.sample.module;

import com.liuguangqiang.android.sample.DemoApplication;
import com.liuguangqiang.android.sample.presenter.MainPresenter;

import dagger.Module;

/**
 * Created by Eric on 15/5/14.
 */
@Module(
        injects = {
                DemoApplication.class,
                MainPresenter.class
        }
)
public class AppModule {
}
