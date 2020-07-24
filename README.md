# touchZW
android的一个指纹验证效果



接触opencv有一段时间了，刚好公司最近有个指纹相关的功能，其中有个指纹特效晚上现成没有很好定制型所以就用opencv试着写了一个效果。

#### 项目源码：
https://github.com/woshiliyihang/touchZW

#### 效果图：
<img src="https://img2020.cnblogs.com/blog/632138/202007/632138-20200723095617002-1173835970.gif" width = "200" height = "400" alt="指纹验证" />

#### 前期准备
效果不是非常好但是修改定制简单，所需要准备的有两张图片：
前景图：
<img src="https://img2020.cnblogs.com/blog/632138/202007/632138-20200723095642204-1934060842.png" width = "100" height = "150" alt="指纹验证" />
背景图：
<img src="https://img2020.cnblogs.com/blog/632138/202007/632138-20200723095649749-166028841.png" width = "100" height = "150" alt="指纹验证" />

一个是红色前景，一个黑色背景，两张图片尺寸一样大。


#### 代码实现：

```java
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
        // 初始化opencv工具类
        DrawZW.onResume(this, new Runnable() {
            @Override
            public void run() {
                startAnim();
            }
        });
    }

    private void startAnim() {
        //R.mipmap.zhiwen 前景图 R.mipmap.zhiwen_gr 背景图
        drawZW = new DrawZW((ImageView) findViewById(R.id.img), R.mipmap.zhiwen, R.mipmap.zhiwen_gr);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // x y r 分别代表这个 圆心 xy 点  和 半径 r
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
                drawZW.free();//记得释放内存哦
            }
        }, 10000);
    }
}
```

主要说明注释里面已经写了！
简单介绍原理：就是通过画圆的方式模拟点击效果，然后使用图形处理达到效果。
不喜勿喷，如果这个对你有帮助记得点赞哦 !!!!!!!!!!!!!!!!!!!!!!!!!
