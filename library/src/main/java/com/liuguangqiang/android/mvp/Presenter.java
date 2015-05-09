package com.liuguangqiang.android.mvp;

/**
 * Created by Eric on 15/5/8.
 */
public abstract class Presenter<U extends BaseUi<UC>, UC> {

    public synchronized final void attach(U ui) {
        checkArgument(ui);

        ui.setUiCallback(createUiCallback(ui));
        populateUi(ui);
    }

    public synchronized final void detach(U ui) {
        checkArgument(ui);

        ui.setUiCallback(createUiCallback(ui));
    }

    protected abstract void populateUi(U ui);

    protected abstract UC createUiCallback(U ui);

    private void checkArgument(U ui) {
        if (ui == null) throw new IllegalArgumentException("ui can not be null");
    }

}
