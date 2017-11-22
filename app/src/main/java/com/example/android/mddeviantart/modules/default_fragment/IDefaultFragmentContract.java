package com.example.android.mddeviantart.modules.default_fragment;


import com.example.android.mddeviantart.base_mvp.IBaseModel;
import com.example.android.mddeviantart.base_mvp.IBasePresenter;
import com.example.android.mddeviantart.base_mvp.IBaseView;
import com.example.android.mddeviantart.pojo.response.images_data.MainImageData;

import java.util.List;

public interface IDefaultFragmentContract {

    interface IView extends IBaseView<IPresenter> {
        void initViews();
        void showMsg(int msg);
        void showMsg(String msg);
        void setListToAdapter(List<MainImageData> list);
//        void updateOffset(int offset);
//        int getOffset();
    }

    interface IPresenter extends IBasePresenter {
        void getImages(int tag);
        void setOffset(int offset);
        int getOffset();
    }

    interface IModel extends IBaseModel {
        void requestLoadImages(DefaultFragmentModel.IRequestListener listener, int tag);
        void setOffset(int offset);
        int getOffset();
    }

}