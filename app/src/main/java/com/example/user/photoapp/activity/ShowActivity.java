package com.example.user.photoapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.user.photoapp.R;
import com.squareup.picasso.Picasso;

public class ShowActivity extends AppCompatActivity {
    ImageView ivShow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_activity);
        ivShow=findViewById(R.id.iv_show);
        Intent i=getIntent();
        Bundle bd=i.getExtras();
        String link=bd.getString("link");

        Picasso.get().load(link).placeholder(R.drawable.img).error(R.drawable.img3).into(ivShow);
    }
}
