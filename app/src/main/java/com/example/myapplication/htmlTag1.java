package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class htmlTag1 extends AppCompatActivity {
TextView t,t1,t2;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html_tag1);
        String pid=getIntent().getStringExtra("product_id");
t=findViewById(R.id.t55);
t.setText("!DOCTYPE html>\n" +
        "<html>\n" +
        "<head>\n" +
        "<title>Page Title</title>\n" +
        "</head>\n" +
        "<body>\n" +
        "<h1>My First Heading</h1>\n" +
        "<p>My first paragraph.</p>\n" +
        "\n" +
        "</body>\n" +
        "</html> ");
        t1=findViewById(R.id.t2);
        t1.setText("<tagname>content goes here...</tagname> ");
        t2=findViewById(R.id.t3);
        t2.setText(" HTML tags normally come in pairs like <p> and </p>\n" +
                "        The first tag in a pair is the start tag, the second tag is the end tag\n" +
                "        The end tag is written like the start tag,\nbut with a forward slash inserted before the tag name  ");

    }

    public void BeginQuiz(View view) {
        Intent i=new Intent(this,quiz.class);
        startActivity(i);
    }
}
