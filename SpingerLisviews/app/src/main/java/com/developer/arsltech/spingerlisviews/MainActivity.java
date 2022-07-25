package com.developer.arsltech.spingerlisviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String [] itm={"Computers","Camera","Mobile Phone"};
    String [][] arr={new String[]{"Acer","HP","Dell","Samsung"},
            new String[]{"Canon","Sonny","Casio","Nikon","Fuji","Panasonic"},
            new String[]{"iPhone","Samsung","VIVO","Huawei","OPPO"}
    };

    Spinner spn;
    ListView list;
    ArrayAdapter<String> adptspn=null;
    ArrayAdapter<String> adptlist=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn =findViewById(R.id.spinner);
        list =findViewById(R.id.listView);



        adptspn =new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,itm);
        spn.setAdapter(adptspn);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parant, View view, int i, long l) {
                adptlist =new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,arr[i]);
                list.setAdapter(adptlist);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parant, View view, int i, long l) {
                String str = parant.getItemAtPosition(i).toString();
                // Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
                // news Intent
                Intent intent = new Intent(MainActivity.this,ProductsList.class);
                //intent.putExtra("i", itm);
                startActivity(intent);
            }
        });

    }
}