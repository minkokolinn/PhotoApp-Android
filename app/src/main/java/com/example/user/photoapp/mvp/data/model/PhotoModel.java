package com.example.user.photoapp.mvp.data.model;

import com.example.user.photoapp.mvp.data.vo.MyResponse;
import com.example.user.photoapp.mvp.presenter.PhotoPresenter;
import com.example.user.photoapp.utils.AppConstant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoModel extends BaseModel{
    private static PhotoModel Ins;

    public static PhotoModel getIns(){
        if (Ins==null){
            Ins=new PhotoModel();
        }
        return Ins;
    }

    private PhotoModel(){
        super();
    }

    public void getPhoto(String str, final PhotoPresenter presenter ){
        presenter.diplayLoadingToView();
        api.getPhoto(AppConstant.KEY,str).enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                presenter.hideLoadingToView();
                if(response.isSuccessful()){
                    presenter.displayDataToView(response.body().getHits());
                }

            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {
                presenter.hideLoadingToView();
                presenter.displayErrorToView(t.getMessage());
            }
        });
    }
}
