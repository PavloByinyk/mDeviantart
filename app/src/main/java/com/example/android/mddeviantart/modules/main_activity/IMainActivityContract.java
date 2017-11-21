package com.example.android.mddeviantart.modules.main_activity;


import android.support.annotation.IdRes;

import com.example.android.mddeviantart.base_mvp.IBaseModel;
import com.example.android.mddeviantart.base_mvp.IBasePresenter;
import com.example.android.mddeviantart.base_mvp.IBaseView;

/**
 * Created by android on 11/15/17.
 */

public interface IMainActivityContract {

    interface IView extends IBaseView<IPresenter> {

        void initViews();
        void initFragmentPager();
        void showMsg(int msg);
        void showMsg(String msg);
        void showProgressBar(boolean showProgress);

    }

    interface IPresenter extends IBasePresenter {
    }

    interface IModel extends IBaseModel {
        void requestAuth(MainActivityModel.IRequestListener listener);

    }


}
