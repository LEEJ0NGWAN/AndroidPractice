package com.example.simplepaintingapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class PaintingView extends View {
    Paint pBlack = new Paint();
    Paint pRed = new Paint();
    Paint pBlue = new Paint();
    Paint pYellow = new Paint();
    Paint pGreen = new Paint();

    int paintInfoX[] = new int[3000];
    int paintInfoY[] = new int[3000];
    int paintInfoRadius[] = new int[3000];
    int paintInfoColor[] = new int[3000];

    static int radius = 15; //default 굵기는 15
    static int colorFlag = 0; //default는 검정색

    int dataCount = 0; //painting 횟수
    int x, y; //터치 시 2차원 좌표

    public PaintingView(Context context, AttributeSet attr){
        super(context);
        pBlack.setColor(Color.BLACK);
        pRed.setColor(Color.RED);
        pBlue.setColor(Color.BLUE);
        pYellow.setColor(Color.YELLOW);
        pGreen.setColor(Color.GREEN);

        paintInfoX[0] = paintInfoY[0] = paintInfoColor[0] = paintInfoRadius[0] = 0;
    }
    public void onDraw(Canvas canvas){
        Paint selectedPen = pBlack;
        for(int i = 1; i <= dataCount; i++){
            switch (paintInfoColor[i]){
                case 1: selectedPen = pRed; break;
                case 2: selectedPen = pBlue; break;
                case 3: selectedPen = pYellow; break;
                case 4: selectedPen = pGreen; break;
                default:selectedPen = pBlack;
            }
            canvas.drawCircle(paintInfoX[i], paintInfoY[i], paintInfoRadius[i], selectedPen);
        }
        invalidate();
    }

    public void saveDate() {
        paintInfoX[dataCount] = x;
        paintInfoY[dataCount] = y;
        paintInfoRadius[dataCount] = radius;
        paintInfoColor[dataCount] = colorFlag;
    }

    public boolean onTouchEvent(MotionEvent event) {
        x = (int) event.getX();
        y = (int) event.getY();
        dataCount++;
        saveDate();
        return true;
    }
}
