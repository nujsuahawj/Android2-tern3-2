package com.example.mysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import java.sql.*;
public class activity_show_data extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        tv = findViewById(R.id.tv);
        new mytask().execute("");
    }
    private class mytask extends AsyncTask<String,String,String> {
        String msg="";

        @Override
        protected void onPreExecute() {
            tv.setText("Please waiting to connection to DB");
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                Connection con;
                con =DBConnect.getConnect();
                if(con !=null) {
                    msg="Done...";
//                    String query = "INSERT INTO tb_friends (fname,fsurname,tel) VALUES(?,?,?)";

                }else if(con ==null) {
                    msg="Fail...";


                }

            }catch (Exception ex){
                msg="Connection fail...";
            }



            return msg;
        }

        @Override
        protected void onPostExecute(String s) {
            tv.setText(s);
        }
    }
}