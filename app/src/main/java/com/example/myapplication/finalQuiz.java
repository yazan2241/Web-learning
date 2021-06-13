package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class finalQuiz extends AppCompatActivity {
    TextView tv;
   int q1=0;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;

    String questions[];
    String answers[];
    String opt[];

    TextView textView;
    int q[] ;
    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        questions = new String[8];
        answers = new String[8];
        opt = new String[32];
        q=new int[8];
        setContentView(R.layout.activity_final_quiz);

      //  if(q1==0)
        logIn();
      //  else
          //  startQuiz();
    }

    public void logIn() {
        new SigninActivity(this).execute();
    }

    private class SigninActivity extends AsyncTask<String, String, String> {
        // private String statusField;
        // private String roleField;
        private Context context;
        public String result;
        //  public String userName, userPicture, userEmail;
        // private String companyName,companyHeadName,companyEmail,companyPassword;
        // private int companyNumber,companyPhone;
        // private String emailStr, passStr;
        ///  private int byGetOrPost = 0, page;

        public SigninActivity(Context context) {
            this.context = context;
            // this.emailStr = email;
            // this.passStr = pass;
        }

        @Override
        protected String doInBackground(String... strings) {

            try {
                //  String username = (String)arg0[0];
                // String password = (String)arg0[1];
                String link = "";
                String data = "";

                link = "https://yazanlearning.000webhostapp.com/question.php";


                URL url = new URL(link);
                URLConnection conn = url.openConnection();

                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                wr.write(data);
                wr.flush();

                BufferedReader reader = new BufferedReader(new
                        InputStreamReader(conn.getInputStream()));

                StringBuilder sb = new StringBuilder();
                String line = null;

                // Read Server Response
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                    break;
                }

                return sb.toString();
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }


        }


        @Override
        public void onPostExecute(String result2) {
            super.onPostExecute(result2);
            System.out.println("json" + result2);
            // Toast.makeText(getApplicationContext(),emailStr,Toast.LENGTH_LONG).show();
            //  goToNextPage();
            // System.out.println(result2);
            String s = "";
            JSONArray JArray = null;

            try {

                //JArray=object.getJSONArray("");
                JArray = new JSONArray(result2);

                for (int i = 0; i < JArray.length(); i++) {
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = JArray.getJSONObject(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    try {

                        questions[i] = jsonObject.getString("question");

                        opt[i * 4] = jsonObject.getString("ans1");
                        opt[i * 4+1] = jsonObject.getString("ans2");
                        opt[i * 4+2] = jsonObject.getString("ans3");
                        opt[i * 4+3] = jsonObject.getString("ans4");

                        answers[i] = jsonObject.getString("ans");
                        q[q1]=q1;
                         q1++;

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                  //  break;
                }


            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
                Intent i=new Intent(finalQuiz.this,MainActivity.class);
                startActivity(i);
            }
            result = result2;
            startQuiz();
        }
    }

    void startQuiz() {
        final TextView score;
        score = (TextView) findViewById(R.id.textView4);
        textView = (TextView) findViewById(R.id.DispName);

        submitbutton = (Button) findViewById(R.id.button3);
        quitbutton = (Button) findViewById(R.id.buttonquit);
        tv = (TextView) findViewById(R.id.tvque);

        radio_g = (RadioGroup) findViewById(R.id.answersgrp);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);
        textView.setText("Question" + q[flag]);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if (ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText("" + correct);

                if (flag < questions.length) {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag * 4]);
                    rb2.setText(opt[flag * 4 + 1]);
                    rb3.setText(opt[flag * 4 + 2]);
                    rb4.setText(opt[flag * 4 + 3]);
                } else {
                    marks = correct;
                    Intent in = new Intent(getApplicationContext(), ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                startActivity(intent);
            }
        });
    }
}