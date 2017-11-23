package com.example.android.mddeviantart.remote;

import com.example.android.mddeviantart.pojo.response.AuthResponse;
import com.example.android.mddeviantart.pojo.response.ImagesResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by android on 11/15/17.
 */

public interface RetrofitService {

    @GET("oauth2/token?grant_type=client_credentials")
    Call<AuthResponse> auth(@Query("client_id") int id, @Query("client_secret") String secretKey);

    @GET("api/v1/oauth2/browse/hot?offset=[offset]&limit=[limit]&access_token=[access_token]")
    Call<ImagesResponse> getHot(@Query("access_token") String token, @Query("offset") int offset, @Query("limit") int limit);

    @GET("api/v1/oauth2/browse/morelikethis?seed=C0801604-7894-532E-BC8F-C4EE47273E6D&category=photography&limit=[limit]&access_token=[access_token]")
    Call<ImagesResponse> getLightnings(@Query("access_token") String token, @Query("offset") int offset, @Query("limit") int limit);

    @GET("api/v1/oauth2/browse/popular?category_path=photography&q=clouds&timerange=1week&limit=[limit]&access_token=[access_token]")
    Call<ImagesResponse> getPhotography(@Query("access_token") String token, @Query("offset") int offset, @Query("limit") int limit);

}
