package com.example.android.mddeviantart.modules.third_fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.android.mddeviantart.R;
import com.example.android.mddeviantart.adapters.MainImageAdapter;
import com.example.android.mddeviantart.bases.BaseFragment;
import com.example.android.mddeviantart.pojo.response.images_data.MainImageData;

import java.util.List;

public class ThirdFragment extends BaseFragment implements IThirdFragmentContract.IView, MainImageAdapter.MainImageClickListener, SwipeRefreshLayout.OnRefreshListener{

    private IThirdFragmentContract.IPresenter mPresenter;

    private RecyclerView recyclerView;
    private MainImageAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_images);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);

        setPresenter(new ThirdFragmentPresenter(this));
        mPresenter.onStart();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_defoult;
    }

    @Override
    public void setPresenter(IThirdFragmentContract.IPresenter presenter) {
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



    @Override
    public void onImageClick(MainImageData imageData) {

    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        mPresenter.getMoreImages();
    }
}
