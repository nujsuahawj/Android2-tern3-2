package com.bmp.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Manager_data extends AppCompatActivity {
    EditText txtmagID,txtmagname,txtmagprice,txtmagpage;
    Button btnEdit,btnDelete;
 myDatabase mydb = new myDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_data);
        txtmagID =findViewById(R.id.txtmagID);
        txtmagname =findViewById(R.id.txtmagname);
        txtmagprice =findViewById(R.id.txtmagprice);
        txtmagpage =findViewById(R.id.txtnagpage);
        btnEdit =findViewById(R.id.btnedit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long r =mydb.EditData(txtmagID.getText().toString(),
                                        txtmagname.getText().toString(),
                                      txtmagprice.getText().toString(),
                                     txtmagpage.getText().toString()) ;
                if(r==1){
                    Toast.makeText(getApplicationContext(), "EDit Data Complete", Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(Manager_data.this,show_Data.class);
                    Manager_data.this.finish();
                    startActivity(intent);
                }

            }
        });
        btnDelete =findViewById(R.id.btndelete);
        Intent bun =getIntent();
        String bid =bun.getStringExtra("bid");
        Cursor cur = mydb.SelectData(bid);
        if(cur !=null){
            if(cur.moveToFirst()){
                txtmagID.setText(cur.getString(0));
                txtmagname.setText(cur.getString(1));
                txtmagprice.setText(cur.getString(2));
                txtmagpage.setText(cur.getString(3));

            }

        }
        cur.close();
       // Toast.makeText(getApplicationContext(), " "+bid, Toast.LENGTH_SHORT).show();

    }
}