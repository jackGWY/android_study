package com.guo.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {
    private ImageView mIv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        mIv4=(ImageView)findViewById(R.id.iv_4);
        Glide.with(this).load("https://www.baidu.com/img/bd_logo1.png").into(mIv4);//加载网络图片
    }
}
