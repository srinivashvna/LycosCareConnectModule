package com.care.connect;

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class CallingActivity extends AppCompatActivity {
    TextView tv_endcall,tv_countdown,tv_name,tv_time,tv_calling;
    ImageView iv_image;
    int count_time=1000;
    @Override
    public void onCreate(   Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calling_layout);

        getSupportActionBar().hide();
        tv_endcall = findViewById(R.id.tv_endcall);
        tv_countdown = findViewById(R.id.tv_countdown);
        tv_name = findViewById(R.id.tv_name);
        tv_time = findViewById(R.id.tv_time);
        iv_image = findViewById(R.id.iv_image);
        tv_calling = findViewById(R.id.tv_calling);

        tv_endcall.setVisibility(View.GONE);
        tv_countdown.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tv_countdown.setVisibility(View.VISIBLE);
                tv_endcall.setVisibility(View.VISIBLE);
                tv_calling.setVisibility(View.GONE);
                Glide.with(getApplicationContext())
                        .load("https://image.shutterstock.com/image-photo/portrait-happy-mature-man-making-260nw-1283682721.jpg")
                        .into(iv_image);
            }
        },3000);

        tv_endcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
