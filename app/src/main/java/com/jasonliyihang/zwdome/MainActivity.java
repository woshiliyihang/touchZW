package com.jasonliyihang.zwdome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import org.opencv.jason.DrawZW;

public class MainActivity extends AppCompatActivity {

    private DrawZW drawZW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        DrawZW.onResume(this, new Runnable() {
            @Override
            public void run() {
                startAnim();
            }
        });
    }

    private void startAnim() {
        drawZW = new DrawZW((ImageView) findViewById(R.id.img), R.mipmap.zhiwen, R.mipmap.zhiwen_gr);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                drawZW.logic(drawZW.getRgb().cols()/2,drawZW.getRgb().rows()/2, (int) (drawZW.getRgb().cols()*0.4f), 700);
            }
        }, 2001);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                drawZW.logic(drawZW.getRgb().cols()/3,drawZW.getRgb().rows()/3,drawZW.getRgb().cols()/3, 700);
            }
        }, 4001);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                drawZW.logic(drawZW.getRgb().cols()/2,drawZW.getRgb().rows()/4*3, (int) (drawZW.getRgb().cols()*0.7f), 700);
            }
        }, 6001);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                drawZW.logic(drawZW.getRgb().cols()/2,drawZW.getRgb().rows()/4,drawZW.getRgb().cols()*2, 700);
            }
        }, 8000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                drawZW.free();
            }
        }, 10000);
    }
}