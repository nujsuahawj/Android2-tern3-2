package com.developer.arsltech.spingerlisviews;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static androidx.recyclerview.widget.RecyclerView.*;

public class myViewholder extends RecyclerView.ViewHolder{
    TextView vname, vprice;
    ImageView vimg;

    public myViewholder(@NonNull View itemView) {

        super(itemView);
        vname = vname.findViewById(R.id.textView);
        vprice = vprice.findViewById(R.id.textView2);
        vimg = vimg.findViewById(R.id.imageView);
    }
}
