package com.example.mysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.*;

public class save_data extends AppCompatActivity {
    EditText txtname,txtsurname,txttel;
    Button btnOk,btnCancel;
    TextView tvdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);
        txtname = findViewById(R.id.txtname);
        txtsurname = findViewById(R.id.txtsurname);
        txttel = findViewById(R.id.txttel);
        tvdata = findViewById(R.id.tvshowdata);
        btnOk = findViewById(R.id.btn_save);
        btnCancel = findViewById(R.id.btn_cancel);
  btnOk.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
         new myData().execute("");
      }
  });
  btnCancel.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          txtname.setText("");
          txtsurname.setText("");
          txttel.setText("");
      }
  });


    }

    private class myData extends AsyncTask<String,String,String> {
        String msg="";
        String name= txtname.getText().toString();
        String surname= txtsurname.getText().toString();
        String tel= txttel.getText().toString();
        @Override
        protected void onPreExecute() {
            tvdata.setText("Please wait to inserting data");
        }

        @Override
        protected String doInBackground(String... strings) {
          try {
              Connection c = DBConnect.getConnect();
              ModelFriend f = new ModelFriend(c);
              f.setName(name);
              f.setSurname(surname);
              f.setTel(tel);
              int r =f.InsertData();
              if(r>0) {
                  msg="inserting data compelete";
              } else {
                  msg="Can't no save data";
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
            return msg;
        }
        @Override
        protected void onPostExecute(String s) {
            tvdata.setText(s);
            txtname.setText("");
            txtsurname.setText("");
            txttel.setText("");
            txtname.requestFocus();
        }

    }
}