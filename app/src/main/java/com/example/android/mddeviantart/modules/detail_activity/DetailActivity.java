package com.example.android.mddeviantart.modules.detail_activity;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.example.android.mddeviantart.R;
import com.example.android.mddeviantart.adapters.MainImageAdapter;
import com.example.android.mddeviantart.adapters.SimpleFragmentPagerAdapter;
import com.example.android.mddeviantart.adapters.SlidingImageAdapter;
import com.example.android.mddeviantart.bases.BaseActivity;
import com.example.android.mddeviantart.modules.default_fragment.DefaultFragment;
import com.example.android.mddeviantart.pojo.response.images_data.MainImageData;

import java.util.List;

import static com.example.android.mddeviantart.modules.default_fragment.DefaultFragment.KEY_MAINIMAGEDATA_PASS;


public class DetailActivity extends BaseActivity implements IDetailActivityContract.IView {

    private IDetailActivityContract.IPresenter mPresenter;

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private SimpleFragmentPagerAdapter adapter;
    private ProgressDialog progressDialog;


    private static ViewPager mPager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setPresenter(new DetailActivityPresenter(this));

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        mPager = (ViewPager) findViewById(R.id.pager);



        List<MainImageData> list =  getIntent().getExtras().getParcelableArrayList(DefaultFragment.KEY_MAINIMAGEDATA_PASS);

        mPager.setAdapter(new SlidingImageAdapter(DetailActivity.this,list));
        mPager.setCurrentItem(4);

        mPresenter.onStart();
    }

    @Override
    public void setPresenter(IDetailActivityContract.IPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onDestroy();
    }

//    @Override
//    public void initViews() {
//        progressDialog = new ProgressDialog(this);
//    }
//
//    @Override
//    public void initFragmentPager() {
//        adapter = new SimpleFragmentPagerAdapter(this, getSupportFragmentManager());
//        viewPager.setAdapter(adapter);
//        tabLayout.setupWithViewPager(viewPager);
//    }
//
//    @Override
//    public void showMsg(int msg) {
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void showMsg(String msg) {
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void showProgressBar(boolean showProgress) {
//
//        if(showProgress && !progressDialog.isShowing()){
//            progressDialog.setMessage(getString(R.string.msg_authorization));
//            progressDialog.show();
//            progressDialog.setCancelable(false);
//        }else if(!showProgress && progressDialog.isShowing()){
//            progressDialog.cancel();
//        }
//
//
//    }
}
