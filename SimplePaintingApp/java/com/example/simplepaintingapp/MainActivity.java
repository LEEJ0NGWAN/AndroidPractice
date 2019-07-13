package com.example.simplepaintingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void increaseValue(View v){
        if(PaintingView.radius < 30)
            PaintingView.radius++;
    }
    public void decreaseValue(View v){
        if(PaintingView.radius > 1)
            PaintingView.radius--;
    }
    public void setBlack(View v){
        PaintingView.colorFlag = 0;
    }
    public void setRed(View v){
        PaintingView.colorFlag = 1;
    }
    public void setBlue(View v){
        PaintingView.colorFlag = 2;
    }
    public void setYellow(View v){
        PaintingView.colorFlag = 3;
    }
    public void setGreen(View v){
        PaintingView.colorFlag = 4;
    }
}
