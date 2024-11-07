package com.example.user.photoapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.user.photoapp.R;

public class MainActivity extends AppCompatActivity {
    EditText etSearch;
    ImageButton ibSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSearch=findViewById(R.id.et_search_am);
        ibSearch=findViewById(R.id.ib_search_am);
        ibSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=etSearch.getText().toString();
                Intent i=new Intent(MainActivity.this,PhotoActivity.class);
                Bundle bd=new Bundle();
                bd.putString("search",str);
                i.putExtras(bd);
                startActivity(i);
            }
        });
    }
}
