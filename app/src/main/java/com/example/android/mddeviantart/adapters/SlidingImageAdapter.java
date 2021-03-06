package com.example.android.mddeviantart.adapters;


import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.android.mddeviantart.R;
import com.example.android.mddeviantart.pojo.response.images_data.MainImageData;

import java.util.List;

public class SlidingImageAdapter extends PagerAdapter {

    private List<MainImageData> list;
    private LayoutInflater inflater;
    private Context context;

    public SlidingImageAdapter(Context context, List<MainImageData> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View layout = inflater.inflate(R.layout.item_detail, view, false);

        assert layout != null;
        final ImageView ivMain = layout.findViewById(R.id.iv_main);
        final ImageView ivAuthor = layout.findViewById(R.id.iv_author);
        final TextView tvUserName = layout.findViewById(R.id.tv_author_name);
        final TextView tvUrl = layout.findViewById(R.id.tv_url);
        final TextView tvLikes = layout.findViewById(R.id.tv_image_likes);
        final TextView tvImageTitle = layout.findViewById(R.id.tv_image_title);

        MainImageData mainImageData = list.get(position);


        if (mainImageData.getContent() != null) {
            Glide.with(context)
                    .load(mainImageData.getContent().getSrc())
                    .apply(new RequestOptions().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background))
                    .into(ivMain);
        }

        if (mainImageData.getAuthor() != null) {
            Glide.with(context)
                    .load(mainImageData.getAuthor().getUsericon())
                    .apply(new RequestOptions().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background))
                    .into(ivAuthor);

            tvUserName.setText(mainImageData.getAuthor().getUsername());
        }

        tvUrl.setText(mainImageData.getUrl());
        tvLikes.setText(String.valueOf(mainImageData.getStats().getFavourites()));
        tvImageTitle.setText(mainImageData.getTitle());

        view.addView(layout, 0);

        return layout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }


}
