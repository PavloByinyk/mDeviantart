package com.example.android.mddeviantart.modules.main_activity;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.android.mddeviantart.R;
import com.example.android.mddeviantart.bases.BaseActivity;


public class ExampleActivity extends BaseActivity implements IExampleActivityContract.IView {

    private IExampleActivityContract.IPresenter mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_example);
        setPresenter(new ExampleActivityPresenter(this));
        mPresenter.onStart();
    }

    @Override
    public void setPresenter(IExampleActivityContract.IPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onDestroy();
    }

}
