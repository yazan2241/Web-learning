package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class css_tag10 extends AppCompatActivity {
ImageView im1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_css_tag10);
        im1=findViewById(R.id.im1);

    }

    @SuppressLint("WrongConstant")
    public void hide(View view) {
        im1.setVisibility(0);

    }

    @SuppressLint("WrongConstant")
    public void remove(View view) {
        im1.setVisibility(1);
    }
}