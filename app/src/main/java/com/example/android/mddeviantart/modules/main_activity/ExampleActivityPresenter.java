package com.example.android.mddeviantart.modules.main_activity;


import com.example.android.mddeviantart.base_mvp.BasePresenter;

class ExampleActivityPresenter extends BasePresenter<IExampleActivityContract.IModel, IExampleActivityContract.IView>
        implements IExampleActivityContract.IPresenter, ExampleActivityModel.IRequestListener{


    // Constructor
    public ExampleActivityPresenter(IExampleActivityContract.IView mView) {
        super(mView);
    }



    @Override
    protected IExampleActivityContract.IModel provideModel() {
        return new ExampleActivityModel();
    }



    @Override
    public void onStart() {
        super.onStart();
        //Call start method for views here

    }



    // Callbacks from model
    @Override
    public void onSuccess(String response) {
    }

    @Override
    public void onError(String msg) {
    }

}
