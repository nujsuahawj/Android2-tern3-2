package com.developer.arsltech.getdatapagetopage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShowData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView tvname,tvsurname,tvsex,tvage;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        tvname=findViewById(R.id.tvname);
        tvsurname=findViewById(R.id.tvsurname);
        tvage=findViewById(R.id.tvage);
        tvsex =findViewById(R.id.tvgender);

        Bundle bun =getIntent().getExtras();

        tvname.setText(bun.get("name").toString());
        tvsurname.setText(bun.get("surname").toString());
        tvsex.setText(bun.get("sex").toString());
        tvage.setText(bun.get("age").toString());
    }
}