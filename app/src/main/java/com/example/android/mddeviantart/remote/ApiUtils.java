package com.example.android.mddeviantart.remote;



public class ApiUtils {

    public static final String BASE_URL = "https://www.deviantart.com/";
    public static final String ACCESS_TOKEN = "cfb54ccc40f9c6f58afd759c5dfa2202905daa8f681ecde23d";


//    public static final String X_AUTH_TOKEN = "x-auth-token";
//
//    public static final String PAYMENT_BASE_URL = "https://sbpaymentservices.payfort.com/FortAPI/paymentApi";

    public static RetrofitService getRetrofitService() {
        return getRetrofitService(false);
    }

    public static RetrofitService getRetrofitService(boolean recreate) {
        return RetrofitClient.getClient(BASE_URL, recreate).create(RetrofitService.class);
    }
}