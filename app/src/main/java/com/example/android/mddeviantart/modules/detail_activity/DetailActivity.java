package com.example.android.mddeviantart.modules.detail_activity;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.android.mddeviantart.R;
import com.example.android.mddeviantart.adapters.SlidingImageAdapter;
import com.example.android.mddeviantart.bases.BaseActivity;
import com.example.android.mddeviantart.modules.default_fragment.DefaultFragment;
import com.example.android.mddeviantart.pojo.response.images_data.MainImageData;

import java.util.List;


public class DetailActivity extends BaseActivity implements IDetailActivityContract.IView {

    private IDetailActivityContract.IPresenter mPresenter;
    private  ViewPager mPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setPresenter(new DetailActivityPresenter(this));

        mPager =  findViewById(R.id.pager);

        List<MainImageData> list =  getIntent().getExtras().getParcelableArrayList(DefaultFragment.KEY_PASS_LIST);
        int  position =  getIntent().getExtras().getInt(DefaultFragment.KEY_PASS_POSITION);

        initPager(getResources().getConfiguration().orientation, list, position);
        mPresenter.onStart();
        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);

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

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void initPager(int orientation, List<MainImageData> list, int position){
        int padding = 0;
        int margin = 0;

        if(orientation ==  Configuration.ORIENTATION_LANDSCAPE){
            padding = getResources().getDimensionPixelOffset(R.dimen.padding_large);
            margin = getResources().getDimensionPixelOffset(R.dimen.margin_small);
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        }else if(orientation ==  Configuration.ORIENTATION_PORTRAIT) {
            padding = getResources().getDimensionPixelOffset(R.dimen.padding_large);
            margin = getResources().getDimensionPixelOffset(R.dimen.margin_big);
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
        mPager.setClipToPadding(false);
        mPager.setPadding(padding, 0, padding, 0);
        mPager.setPageMargin(margin);
        mPager.setAdapter(new SlidingImageAdapter(DetailActivity.this, list));
        mPager.setCurrentItem(position);
    }

}
