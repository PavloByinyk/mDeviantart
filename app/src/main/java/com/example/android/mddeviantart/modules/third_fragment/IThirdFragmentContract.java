package com.example.android.mddeviantart.modules.third_fragment;


import com.example.android.mddeviantart.base_mvp.IBaseModel;
import com.example.android.mddeviantart.base_mvp.IBasePresenter;
import com.example.android.mddeviantart.base_mvp.IBaseView;
import com.example.android.mddeviantart.modules.first_fragment.FirstFragmentModel;
import com.example.android.mddeviantart.modules.first_fragment.IFirstFragmentContract;
import com.example.android.mddeviantart.pojo.response.images_data.MainImageData;

import java.util.List;

public interface IThirdFragmentContract {

    interface IView extends IBaseView<IPresenter> {
        void initViews();
        void showMsg(int msg);
        void showMsg(String msg);
        void setListToAdapter(List<MainImageData> list);
    }

    interface IPresenter extends IBasePresenter {
        void getMoreImages();
    }

    interface IModel extends IBaseModel {
        void requestLoadImages(ThirdFragmentModel.IRequestListener listener);
    }

}