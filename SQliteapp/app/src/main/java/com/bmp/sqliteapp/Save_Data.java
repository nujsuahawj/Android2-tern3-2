package com.bmp.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class Save_Data extends AppCompatActivity {
    EditText txtname,txtprice,txtpage;
    Button btnC,btnInsert;
    myDatabase mydb =new myDatabase(this);
    Date currentTime = Calendar.getInstance().getTime();
    String txtid = "23" + currentTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);
//        txtid =findViewById(R.id.txtbid);
        txtname =findViewById(R.id.txtbname);
        txtprice =findViewById(R.id.txtprice);
        txtpage =findViewById(R.id.txtpage);
        btnInsert =findViewById(R.id.btnInsert);
        btnC = findViewById(R.id.buttonclean);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long r =mydb.InsertData(txtid,
                                        txtname.getText().toString(),
                                        txtprice.getText().toString(),
                                        txtpage.getText().toString());
                if(r>0){

                    Toast.makeText(getApplicationContext(), "Save data complete", Toast.LENGTH_SHORT).show();
//                    txtid.;
                    txtname.setText("");
                    txtprice.setText("");
                    txtpage.setText("");
                }


            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Save_Data.this, MainActivity.class);
                Save_Data.this.finish();
                startActivity(intent);
            }
        });
    }
}