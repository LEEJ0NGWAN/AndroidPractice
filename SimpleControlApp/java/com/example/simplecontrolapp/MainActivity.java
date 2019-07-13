package com.example.simplecontrolapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    public static Bitmap screen, happy, controlPanel;
    public static int displayWidth, displayHeight;
    public static float happyX, happyY;
    public static int happyWidth, happyHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        displayWidth = display.getWidth();
        displayHeight = display.getHeight();
        happyWidth = displayWidth/8;
        happyHeight = displayHeight/11;
        happyX = displayWidth/2;
        happyY = displayHeight/2;
        screen = BitmapFactory.decodeResource(getResources(), R.drawable.screen);
        happy = BitmapFactory.decodeResource(getResources(), R.drawable.happy);
        controlPanel = BitmapFactory.decodeResource(getResources(), R.drawable.circle);
        screen = Bitmap.createScaledBitmap(screen, displayWidth, displayHeight, true);
        happy = Bitmap.createScaledBitmap(happy, happyWidth, happyHeight, true);
        controlPanel = Bitmap.createScaledBitmap(controlPanel, happyWidth, happyWidth, true);
        super.onCreate(savedInstanceState);
        setContentView(new HappyDrawView(this));
    }
}
