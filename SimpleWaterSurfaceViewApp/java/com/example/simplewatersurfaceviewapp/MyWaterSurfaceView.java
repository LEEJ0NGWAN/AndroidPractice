package com.example.simplewatersurfaceviewapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Vector;

public class MyWaterSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    int x = 0, y = 0;
    SurfaceHolder holder;
    DrawingThread thread;
    Vector<Integer> xV = new Vector<>(), yV = new Vector<>(), rV = new Vector<>();
    int count = 0;

    public MyWaterSurfaceView(Context ctx, AttributeSet attr) {
        super(ctx, attr);
        thread = new DrawingThread();
        holder = getHolder();
        holder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread.start();
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) { }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) { }

    public class DrawingThread extends Thread {
        Paint p;

        public void run() {
            p = new Paint();
            p.setColor(Color.BLUE);
            p.setStyle(Paint.Style.STROKE);
            while (true) {
                Canvas canvas = holder.lockCanvas();
                canvas.drawColor(Color.WHITE);
                for(int i = 0; i<count; i++){
                    canvas.drawCircle(xV.get(i),yV.get(i),rV.get(i),p);
                    int rand = (int)(Math.random()*10) + 1;
                    rV.set(i,rV.get(i)+rand);
                    if(rV.get(i) >= 200){
                        xV.remove(i);
                        yV.remove(i);
                        rV.remove(i);
                        count--;
                        i--;
                    }
                }
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                x = (int) event.getX();
                y = (int) event.getY();
                xV.add(x);
                yV.add(y);
                rV.add(1);
                count++;
                return true;
            case MotionEvent.ACTION_UP:
        }
        return false;
    }
}
