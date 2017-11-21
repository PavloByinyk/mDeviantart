package com.example.android.mddeviantart.modules.first_fragment;


import com.example.android.mddeviantart.R;
import com.example.android.mddeviantart.base_mvp.BaseModel;
import com.example.android.mddeviantart.modules.MyApplication;
import com.example.android.mddeviantart.pojo.response.ImagesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * : BaseModel() , IBuyContract.IModel
 */

public class FirstFragmentModel extends BaseModel implements IFirstFragmentContract.IModel{


    private boolean hasMore = true;
    private int offset= 0;


    @Override
    public void requestLoadImages(final IRequestListener listener) {

        if(!hasMore){
            listener.onError("No more data");
            return;
        }

        observe(getmApiService().getHot(MyApplication.sharedPreferencesManager.getAuthResponse().getAccessToken(), offset), new Callback<ImagesResponse>() {
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
