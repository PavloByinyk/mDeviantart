package com.example.android.mddeviantart.modules.main_activity;


import com.example.android.mddeviantart.R;
import com.example.android.mddeviantart.base_mvp.BasePresenter;

class MainActivityPresenter extends BasePresenter<IMainActivityContract.IModel, IMainActivityContract.IView>
        implements IMainActivityContract.IPresenter, MainActivityModel.IRequestListener{


    // Constructor
    public MainActivityPresenter(IMainActivityContract.IView mView) {
        super(mView);
    }



    @Override
    protected IMainActivityContract.IModel provideModel() {
        return new MainActivityModel();
    }



    @Override
    public void onStart() {
        super.onStart();
        getView().initViews();

        if(getModel().isUserAuth()){
            getView().initFragmentPager();
            return;
        }else {
            getView().showProgressBar(true);
            getModel().requestAuth(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //getModel().clearSharedPref();
    }

    @Override
    public void onSuccess() {
        getView().showProgressBar(false);
        getView().showMsg(R.string.msg_success);
        getView().initFragmentPager();
    }

    @Override
    public void onError(String msg) {
        getView().showProgressBar(false);
        getView().showMsg(msg);
    }

}
