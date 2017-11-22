package com.example.android.mddeviantart.modules.detail_activity;


import com.example.android.mddeviantart.base_mvp.IBaseModel;
import com.example.android.mddeviantart.base_mvp.IBasePresenter;
import com.example.android.mddeviantart.base_mvp.IBaseView;

/**
 * Created by android on 11/15/17.
 */

public interface IDetailActivityContract {

    interface IView extends IBaseView<IPresenter> {
    }

    interface IPresenter extends IBasePresenter {
    }

    interface IModel extends IBaseModel {
    }
}
