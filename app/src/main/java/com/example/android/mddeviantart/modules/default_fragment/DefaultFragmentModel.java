package com.example.android.mddeviantart.modules.default_fragment;

import com.example.android.mddeviantart.R;
import com.example.android.mddeviantart.base_mvp.BaseModel;
import com.example.android.mddeviantart.modules.MyApplication;
import com.example.android.mddeviantart.pojo.response.ImagesResponse;
import com.example.android.mddeviantart.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DefaultFragmentModel extends BaseModel implements IDefaultFragmentContract.IModel {

    private boolean hasMore = true;
    private int offset = 0;

    @Override
    public void requestLoadImages(final IRequestListener listener, int tag) {

        if (!hasMore) {
            listener.onError("No more data");
            return;
        }

        Call<ImagesResponse> call = null;

        switch (tag) {
            case R.string.label_fragment_hot:
                call = getmApiService().getHot(MyApplication.sharedPreferencesManager.getAuthResponse().getAccessToken(), offset, Constants.LIMIT_DOWNLOAD);
                break;
            case R.string.label_fragment_lightning:
                call = getmApiService().getLightnings(MyApplication.sharedPreferencesManager.getAuthResponse().getAccessToken(), offset, Constants.LIMIT_DOWNLOAD);
                break;
            case R.string.label_fragment_photos:
                call = getmApiService().getPhotography(MyApplication.sharedPreferencesManager.getAuthResponse().getAccessToken(), offset, Constants.LIMIT_DOWNLOAD);
                break;
        }

        observe(call, new Callback<ImagesResponse>() {
            @Override
            public void onResponse(Call<ImagesResponse> call, Response<ImagesResponse> response) {

                if (response.isSuccessful()) {
                    hasMore = response.body().isHasMore();
                    offset += Constants.OFFSET_DOWNLOAD;
                    listener.onSuccess(response.body());
                } else {
                    listener.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<ImagesResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    @Override
    public int getOffset() {
        return offset;
    }

    @Override
    public void setOffset(int offset) {
        this.offset = offset;
    }

    interface IRequestListener {
        void onSuccess(ImagesResponse response);

        void onError(String msg);
    }
}
