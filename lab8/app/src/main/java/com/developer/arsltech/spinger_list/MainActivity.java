package com.developer.arsltech.spinger_list;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String [] arr={"Computers","Camera","Mobile Phone"};
    String [][] itm={new String[]{"Acer","HP","Dell","Samsung"},
            new String[]{"Canon","Sonny","Casio","Nikon","Fuji","Panasonic"},
            new String[]{"iPhone","Samsung","VIVO","Huawei","OPPO"}
    };

    Spinner spn;
    ListView ist;
    ArrayAdapter<String> aptspn=null;
    ArrayAdapter<String> aptist=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn =findViewById(R.id.spn);
        ist =findViewById(R.id.ist);
        aptspn =new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,arr);
        
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parant, View view, int i, long l) {
                aptist =new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,itm[i]);
                ist.setAdapter(aptist);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}