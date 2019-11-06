package com.example.myrecycler;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class MyItemDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int width = parent.getWidth();
        int height = parent.getHeight();


        Paint paint = new Paint();
        paint.setColor(Color.RED);

        c.drawRect(0,0,width,height,paint);
    }


    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int index = parent.getChildAdapterPosition(view)+1;

        if(index%3==0)
        {
            outRect.set(20,20,20,60);
        }
        else
            outRect.set(20,20,20,20);


        view.setBackgroundColor(0xFFECE9E9);
        ViewCompat.setElevation(view,20.0f);

    }


    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        int width = parent.getWidth();
        int height = parent.getHeight();

        Drawable dr = ResourcesCompat.getDrawable(parent.getContext().getResources(),R.drawable.android, null );
        int drWidth = dr.getIntrinsicWidth();
        int drHeight = dr.getIntrinsicHeight();

        int left = width/2 - drWidth/2;
        int top = height/2 - drHeight/2;

        c.drawBitmap(BitmapFactory.decodeResource(parent.getResources(), R.drawable.android), left, top, null);

    }
}
