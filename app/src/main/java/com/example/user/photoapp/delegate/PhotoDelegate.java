package com.example.user.photoapp.delegate;

import com.example.user.photoapp.mvp.data.vo.Hits;

public interface PhotoDelegate {
    void onPhotoClick(Hits hits);
}
