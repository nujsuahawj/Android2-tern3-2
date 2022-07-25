package com.bmp.mysqlapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.bmp.mysqlapp.DB.DBConnect;
import com.bmp.mysqlapp.Model.ModelBook;

import java.sql.*;
import java.util.ArrayList;

public class SelectDataActivity extends AppCompatActivity {
    TextView tv;
    Button btnshow;
    ListView lstv;
    ArrayList<String> arrid =new ArrayList<String>();
    ArrayList<String> arrname =new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_data);
        tv =findViewById(R.id.tv);
        btnshow =findViewById(R.id.btnShow);
        lstv =findViewById(R.id.lstv);
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getData().execute("");
            }
        });

    }
    private class getData extends AsyncTask<String,String,String>{
        String smg="";
        ArrayAdapter<String> apt;

        @Override
        protected void onPreExecute() {
           tv.setText("Please wait....");
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                Connection c = DBConnect.getConnect();
                ModelBook mb=new ModelBook(c);
                ResultSet rs =mb.SelectData();
                arrid.clear();
                arrname.clear();
                while (rs.next()){
                    arrid.add(rs.getString("bid"));
                    arrname.add(rs.getString("name"));
                }
                rs.close();




            }catch (Exception ex){
                smg="Can not load data...";

            }

            return smg;
        }

        @Override
        protected void onPostExecute(String s) {
            apt =new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,arrname);
            lstv.setAdapter(apt);
            tv.setText(s);





        }
    }

}