package com.developer.arsltech.getdatapagetopage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner spn;
    EditText txtname,txtsurname;
    RadioButton rmale,frmale;
    Button btnOK;
    String [] age ={"1","2","3","4","5","6","7","8","9","10"};
    ArrayAdapter<String> adp;
    String strage="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn =findViewById(R.id.spn);
        txtname =findViewById(R.id.txtname);
        txtsurname=findViewById(R.id.txtsurname);
        rmale =findViewById(R.id.rmale);
        frmale=findViewById(R.id.frmale);
        btnOK =findViewById(R.id.btnOK);

        adp=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,age);
        spn.setAdapter(adp);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parant, View view, int i, long l) {
                strage =parant.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,ShowData.class);
                intent.putExtra("name",txtname.getText().toString());
                intent.putExtra("surname",txtsurname.getText().toString());
                intent.putExtra("age",strage);
                String sex="";
                if(rmale.isChecked()){
                    sex=rmale.getText().toString();
                }else{
                    sex=frmale.getText().toString();
                }
                intent.putExtra("sex",sex);
                startActivity(intent);


            }
        });


    }
}