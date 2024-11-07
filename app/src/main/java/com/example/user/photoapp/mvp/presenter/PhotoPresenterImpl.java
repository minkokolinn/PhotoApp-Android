package com.example.user.photoapp.mvp.presenter;

import android.content.Context;

import com.example.user.photoapp.mvp.data.model.PhotoModel;
import com.example.user.photoapp.mvp.data.vo.Hits;
import com.example.user.photoapp.mvp.view.PhotoView;
import com.example.user.photoapp.utils.AppUtils;

import java.util.List;

public class PhotoPresenterImpl implements PhotoPresenter{
    PhotoView pv;
    Context ctxt;

    public PhotoPresenterImpl(PhotoView pv, Context ctxt) {
        this.pv = pv;
        this.ctxt = ctxt;
    }

    @Override
    public void displayDataToView(List<Hits> hits) {
        pv.displayData(hits);
    }

    @Override
    public void displayErrorToView(String str) {
        pv.displayError(str);
    }

    @Override
    public void diplayLoadingToView() {
        pv.displayLoading();
    }

    @Override
    public void hideLoadingToView() {
        pv.hideLoading();
    }


    @Override
    public void loadData(String str) {
        if(AppUtils.isInternet(ctxt)){
            pv.displayInternet();
            PhotoModel pm=PhotoModel.getIns();
            pm.getPhoto(str,this);
        }else {
            pv.displayNoInternet();
        }

    }


    @Override
    public void onPhotoClick(Hits hits) {
        pv.goToAnotherPage(hits.getWebformatURL());
    }
}
