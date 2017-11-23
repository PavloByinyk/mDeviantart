package com.example.android.mddeviantart.remote;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {


    private static Retrofit retrofit = null;


    public static Retrofit getClient(String baseUrl, boolean recreate) {

        if (retrofit == null || recreate) {

            OkHttpClient defaultHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new TokenInterceptor())
                    .readTimeout(18, TimeUnit.SECONDS)
                    .connectTimeout(18, TimeUnit.SECONDS)
                    .build();

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(defaultHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

        }
        return retrofit;
    }

    private static class TokenInterceptor implements Interceptor {

        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();

            Request.Builder builder = request.newBuilder();
            builder.addHeader("Accept", "application/json");

            return chain.proceed(builder.build());
        }
    }

}