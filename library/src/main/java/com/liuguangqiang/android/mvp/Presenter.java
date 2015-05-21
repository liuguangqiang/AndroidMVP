package com.liuguangqiang.android.mvp;

/**
 * Created by Eric on 15/5/8.
 */
public abstract class Presenter<U extends BaseUi<UC>, UC> {

    private OnUiAttachedListener onUiAttachedListener;

    private U mUi;

    public U getUi() {
        return mUi;
    }

    public void setOnUiAttachedListener(OnUiAttachedListener listener) {
        onUiAttachedListener = listener;
    }

    public boolean isAttachedUi() {
        return mUi != null;
    }

    public synchronized final void attach(U ui) {
        if (!isAttachedUi()) {
            checkArgument(ui);
            ui.setUiCallback(createUiCallback(ui));
            populateUi(ui);
            this.mUi = ui;
            onAttachedUi();
        }
    }

    public synchronized final void detach(U ui) {
        if (isAttachedUi()) {
            checkArgument(ui);
            ui.setUiCallback(null);
            this.mUi = null;
        }
    }

    protected abstract void populateUi(U ui);

    protected abstract UC createUiCallback(U ui);

    private void checkArgument(U ui) {
        if (ui == null)
            throw new IllegalArgumentException("Presenter can not attach or detach any null object!");
    }

    protected void onAttachedUi() {
        if (onUiAttachedListener != null) onUiAttachedListener.onAttachedUi();
    }

    public interface OnUiAttachedListener {

        void onAttachedUi();

    }

}
