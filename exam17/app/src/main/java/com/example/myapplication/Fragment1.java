package com.example.myapplication;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Item> list;
    ItemAdapter adapter;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment2, container, false);

        recyclerView = view.findViewById(R.id.recycler);


        //DB에서 데이터 조회해서 list 에 add 하기
        DBHelper helper = new DBHelper(getContext());
        SQLiteDatabase db = helper.getReadableDatabase();

        String sql = "select * from tb_gallery";
        Cursor cursor = db.rawQuery(sql, null);

        list = new ArrayList<>();
        while(cursor.moveToNext())
        {
            Item item = new Item();
            item.image = cursor.getString(1);
            item.title = cursor.getString(2);
            item.count = cursor.getString(3);
            list.add(item);
        }

        //recyclerview에 어댑터 세팅
        adapter = new ItemAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }


    class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder>
    {
        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.item, viewGroup,false);
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
            //viewHolder에서 찾은 view 객체에 데이터(db 조회) 넣기
            Item item = list.get(i);
            itemViewHolder.titleView.setText(item.title);
            itemViewHolder.countView.setText(item.count);
            //이미지 넣기
            if(item.image.equals("img01"))
                itemViewHolder.imageView.setImageResource(R.drawable.img01);
            else if(item.image.equals("img02"))
                itemViewHolder.imageView.setImageResource(R.drawable.img02);
            else if(item.image.equals("img03"))
                itemViewHolder.imageView.setImageResource(R.drawable.img03);
            else if(item.image.equals("img04"))
                itemViewHolder.imageView.setImageResource(R.drawable.img04);
            else if(item.image.equals("img05"))
                itemViewHolder.imageView.setImageResource(R.drawable.img05);
            else if(item.image.equals("img06"))
                itemViewHolder.imageView.setImageResource(R.drawable.img06);
            else if(item.image.equals("img07"))
                itemViewHolder.imageView.setImageResource(R.drawable.img07);

        }


        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{

        TextView titleView, countView;
        ImageView imageView;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            //item 화면에 view 객체 찾기
            titleView= itemView.findViewById(R.id.title);
            countView = itemView.findViewById(R.id.count);
            imageView=itemView.findViewById(R.id.image);
        }


    }






}
