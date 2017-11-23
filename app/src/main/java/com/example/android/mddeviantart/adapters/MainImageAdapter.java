package com.example.android.mddeviantart.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.android.mddeviantart.R;
import com.example.android.mddeviantart.pojo.response.images_data.MainImageData;

import java.util.ArrayList;
import java.util.List;

public class MainImageAdapter extends RecyclerView.Adapter<MainImageAdapter.ImageHolder> {

    private Context context;
    private MainImageClickListener listener;
    private List<MainImageData> list;

    public interface MainImageClickListener {
        void onImageClick(List<MainImageData> imageData, int position);
    }


    public MainImageAdapter(Context context, MainImageClickListener listener) {
        this.context = context;
        this.listener = listener;
    }

    @Override
    public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_image, parent, false);
        return new ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        if (this.list == null) {
            return 0;
        } else {
            return list.size();
        }
    }

    public void setList(List<MainImageData> list) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public List<MainImageData> getList() {
        return this.list;
    }

    public class ImageHolder extends RecyclerView.ViewHolder {

        private ImageView ivImage;


        private ImageHolder(View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_image);
        }

        public void bind(final MainImageData mainImageData) {

            if (mainImageData.getContent() != null) {
                Glide.with(context)
                        .load(mainImageData.getContent().getSrc())
                        .apply(new RequestOptions().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background))
                        .into(ivImage);
            } else {
                ivImage.setImageResource(R.drawable.ic_launcher_background);
            }

            ivImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onImageClick(list, list.indexOf(mainImageData));
                }
            });
        }
    }
}
