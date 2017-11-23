package com.example.android.mddeviantart.modules.detail_activity;


import com.example.android.mddeviantart.base_mvp.BasePresenter;

class DetailActivityPresenter extends BasePresenter<IDetailActivityContract.IModel, IDetailActivityContract.IView>
        implements IDetailActivityContract.IPresenter {

    public DetailActivityPresenter(IDetailActivityContract.IView mView) {
        super(mView);
    }

    @Override
    protected IDetailActivityContract.IModel provideModel() {
        return new DetailActivityModel();
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
