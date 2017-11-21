package com.example.android.mddeviantart.modules.main_fragment;


import com.example.android.mddeviantart.base_mvp.BasePresenter;

public class ExampleFragmentPresenter extends BasePresenter<IExampleFragmentContract.IModel, IExampleFragmentContract.IView>
        implements IExampleFragmentContract.IPresenter{


    public ExampleFragmentPresenter(IExampleFragmentContract.IView mView) {
        super(mView);
    }

    @Override
    protected IExampleFragmentContract.IModel provideModel() {
        return new ExampleFragmentModel();
    }


    @Override
    public void onStart() {
        super.onStart();
    }

}
