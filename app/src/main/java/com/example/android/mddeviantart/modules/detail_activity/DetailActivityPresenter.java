package com.example.android.mddeviantart.modules.detail_activity;


import com.example.android.mddeviantart.R;
import com.example.android.mddeviantart.base_mvp.BasePresenter;

class DetailActivityPresenter extends BasePresenter<IDetailActivityContract.IModel, IDetailActivityContract.IView>
        implements IDetailActivityContract.IPresenter, DetailActivityModel.IRequestListener{


    // Constructor
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
//        getView().initViews();
//        getView().showProgressBar(true);
//        getModel().requestAuth(this);
    }


    @Override
    public void onSuccess() {
//        getView().showProgressBar(false);
//        getView().showMsg(R.string.msg_success);
//        getView().initFragmentPager();
    }

    @Override
    public void onError(String msg) {
//        getView().showProgressBar(false);
//        getView().showMsg(msg);
    }

}
