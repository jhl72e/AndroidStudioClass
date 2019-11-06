package com.example.test15_1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DonutView extends View {

    Paint paint;
    int donutSize;
    int strokeSize;
    int textSize;
    int value; //시크바 value값


    public DonutView(Context context) {
        super(context);
    }

    public DonutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init()
    {
        paint  = new Paint();
        donutSize = getResources().getDimensionPixelSize(R.dimen.donut_size);
        strokeSize = getResources().getDimensionPixelSize(R.dimen.donut_stroke_size);
        textSize = getResources().getDimensionPixelSize(R.dimen.donut_textSize);

    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    paint.setStrokeWidth(strokeSize);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        RectF rectf = new RectF(0,0,donutSize,donutSize);
        canvas.drawArc(rectf, 0, 360, false, paint);
        paint.setColor(Color.RED);
        canvas.drawArc(rectf, -90, value, false, paint);


        paint.setTextSize(textSize);
        paint.setStrokeWidth(5);
        String txt = String.valueOf(value);
        int textWidth = donutSize/2 - (int)(paint.measureText(txt)/2);
        int textHeight = donutSize/2;
        canvas.drawText(String.valueOf(value), textWidth,textHeight, paint);
    }

    public void setValue(int i)
    {
        value = i;
        invalidate();
    }




}






