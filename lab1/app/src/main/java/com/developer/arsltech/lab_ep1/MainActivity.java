package com.developer.arsltech.lab_ep1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit, submitr;
    EditText name, password, email, contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.editText1);
        email = (EditText) findViewById(R.id.editText2);
        contact = (EditText) findViewById(R.id.editText3);
        password = (EditText) findViewById(R.id.editText4);
        submit = (Button) findViewById(R.id.button);
        submitr = (Button) findViewById(R.id.buttonr);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty() || password.getText().toString().isEmpty() || email.getText().toString().isEmpty()
                        || contact.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "ກະລຸນາປ້ອນຂໍ້ມູນ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "ຊື່ -  " + name.getText().toString()
                            + " \n" + "ອີເມວ -  " + email.getText().toString()
                            + " \n" + "ເບີໂທ -  " + contact.getText().toString()
                            + " \n " + "ລະຫັດ -  " + password.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        submitr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                email.setText("");
                contact.setText("");
                password.setText("");
            }
        });

    }
}