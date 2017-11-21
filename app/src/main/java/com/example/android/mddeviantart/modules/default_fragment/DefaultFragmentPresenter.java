package com.example.android.mddeviantart.modules.default_fragment;


import com.example.android.mddeviantart.R;
import com.example.android.mddeviantart.base_mvp.BasePresenter;
import com.example.android.mddeviantart.pojo.response.ImagesResponse;

public class DefaultFragmentPresenter extends BasePresenter<IDefaultFragmentContract.IModel, IDefaultFragmentContract.IView>
        implements IDefaultFragmentContract.IPresenter, DefaultFragmentModel.IRequestListener{


    public DefaultFragmentPresenter(IDefaultFragmentContract.IView mView) {
        super(mView);
    }

    @Override
    protected IDefaultFragmentContract.IModel provideModel() {
        return new DefaultFragmentModel();
    }


    @Override
    public void onStart() {
        super.onStart();
        getView().initViews();
        //getModel().requestLoadImages(this);
    }


    @Override
    public void onSuccess(ImagesResponse response) {
        getView().showMsg(R.string.msg_success);
        getView().setListToAdapter(response.getResults());
        ImagesResponse response1 = response;
    }

    @Override
    public void onError(String msg) {
        getView().showMsg(msg);
    }

    @Override
    public void getImages(int tag) {
        getModel().requestLoadImages(this, tag);
    }

}