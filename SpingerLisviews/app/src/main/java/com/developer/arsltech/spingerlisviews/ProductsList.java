package com.developer.arsltech.spingerlisviews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ProductsList extends AppCompatActivity {
    RecyclerView.Adapter<myViewholder> adapter=null;
    RecyclerView crv;
    int[] img = {
            R.drawable.duabib,
            R.drawable.duabob,
            R.drawable.duabpeb,
            R.drawable.duabplaub,
            R.drawable.duabntsib,
            R.drawable.duabrau,
    };
    String[] menu={
            "food", "getpa", "nomai", "pathong", "payam", "tagli"
    };
    String[] price={
            "1500", "2000", "3000", "4000", "4000", "5000"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crv = new RecyclerView(this);
        crv.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerView.Adapter<myViewholder>() {
            @NonNull
            @Override
            public myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_products_list,parent, false);
                myViewholder myViewholder = new myViewholder(view);
                return myViewholder;
            }

            @Override
            public void onBindViewHolder(@NonNull myViewholder holder, int position) {
                holder.vname.setText(menu[position]);
                holder.vprice.setText(price[position]);
                holder.vimg.setImageResource(img[position]);
            }

            @Override
            public int getItemCount() {

                return menu.length;
            }
        };
        crv.setAdapter(adapter);
        setContentView(crv);
        


    }
}