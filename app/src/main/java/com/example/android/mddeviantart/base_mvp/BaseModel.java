package com.example.android.mddeviantart.base_mvp;


import com.example.android.mddeviantart.remote.ApiUtils;
import com.example.android.mddeviantart.remote.RetrofitService;

import java.util.HashSet;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;


public class BaseModel implements IBaseModel {

    private RetrofitService mApiService;
    private Set<Call<?>> mRequestsRegistry = new HashSet<>();

    @Override
    public void init() {
        mApiService = ApiUtils.getRetrofitService();
    }

    @Override
    public void onDestroy() {

        for (Call call : mRequestsRegistry) {
            if (!call.isCanceled() && !call.isExecuted()) {
                call.cancel();
            }
        }
    }

    public <T> void observe(Call<T> call, Callback<T> callback) {
        mRequestsRegistry.add(call);
        call.enqueue(callback);
    }

    public RetrofitService getmApiService() {
        return mApiService;
    }
}

