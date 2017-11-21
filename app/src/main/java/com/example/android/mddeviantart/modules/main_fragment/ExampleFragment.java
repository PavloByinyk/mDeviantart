package com.example.android.mddeviantart.modules.main_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.android.mddeviantart.bases.BaseFragment;


public class ExampleFragment extends BaseFragment implements IExampleFragmentContract.IView{

    private IExampleFragmentContract.IPresenter mPresenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setPresenter(new ExampleFragmentPresenter(this));
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void setPresenter(IExampleFragmentContract.IPresenter presenter) {
        mPresenter = presenter;
    }
}
