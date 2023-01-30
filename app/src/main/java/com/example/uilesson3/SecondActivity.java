package com.example.uilesson3;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private final int STEP = 10;//移动步长
    private ImageView image; // 米老鼠图像控件
    private LinearLayout root; // 线性根布局
    private LinearLayout.LayoutParams layoutParams; // 布局参数

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //1、实例化控件
        image = findViewById(R.id.id_mickey);
        root = findViewById(R.id.Mickey_activity);
        //2、获得焦点
        root.setFocusable(true); //有获得焦点的能力
        root.requestFocus(); //请求获得
        //3、获取图像控件的布局参数
        layoutParams = (LinearLayout.LayoutParams) image.getLayoutParams();
        //4、给线性根布局注册按键监听器，实现监听器接口，编写事件处理方法
        root.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                //4.1、根据按键修改图像的布局参数，即改变图像的位置
                switch (i) {
                    case KeyEvent.KEYCODE_DPAD_UP:  // 19, 按上方向键
                        layoutParams.topMargin = layoutParams.topMargin - STEP;
                        break;
                    case KeyEvent.KEYCODE_DPAD_DOWN: // 20, 按下方向键
                        layoutParams.bottomMargin = layoutParams.bottomMargin + STEP;
                        break;
                    case KeyEvent.KEYCODE_DPAD_LEFT: // 21, 按左方向键
                        layoutParams.leftMargin = layoutParams.leftMargin - STEP;
                        break;
                    case KeyEvent.KEYCODE_DPAD_RIGHT:// 22, 按右方向键
                        layoutParams.rightMargin = layoutParams.rightMargin - STEP;
                        break;
                }
                //4.2、更新图像控件的布局参数，即使动态布局生效
                image.setLayoutParams(layoutParams);
                return false;
            }
        });
    }

}
