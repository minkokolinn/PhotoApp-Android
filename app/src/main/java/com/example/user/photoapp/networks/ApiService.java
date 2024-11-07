package com.example.user.photoapp.networks;


import com.example.user.photoapp.mvp.data.vo.MyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/")
    Call<MyResponse> getPhoto(@Query("key")String key,@Query("q")String word);
}
