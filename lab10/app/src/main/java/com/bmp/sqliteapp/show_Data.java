package com.bmp.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class show_Data extends AppCompatActivity {
    ListView listView;
    ArrayList<String> bid=new ArrayList<String>();
    ArrayList<String> bname =new ArrayList<String>();
    ArrayAdapter<String> adpt=null;
    myDatabase mydb= new myDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        listView =findViewById(R.id.lstv);
        Cursor cursor = mydb.SelectAllData();
        bid.clear();
        bname.clear();
        if(cursor !=null){
            if(cursor.moveToFirst()){
                do{
                    bid.add(cursor.getString(0));
                    bname.add(cursor.getString(1));



                }while (cursor.moveToNext());

            }
        }
        cursor.close();
        adpt =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,bname);
       listView.setAdapter(adpt);
      listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              String str=bid.get(position).toString();
              Intent intent = new Intent(show_Data.this,Manager_data.class);
              intent.putExtra("bid",bid.get(position));
              show_Data.this.finish();
              startActivity(intent);

             // Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
          }
      });



    }
}