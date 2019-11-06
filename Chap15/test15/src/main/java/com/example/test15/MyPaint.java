package com.example.test15;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyPaint extends View {
    Paint paint;
    Path path;//터치 경로
    Bitmap bitmap;//비트맵 이미지
    Canvas mCanvas;

    public MyPaint(Context context) {
        super(context);
        init();
    }

    public MyPaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init()
    {
        paint = new Paint();
        path = new Path();
        paint.setColor(0xFF0000);
        paint.setStrokeWidth(40);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

    }

    //onDraw보다 먼저 호출
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(bitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                mCanvas.drawPath(path,paint);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x,y);
                mCanvas.drawPath(path, paint);
                break;
            case MotionEvent.ACTION_UP:
                mCanvas.drawPath(path,paint);
                path.reset();
                break;
        }
        invalidate(); // 다시 그리기
        return true;
    }

    public void setColor(String color)
    {
        paint.setColor(Color.parseColor(color));
    }
}
