package com.example.myrecycler;

import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView titleView;

    public MyViewHolder(@NonNull View itemView){
        super(itemView);
        titleView = itemView.findViewById(android.R.id.text1);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), titleView.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
