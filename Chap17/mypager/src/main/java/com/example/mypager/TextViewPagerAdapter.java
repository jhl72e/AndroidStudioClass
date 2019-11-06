package com.example.mypager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TextViewPagerAdapter extends PagerAdapter {
    Context context;

    TextViewPagerAdapter(Context context){
        this.context = context;
    }


    @Override
    public int getCount() {
        return 5;
    }



    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.pager, container, false);


        TextView textView = view.findViewById(R.id.title);
        textView.setText("Text"+position);

        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view==o);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        Toast.makeText(context, "destroy"+ position, Toast.LENGTH_SHORT).show();
        container.removeView((View)object);
    }
}
