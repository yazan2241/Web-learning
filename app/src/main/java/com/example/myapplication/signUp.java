package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class signUp extends AppCompatActivity {
    private EditText Bname,Mname,Fname,Uname,Password,Email,Mnumber;
    private String bName,mName,fName,uName,password,email,mNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Bname=findViewById(R.id.babyName);
        Mname=findViewById(R.id.babymother);
        Fname=findViewById(R.id.babyFather);
        Uname=findViewById(R.id.username);
        Password=findViewById(R.id.password);
        Email=findViewById(R.id.email);
        Mnumber=findViewById(R.id.mobileNumber);
    }

    public void signUp(View view) {
        bName=Bname.getText().toString();
        mName=Mname.getText().toString();
        fName= Fname.getText().toString();
        uName=Uname.getText().toString();
        password=Password.getText().toString();
        email=Email.getText().toString();
        mNumber=Mnumber.getText().toString();
        new SigninActivity(this,bName,mName,fName,uName,password,email,mNumber).execute();
    }

    private class SigninActivity extends AsyncTask<String,String,String> {


        private Context context;
        public String result;
        private String bName,mName,fName,uName,password,email,mNumber;


        public SigninActivity(Context context,String bName,String mName,String fName,String uName,String password,String email,String mNumber) {
            this.context = context;


            this.bName = bName;
            this.mName = mName;

            this.fName=fName;
            this.uName=uName;
            this.password=password;
            this.email=email;
            this.mNumber=mNumber;

        }

        @Override
        protected String doInBackground(String... strings) {


                try{
                    //  String username = (String)arg0[0];
                    // String password = (String)arg0[1];

                    String link = "";
                    String data="";
                        link = "https://c-store.000webhostapp.com/sellerRegister.php";
                        data = URLEncoder.encode("bName", "UTF-8") + "=" +
                                URLEncoder.encode(bName, "UTF-8");
                        data += "&" + URLEncoder.encode("mName", "UTF-8") + "=" +
                                URLEncoder.encode(mName, "UTF-8");
                        data += "&" + URLEncoder.encode("fName", "UTF-8") + "=" +
                                URLEncoder.encode(String.valueOf(fName), "UTF-8");
                        data += "&" + URLEncoder.encode("uName", "UTF-8") + "=" +
                                URLEncoder.encode(String.valueOf(uName), "UTF-8");
                        data += "&" + URLEncoder.encode("password", "UTF-8") + "=" +
                                URLEncoder.encode(password, "UTF-8");
                        data += "&" + URLEncoder.encode("email", "UTF-8") + "=" +
                                URLEncoder.encode(email, "UTF-8");
                    data += "&" + URLEncoder.encode("mNumber", "UTF-8") + "=" +
                            URLEncoder.encode(mNumber, "UTF-8");



                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();

                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                    wr.write( data );
                    wr.flush();

                    BufferedReader reader = new BufferedReader(new
                            InputStreamReader(conn.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    // Read Server Response
                    while((line = reader.readLine()) != null) {
                        sb.append(line);
                        break;
                    }

                    return sb.toString();
                } catch(Exception e){
                    return new String("Exception: " + e.getMessage());
                }

            }

        @Override
        public void onPostExecute(String result2) {
            super.onPostExecute(result2);
            System.out.println("json" + result2);
            goToNextPage();
        }
    }
    public  void goToNextPage(){
        Intent intent = new Intent(this, HTML.class);
        startActivity(intent);
    }





}