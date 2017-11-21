package com.example.android.mddeviantart.adapters;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.mddeviantart.R;
import com.example.android.mddeviantart.modules.default_fragment.DefaultFragment;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return DefaultFragment.newInstance(R.string.label_fragment_hot);
        } else if (position == 1){
            return DefaultFragment.newInstance(R.string.label_fragment_likes);
        } else {
            return DefaultFragment.newInstance(R.string.label_fragment_photos);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.label_fragment_hot);
            case 1:
                return mContext.getString(R.string.label_fragment_likes);
            case 2:
                return mContext.getString(R.string.label_fragment_photos);
            default:
                return null;
        }
    }

}
