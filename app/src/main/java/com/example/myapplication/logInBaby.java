package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

public class logInBaby extends AppCompatActivity {
    EditText email,pass;
    String emailStr,passStr;
    public String userName,userPicture,userEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_baby);
    }

    public void logIn(View view) {


        email = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        emailStr = email.getText().toString();
        passStr = pass.getText().toString();
        new SigninActivity(this, emailStr, passStr).execute(emailStr, passStr);
    }
    private class SigninActivity extends AsyncTask<String, String, String> {
       // private String statusField;
       // private String roleField;
        private Context context;
        public String result;
      //  public String userName, userPicture, userEmail;
        // private String companyName,companyHeadName,companyEmail,companyPassword;
        // private int companyNumber,companyPhone;
        private String emailStr, passStr;
      ///  private int byGetOrPost = 0, page;

        public SigninActivity(Context context,  String email, String pass) {
            this.context = context;
            this.emailStr = email;
            this.passStr = pass;
        }

        @Override
        protected String doInBackground(String... strings) {

                try {
                    //  String username = (String)arg0[0];
                    // String password = (String)arg0[1];
                    String link = "";
                    String data = "";

                        link = "https://c-store.000webhostapp.com/index.php";
                        data = URLEncoder.encode("username", "UTF-8") + "=" +
                                URLEncoder.encode(emailStr, "UTF-8");
                        data += "&" + URLEncoder.encode("password", "UTF-8") + "=" +
                                URLEncoder.encode(passStr, "UTF-8");

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
           Toast.makeText(getApplicationContext(),emailStr,Toast.LENGTH_LONG).show();
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

    userName = jsonObject.getString("userName");
    userPicture = jsonObject.getString("passsword");
    //   userEmail = jsonObject.getString("email");
    goToNextPage();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            break;
                        }


                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),"email or password is wrong",Toast.LENGTH_SHORT).show();
                    }
            result = result2;
        }
        }

        public void goToNextPage(){
            Intent intent = new Intent(this, HTML.class);
            startActivity(intent);
        }
    }