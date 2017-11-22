package com.example.android.mddeviantart.adapters;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.android.mddeviantart.R;
import com.example.android.mddeviantart.modules.default_fragment.DefaultFragment;

import java.util.ArrayList;
import java.util.List;

public class SimpleFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private Context mContext;
    private FragmentManager fm;
    private List<DefaultFragment> fragmentsList = new ArrayList<>();

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
        this.fm = fm;
    }

    @Override
    public Fragment getItem(int position) {
            return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.label_fragment_hot);
            case 1:
                return mContext.getString(R.string.label_fragment_lightning);
            case 2:
                return mContext.getString(R.string.label_fragment_photos);
            default:
                return null;
        }
    }

    public void addFragment(DefaultFragment fragment){
        fragmentsList.add(fragment);
    }

}
