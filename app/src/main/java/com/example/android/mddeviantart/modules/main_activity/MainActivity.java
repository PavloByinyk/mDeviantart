package com.example.android.mddeviantart.modules.main_activity;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.example.android.mddeviantart.R;
import com.example.android.mddeviantart.adapters.SimpleFragmentPagerAdapter;
import com.example.android.mddeviantart.bases.BaseActivity;


public class MainActivity extends BaseActivity implements IMainActivityContract.IView {

    private IMainActivityContract.IPresenter mPresenter;

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private SimpleFragmentPagerAdapter adapter;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPresenter(new MainActivityPresenter(this));

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);

        mPresenter.onStart();
    }

    @Override
    public void setPresenter(IMainActivityContract.IPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onDestroy();
    }

    @Override
    public void initViews() {
        progressDialog = new ProgressDialog(this);
    }

    @Override
    public void initFragmentPager() {
        adapter = new SimpleFragmentPagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void showMsg(int msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar(boolean showProgress) {

        if(showProgress && !progressDialog.isShowing()){
            progressDialog.setMessage(getString(R.string.msg_authorization));
            progressDialog.show();
            progressDialog.setCancelable(false);
        }else if(!showProgress && progressDialog.isShowing()){
            progressDialog.cancel();
        }


    }
}
