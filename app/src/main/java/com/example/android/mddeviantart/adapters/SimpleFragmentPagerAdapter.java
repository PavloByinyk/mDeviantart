package com.example.android.mddeviantart.adapters;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.mddeviantart.R;
import com.example.android.mddeviantart.modules.first_fragment.FirstFragment;
import com.example.android.mddeviantart.modules.second_fragment.SecondFragment;
import com.example.android.mddeviantart.modules.third_fragment.ThirdFragment;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new FirstFragment();
        } else if (position == 1){
            return new SecondFragment();
        } else {
            return new ThirdFragment();
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 3;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.label_fragment_first);
            case 1:
                return mContext.getString(R.string.label_fragment_second);
            case 2:
                return mContext.getString(R.string.label_fragment_third);
            default:
                return null;
        }
    }

}
