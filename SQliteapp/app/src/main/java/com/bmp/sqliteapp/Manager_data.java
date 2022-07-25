package com.bmp.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class Manager_data extends AppCompatActivity {
    EditText txtmagname,txtmagprice,txtmagpage;
    Button btnEdit,btnDelete;
    Date currentTime = Calendar.getInstance().getTime();
//    String txtmagID = "23" + currentTime;
 myDatabase mydb = new myDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_data);
        txtmagname =findViewById(R.id.txtmagname);
        txtmagprice =findViewById(R.id.txtmagprice);
        txtmagpage =findViewById(R.id.txtnagpage);
        btnEdit =findViewById(R.id.btnedit);

        btnDelete =findViewById(R.id.btndelete);
        Intent bun =getIntent();
        String bid =bun.getStringExtra("bid");
        Cursor cur = mydb.SelectData(bid);
        if(cur !=null){
            if(cur.moveToFirst()){
                txtmagname.setText(cur.getString(1));
                txtmagprice.setText(cur.getString(2));
                txtmagpage.setText(cur.getString(3));

            }

        }
        cur.close();

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 long r =mydb.EditData(bid,
                                         txtmagname.getText().toString(),
                                       txtmagprice.getText().toString(),
                                      txtmagpage.getText().toString()) ;
                if(r>0){
                    Toast.makeText(Manager_data.this,"Edit Success",Toast.LENGTH_SHORT).show();
                    Intent i =new Intent(Manager_data.this,show_Data.class);
                    startActivity(i);
                }else{
                    Toast.makeText(Manager_data.this,"Edit Fail",Toast.LENGTH_SHORT).show();
                }

            }
        });
//       Toast.makeText(getApplicationContext(), " "+bid, Toast.LENGTH_SHORT).show();

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor r =mydb.Delete(bid
                );
                if(r == null){
                    Toast.makeText(Manager_data.this,"Delete Success",Toast.LENGTH_SHORT).show();
                    Intent i =new Intent(Manager_data.this,show_Data.class);
                    startActivity(i);
                }else{
                    Toast.makeText(Manager_data.this,"Delete Fail",Toast.LENGTH_SHORT).show();
                }
                
            }
        });

    }
}