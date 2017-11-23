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

public class DefaultFragment extends BaseFragment implements IDefaultFragmentContract.IView, MainImageAdapter.MainImageClickListener, SwipeRefreshLayout.OnRefreshListener {


    public static final String FRAGMENT_TAG = "fragment_tag";
    public static final String KEY_PASS_LIST = "key_pass_list";
    public static final String KEY_PASS_POSITION = "key_pass_position";
    public static final String KEY_LAST_VISIBLE_ITEM = "key_last_visible_item";
    public static final String KEY_SAVED_LIST = "key_saved_list";
    public static final String KEY_OFFSET = "key_offset";

    private int myTag;
    private int mScrollPosition = -1;

    private IDefaultFragmentContract.IPresenter mPresenter;
    private RecyclerView recyclerView;
    private MainImageAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;


    public static DefaultFragment newInstance(int myTag) {
        Bundle args = new Bundle();
        args.putInt(FRAGMENT_TAG, myTag);
        DefaultFragment fragment = new DefaultFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myTag = getArguments().getInt(FRAGMENT_TAG);
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.onDestroy();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_images);
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);

        setPresenter(new DefaultFragmentPresenter(this));
        mPresenter.onStart();

        if (savedInstanceState == null) {
            mPresenter.getImages(myTag);
        }
        setRetainInstance(true);
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int scrollPosition = ((GridLayoutManager) recyclerView.getLayoutManager())
                .findFirstCompletelyVisibleItemPosition();
        bundle.putInt(KEY_OFFSET, mPresenter.getOffset());
        bundle.putParcelableArrayList(KEY_SAVED_LIST, (ArrayList<? extends Parcelable>) adapter.getList());
        bundle.putInt(KEY_LAST_VISIBLE_ITEM, scrollPosition);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            mPresenter.setOffset(bundle.getInt(KEY_OFFSET));
            adapter.setList(bundle.<MainImageData>getParcelableArrayList(KEY_SAVED_LIST));
            mScrollPosition = bundle.getInt(KEY_LAST_VISIBLE_ITEM);
            recyclerView.scrollToPosition(mScrollPosition);
        }
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
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }


    @Override
    public void onImageClick(List<MainImageData> list, int position) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putParcelableArrayListExtra(KEY_PASS_LIST, (ArrayList<? extends Parcelable>) list);
        intent.putExtra(KEY_PASS_POSITION, position);
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        mPresenter.getImages(myTag);
    }
}
