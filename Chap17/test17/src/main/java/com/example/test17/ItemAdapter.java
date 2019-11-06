package com.example.test17;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<Item> list;

    //MainActivity 어댑터 생성할때 DB에 있는 데이터 받기
    public ItemAdapter(ArrayList<Item> list) {
        this.list = list;
    }


    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if(viewType == Item.TYPE_HEADER)
        {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_header, viewGroup,false);
            return new HeaderViewHolder(view);

        }
        //item.xml 인플레이션
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder myViewHolder, int i) {
        Item item = list.get(i);
        if(item.getType()==Item.TYPE_HEADER)
        {

        }else
        {
            MyViewHolder dataHolder =  (MyViewHolder)myViewHolder;
            DataItem dataItem =(DataItem)item;
            dataHolder.nameView.setText(dataItem.name);
            dataHolder.dateView.setText(dataItem.date);

            int count = i%5;
            if(count ==0)
            {
                ((GradientDrawable)dataHolder.personView.getBackground()).setColor(0xff009688);
            }
            else if(count ==1)
            {
                ((GradientDrawable)dataHolder.personView.getBackground()).setColor(0xff023920);
            }
            else if(count ==2)
            {
                ((GradientDrawable)dataHolder.personView.getBackground()).setColor(0x3293023);
            }
            else if(count ==3)
            {
                ((GradientDrawable)dataHolder.personView.getBackground()).setColor(Color.RED);
            }
            else if(count ==4)
            {
                ((GradientDrawable)dataHolder.personView.getBackground()).setColor(Color.BLUE);
            }

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nameView, dateView;
        ImageView personView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //itemView = item.xml

            nameView = itemView.findViewById(R.id.item_name);
            dateView = itemView.findViewById(R.id.item_date);
            personView = itemView.findViewById(R.id.item_person);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder{
        TextView titleView;
        public HeaderViewHolder(@NonNull View itemView)
        {
            super(itemView);
            titleView = itemView.findViewById(R.id.item_header);
        }
    }
}
