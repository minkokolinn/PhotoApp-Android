package com.example.user.photoapp.mvp.data.model;

import com.example.user.photoapp.networks.ApiService;
import com.example.user.photoapp.utils.AppConstant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseModel {
    protected ApiService api;

    BaseModel(){
        creatingApi();
    }
    private void creatingApi(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(AppConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api=retrofit.create(ApiService.class);
    }
}
