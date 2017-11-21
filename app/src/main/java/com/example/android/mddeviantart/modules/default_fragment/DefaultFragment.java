package com.example.android.mddeviantart.modules.default_fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.android.mddeviantart.R;
import com.example.android.mddeviantart.adapters.MainImageAdapter;
import com.example.android.mddeviantart.bases.BaseFragment;
import com.example.android.mddeviantart.modules.detail_activity.DetailActivity;
import com.example.android.mddeviantart.pojo.response.images_data.MainImageData;

import java.util.ArrayList;
import java.util.List;

public class DefaultFragment extends BaseFragment implements IDefaultFragmentContract.IView, MainImageAdapter.MainImageClickListener, SwipeRefreshLayout.OnRefreshListener{


    public static final String FRAGMENT_TAG = "fragment_tag";
    public static final String KEY_MAINIMAGEDATA_PASS = "main_image_data";
    private int tag;

    private IDefaultFragmentContract.IPresenter mPresenter;

    private RecyclerView recyclerView;
    private MainImageAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;


    public static DefaultFragment newInstance(int tag) {
        Bundle args = new Bundle();
        args.putInt(FRAGMENT_TAG, tag);
        DefaultFragment fragment = new DefaultFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tag = getArguments().getInt(FRAGMENT_TAG);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_images);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);

        setPresenter(new DefaultFragmentPresenter(this));
        mPresenter.onStart();
        mPresenter.getImages(tag);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_defoult;
    }

    @Override
    public void setPresenter(IDefaultFragmentContract.IPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void initViews() {

        adapter = new MainImageAdapter(getActivity(), this);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.setOnRefreshListener(this);
    }


    @Override
    public void showMsg(int msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setListToAdapter(List<MainImageData> list) {
        adapter.setList(list);
        if(swipeRefreshLayout.isRefreshing()){
            swipeRefreshLayout.setRefreshing(false);
        }
    }

//    @Override
//    public void onImageClick(MainImageData imageData) {
//        Toast.makeText(getActivity(), imageData.getTitle(), Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(getActivity(), DetailActivity.class);
//        intent.putExtra(KEY_MAINIMAGEDATA_PASS, imageData);
//        startActivity(intent);
//    }

    @Override
    public void onImageClick(List<MainImageData> list) {
        //Toast.makeText(getActivity(), imageData.getTitle(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putParcelableArrayListExtra(KEY_MAINIMAGEDATA_PASS, (ArrayList<? extends Parcelable>) list);
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        mPresenter.getImages(tag);
    }
}
