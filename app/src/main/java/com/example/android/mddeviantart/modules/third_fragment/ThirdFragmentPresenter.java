package com.example.android.mddeviantart.modules.third_fragment;


import com.example.android.mddeviantart.R;
import com.example.android.mddeviantart.base_mvp.BasePresenter;
import com.example.android.mddeviantart.pojo.response.ImagesResponse;

public class ThirdFragmentPresenter extends BasePresenter<IThirdFragmentContract.IModel, IThirdFragmentContract.IView>
        implements IThirdFragmentContract.IPresenter, ThirdFragmentModel.IRequestListener{


    public ThirdFragmentPresenter(IThirdFragmentContract.IView mView) {
        super(mView);
    }

    @Override
    protected IThirdFragmentContract.IModel provideModel() {
        return new ThirdFragmentModel();
    }


    @Override
    public void onStart() {
        super.onStart();
        getView().initViews();
        getModel().requestLoadImages(this);
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
    public void getMoreImages() {
        getModel().requestLoadImages(this);
    }

}