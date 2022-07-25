package com.example.mysql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.*;
import java.util.ArrayList;

public class Show_data extends AppCompatActivity {
     Button btnshow;
     ListView lstV;
     TextView tvinfo;
     ArrayList arrname = new ArrayList();
     ArrayList arrid = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data2);
        btnshow = findViewById(R.id.btnshowdeltail);
        lstV = findViewById(R.id.listV);
        tvinfo = findViewById(R.id.tvshowdata);

        lstV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
             String str = arrid.get(i).toString();
                Intent obj = new Intent(Show_data.this,Manage_data.class);
                obj.putExtra("id",str);
                startActivity(obj);
            }
        });


        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new getData().execute("");
            }
        });

    }
    private class getData extends AsyncTask<String,String,String>{
        ArrayAdapter<String> adt;
        String msg="";
        @Override
        protected void onPreExecute() {
            tvinfo.setText("Please waiting");
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                Connection c = DBConnect.getConnect();
                ModelFriend f = new ModelFriend(c);
                ResultSet rs  = f.SelectData();
                arrid.clear();
                while(rs.next()) {
                    arrid.add(rs.getString("id"));
                    arrname.add(rs.getString("fname"));
                }
                rs.close();
            } catch (Exception ex) {
                msg="Can not load data";
            }

            return msg;
        }

        @Override
        protected void onPostExecute(String s) {
            adt = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,arrname);
            lstV.setAdapter(adt);
            tvinfo.setText(s);

        }
    }
}