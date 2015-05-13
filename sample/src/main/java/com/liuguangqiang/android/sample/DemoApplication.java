package com.liuguangqiang.android.sample;

import android.app.Application;
import android.content.Context;

import com.liuguangqiang.android.sample.module.AppModule;

import dagger.ObjectGraph;

/**
 * Created by Eric on 15/5/13.
 */
public class DemoApplication extends Application {

    private ObjectGraph objectGraph;

    public static DemoApplication from(Context context) {
        return (DemoApplication) context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        createObjectGraph();
    }

    private void createObjectGraph() {
        objectGraph = ObjectGraph.create(
                AppModule.class
        );
        objectGraph.inject(this);
    }

    public void inject(Object object) {
        objectGraph.inject(object);
    }

}
