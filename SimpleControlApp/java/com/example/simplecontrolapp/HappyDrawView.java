package com.example.simplecontrolapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;

import static java.lang.Math.abs;

public class HappyDrawView extends View {
    float x1 =0 , x2 =0 , y1 =0, y2 =0;
    float xSpeed=0, ySpeed=0;
    int radius = MainActivity.happyWidth/2;
    boolean isTouching = false;
    HappyDrawView(Context context) {
        super(context);
        setBackgroundColor(Color.BLUE);
        h.sendEmptyMessageDelayed(0, 1000);
    }

    public void onDraw(Canvas canvas){
        Paint p = new Paint();
        canvas.drawBitmap(MainActivity.screen,0,0,p);
        canvas.drawBitmap(MainActivity.happy, MainActivity.happyX, MainActivity.happyY, p);
        if (isTouching)
            canvas.drawBitmap(MainActivity.controlPanel, x1-radius, y1-radius, p);
    }
    public  boolean onTouchEvent(MotionEvent e){
        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN :
                isTouching = true;
                x1 = e.getX();
                y1 = e.getY();
            case MotionEvent.ACTION_MOVE:
                x2 = e.getX();
                y2 = e.getY();
                if(abs(x2-x1) < MainActivity.happyWidth/2) xSpeed = 0;
                else    xSpeed = ((x2-x1) > 0) ? 1 : -1;
                if(abs(y2-y1) < MainActivity.happyWidth/2) ySpeed = 0;
                else    ySpeed = ((y2-y1) > 0) ? 1 : -1;
                break;
            case MotionEvent.ACTION_UP:
                isTouching = false;
                xSpeed = ySpeed = 0;
        }
        return true;
    }
    Handler h = new Handler(){
        public void handleMessage(Message msg){
            MainActivity.happyX += xSpeed;
            MainActivity.happyY += ySpeed;
            invalidate();
            h.sendEmptyMessageDelayed(0, 30);
        }
    };
}
