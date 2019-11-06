package com.example.chap15;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MyView2 extends View {
    Paint paint;
    public MyView2(Context context) {
        super(context);
        init();
    }

    public MyView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init()
    {
        paint = new Paint();
        paint.setColor(Color.RED);

        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //사각형 그리기
        paint.setStrokeJoin(Paint.Join.ROUND);// 모서리 모양
        canvas.drawRect(15,15, 165,165,paint);


        //선그리기
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(30);//선의 두께
        paint.setStrokeCap(Paint.Cap.ROUND);//선의 끝처리
        canvas.drawLine(15,200, 350,200, paint);


        paint.setColor(Color.YELLOW);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(150,350, 100, paint);

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        RectF rectf = new RectF(400,40,800,450);
        canvas.drawArc(rectf, 0, 180, false, paint);

        //텍스트 그리기
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(50);
        canvas.drawText("텍스트도 그릴 수 있습니다", 15,550, paint);

    }
}
