package com.liuguangqiang.android.mvp;

import java.util.List;

/**
 * Created by Eric on 15/5/19.
 */
public interface BaseRequestUi<T, UC> extends BaseUi<UC> {

    void requestSuccess(List<T> result);

    void requestFinished();

}
