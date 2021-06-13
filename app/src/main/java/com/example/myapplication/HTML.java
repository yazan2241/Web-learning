package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import adapter.Home_Adapter;
import modelclass.Home_Model;

public class HTML extends AppCompatActivity implements RecyclerViewClickListener {
    private RecyclerView recyclerView;
    private Home_Adapter home_adapter;
    private ArrayList<Home_Model> home_model;
    RecyclerView myRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
int ppid=0;
    int[] imageshose = new int[]{R.drawable.download3, R.drawable.firebase_lockup_400, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};
    int[] iamgequiz = new int[]{R.drawable.ic_launcher_background, R.drawable.firebase_lockup_400, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};
    int[] imageTopic = new int[]{R.drawable.ic_launcher_background, R.drawable.firebase_lockup_400, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};
    String[] name = new String[]{"HTML introduction", "name2", "name3", "name5", "name9", "name8"};
    String[] quiz = new String[]{"quiz1", "quiz2", "quiz3", "name3", "name3", "name3"};
    String[] topiv = new String[]{"topic1", "topiv2", "topic3", "name3", "name3", "name3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_t_m_l);
        // price =new String[60];
        // desc=new String[60];
        // imageshose=new String[60];
        // productId=new int[60];
        Button startbutton=(Button)findViewById(R.id.startButton);
        recyclerView = findViewById(R.id.my_recyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(HTML.this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        home_model = new ArrayList<>();

        for (int j = 0; j < imageshose.length; j++) {
            Home_Model ab = new Home_Model(imageshose[j], iamgequiz[j], imageTopic[j], name[j], quiz[j], topiv[j], j);
            home_model.add(ab);
        }

        home_adapter = new Home_Adapter(HTML.this, this, home_model);
        recyclerView.setAdapter(home_adapter);

        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),QuestionsActivity.class);

                startActivity(intent);
            }
        });
    }

    @Override
    public void recyclerViewListClicked(int s) {
        goToNextPage(s);
    }


    public void goToNextPage(int ppid) {
        if (ppid == 0) {
            Intent intent = new Intent(this, html_tag5.class);
            intent.putExtra("product_id", ppid);
            startActivity(intent);
        }
        if(ppid==1){
            Intent intent = new Intent(this, html_tag6.class);
            intent.putExtra("product_id", ppid);
            startActivity(intent);
        }
        if (ppid == 2) {
            Intent intent = new Intent(this, html_tag8.class);
            intent.putExtra("product_id", ppid);
            startActivity(intent);
        }
        if(ppid==3){
            Intent intent = new Intent(this, html_tag10.class);
            intent.putExtra("product_id", ppid);
            startActivity(intent);
        }
        if (ppid == 4) {
            Intent intent = new Intent(this, html_tag11.class);
            intent.putExtra("product_id", ppid);
            startActivity(intent);
        }
        if(ppid==5){
            Intent intent = new Intent(this, html_tag5.class);
            intent.putExtra("product_id", ppid);
            startActivity(intent);
        }
    }

}