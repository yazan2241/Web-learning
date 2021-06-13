package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void startHTML(View view) {
        Intent intent = new Intent(this, HTML.class);

        startActivity(intent);
    }

    public void startCSS(View view) {
        Intent intent = new Intent(this, CSS.class);

        startActivity(intent);
    }

    public void startJavaScript(View view) {
    }


    public void startFinalQuiz(View view) {

        Intent intent = new Intent(this, finalQuiz.class);
        startActivity(intent);

    }
}
