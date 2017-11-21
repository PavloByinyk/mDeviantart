package com.example.android.mddeviantart.modules.third_fragment;

import com.example.android.mddeviantart.base_mvp.BaseModel;
import com.example.android.mddeviantart.modules.MyApplication;
import com.example.android.mddeviantart.modules.first_fragment.FirstFragmentModel;
import com.example.android.mddeviantart.pojo.response.ImagesResponse;
import com.example.android.mddeviantart.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by android on 11/21/17.
 */

public class ThirdFragmentModel extends BaseModel implements IThirdFragmentContract.IModel{



    private boolean hasMore = true;
    private int offset= 0;


    @Override
    public void requestLoadImages(final IRequestListener listener) {

        if(!hasMore){
            listener.onError("No more data");
            return;
        }

        observe(getmApiService().getPhotography(MyApplication.sharedPreferencesManager.getAuthResponse().getAccessToken(), offset, Constants.LIMIT_DOWNLOAD), new Callback<ImagesResponse>() {
            @Override
            public void onResponse(Call<ImagesResponse> call, Response<ImagesResponse> response) {
                if(response.isSuccessful()){
                    hasMore = response.body().isHasMore();
                    offset += 10;
                    listener.onSuccess(response.body());
                }else{
                    listener.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<ImagesResponse> call, Throwable t) {
                listener.onError(t.getMessage());

            }
        });



    }

    interface IRequestListener{
        void onSuccess(ImagesResponse response);
        void onError(String msg);
    }
}
