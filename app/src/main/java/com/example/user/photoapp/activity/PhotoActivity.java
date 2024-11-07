package com.example.user.photoapp.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.user.photoapp.adapters.PhotoAdapter;
import com.example.user.photoapp.R;
import com.example.user.photoapp.mvp.data.vo.Hits;
import com.example.user.photoapp.mvp.presenter.PhotoPresenter;
import com.example.user.photoapp.mvp.presenter.PhotoPresenterImpl;
import com.example.user.photoapp.mvp.view.PhotoView;

import java.util.List;

public class PhotoActivity extends AppCompatActivity implements PhotoView {
    RecyclerView rv;
    Button btnRetry;
    ProgressDialog pd;
    PhotoPresenter pp;
    LinearLayout llNoInternet;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_activity);
        rv=findViewById(R.id.rv_photo_pa);
        btnRetry=findViewById(R.id.btn_retry_pa);
        llNoInternet=findViewById(R.id.ll_noInternet);
        rv.setLayoutManager(new LinearLayoutManager(PhotoActivity.this));
        Intent i=getIntent();
        Bundle bd=i.getExtras();
        final String word=bd.getString("search");

        pd=new ProgressDialog(this);
        pd.setTitle("Loading....");

        pp=new PhotoPresenterImpl(this,this);
        pp.loadData(word);

        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pp.loadData(word);
            }
        });
    }

    @Override
    public void displayLoading() {
        pd.show();
    }

    @Override
    public void hideLoading() {
        if(pd.isShowing()){
            pd.dismiss();
        }
    }

    @Override
    public void displayData(List<Hits> hits) {
        PhotoAdapter adapter=new PhotoAdapter(PhotoActivity.this,hits);
        rv.setAdapter(adapter);
        adapter.onPhotoClick(pp);
    }

    @Override
    public void displayError(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayNoInternet() {
        llNoInternet.setVisibility(View.VISIBLE);
        rv.setVisibility(View.GONE);
    }

    @Override
    public void displayInternet() {
        llNoInternet.setVisibility(View.GONE);
        rv.setVisibility(View.VISIBLE);
    }

    @Override
    public void goToAnotherPage(String str) {
        Intent i=new Intent(PhotoActivity.this,ShowActivity.class);
        Bundle bd=new Bundle();
        bd.putString("link",str);
        i.putExtras(bd);
        startActivity(i);
    }
}
