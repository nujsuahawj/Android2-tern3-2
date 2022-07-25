package com.developer.arsltech.lab_452022;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText txtname, txtsurname;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtname = findViewById(R.id.txtname);
        txtsurname = findViewById(R.id.txtsurname);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, sur;
                name=txtname.getText().toString();
                sur=txtsurname.getText().toString();
                String str = "Name:" +name +"\n";
                        str += "surname:" +sur;


                        AlertDialog.Builder art = new AlertDialog.Builder(MainActivity.this);
                        art.setTitle("confirm");
                        art.setMessage(str);
                        art.show();
            }
        });
    }
}