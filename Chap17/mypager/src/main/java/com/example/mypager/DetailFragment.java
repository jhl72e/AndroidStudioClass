package com.example.mypager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class DetailFragment extends Fragment {
    int index; //ListView item 인덱스
    ImageView imageView;
    //생성자
    public DetailFragment() {}
    @SuppressLint("ValidFragment")
    public DetailFragment(int index) {
        this.index = index;
    }
    //화면 인플레이션

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(
                R.layout.fragment_detail, container, false);
        imageView = viewGroup.findViewById(R.id.image);
        imageView.setImageResource(R.drawable.dream01);
        return viewGroup;
    }

    public void setImage(int index) {
        imageView.setImageResource(R.drawable.dream01);
    }
}
