package com.example.user.photoapp.mvp.view;

import com.example.user.photoapp.mvp.data.vo.Hits;

import java.util.List;

public interface PhotoView {
    void displayLoading();
    void hideLoading();
    void displayData(List<Hits> hits);
    void displayError(String str);
    void displayNoInternet();
    void displayInternet();
    void goToAnotherPage(String str);
}
