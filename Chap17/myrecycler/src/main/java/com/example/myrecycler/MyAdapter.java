package com.example.myrecycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> implements ItemTouchHelperCallback.ItemTouchHelperListener {


    ArrayList<String> list;

    //ㅐ성자 - 메인액티비티에서 어댑터 생성할 때 데이터 받기


    public MyAdapter(ArrayList<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //item 1개 화면 inflation->메모리 객체화
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                android.R.layout.simple_list_item_1, viewGroup, false);
        //각각의 view findViewById 찾기 => VIewHolder


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        //holder에 있는 view 객체에 data 세팅
        //listView 에서는 getView()메소드에 해당

        myViewHolder.titleView.setText(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        //현재 item 가져오기
        String fromItem = list.get(fromPosition);
        //삭제
        list.remove(fromPosition);
        //추가
        list.add(toPosition, fromItem);
        notifyItemMoved(fromPosition,toPosition);

        return true;
    }

    @Override
    public void onItemRemove(int position) {
        list.remove(position);
        notifyDataSetChanged();

    }


}
