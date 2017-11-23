package com.example.android.mddeviantart.remote;


public class ApiUtils {

    public static final String BASE_URL = "https://www.deviantart.com/";

    public static RetrofitService getRetrofitService() {
        return getRetrofitService(false);
    }

    public static RetrofitService getRetrofitService(boolean recreate) {
        return RetrofitClient.getClient(BASE_URL, recreate).create(RetrofitService.class);
    }
}