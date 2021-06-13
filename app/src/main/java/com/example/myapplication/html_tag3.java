package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class html_tag3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html_tag3);
        TextView t66=findViewById(R.id.t66);
        t66.setText("HTML links are defined with the <a> tag. The link address is specified in the href attribute:");
    }
}
