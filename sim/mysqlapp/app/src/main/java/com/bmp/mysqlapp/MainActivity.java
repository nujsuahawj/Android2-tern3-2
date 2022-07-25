package com.bmp.mysqlapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bmp.mysqlapp.DB.DBConnect;

import java.sql.*;

public class MainActivity extends AppCompatActivity {
    Button btnsave,btnselect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsave =findViewById(R.id.btnSave);
        btnselect=findViewById(R.id.btnSelect);
        btnselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,SelectDataActivity.class);
                startActivity(intent);
            }
        });



    }


}