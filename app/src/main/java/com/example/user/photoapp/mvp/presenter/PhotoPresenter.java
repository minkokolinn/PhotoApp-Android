package com.example.user.photoapp.mvp.presenter;

import com.example.user.photoapp.delegate.PhotoDelegate;
import com.example.user.photoapp.mvp.data.vo.Hits;

import java.util.List;

public interface PhotoPresenter extends PhotoDelegate {
    void displayDataToView(List<Hits> hits);
    void displayErrorToView(String str);
    void diplayLoadingToView();
    void hideLoadingToView();
    void loadData(String str);
}
