package com.example.android.mddeviantart.base_mvp;

public abstract class BasePresenter<M extends IBaseModel, V extends IBaseView<? extends IBasePresenter>> implements IBasePresenter {

    private M mModel = null;
    private V mView;


    protected abstract M provideModel();

    public BasePresenter(V mView) {
        this.mView = mView;
    }

    @Override
    public void onStart() {
        lazyInitModel();
        mModel.init();
    }

    @Override
    public void onDestroy() {
        lazyInitModel();
        mModel.onDestroy();
    }


    private void lazyInitModel() {

        if (mModel == null) {
            synchronized (this) {
                if (mModel == null) {
                    mModel = provideModel();
                }
            }
        }
    }

    public M getModel() {
        lazyInitModel();
        return mModel;
    }

    public V getView() {
        return mView;
    }
}
