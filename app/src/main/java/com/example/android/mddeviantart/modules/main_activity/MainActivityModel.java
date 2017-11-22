package com.example.android.mddeviantart.modules.main_activity;


import com.example.android.mddeviantart.base_mvp.BaseModel;
import com.example.android.mddeviantart.modules.MyApplication;
import com.example.android.mddeviantart.pojo.response.AuthResponse;
import com.example.android.mddeviantart.utils.Constants;
import com.google.gson.Gson;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * BaseModel() , IBuyContract.IModel
 */

public class MainActivityModel extends BaseModel implements IMainActivityContract.IModel {


    @Override
    public void requestAuth(final IRequestListener listener) {

        observe(getmApiService().auth(Constants.CLIENT_ID, Constants.CLIENT_SECRET), new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                if(response.isSuccessful()){
                    MyApplication.sharedPreferencesManager.saveAuthResponse(new Gson().toJson(response.body()));
                    listener.onSuccess();

                }else {
                    listener.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {

                listener.onError(t.getMessage());
            }
        });
    }

    @Override
    public boolean isUserAuth() {
        if(MyApplication.sharedPreferencesManager.getAuthResponse() != null){
            return true;
        }else {
            return false;
        }
    }

//    @Override
//    public void clearSharedPref() {
//        MyApplication.sharedPreferencesManager.clearAllData();
//    }

    interface IRequestListener{
        void onSuccess();
        void onError(String msg);
    }

}
