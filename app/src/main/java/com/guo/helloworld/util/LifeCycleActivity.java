package com.guo.helloworld.util;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.guo.helloworld.R;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.d("LifeCycel","---onCreate ---");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycel","---onStart ---");
    }

    @Override
    protected void onResume() {
        super.onResume();//重新开始,比如电话打完又进来游戏或看视频了，
        Log.d("LifeCycel","---onResume ---");
    }

    @Override
    protected void onPause() {
        super.onPause();//电话打进来是要暂停的额
        Log.d("LifeCycel","---onPause ---");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycel","---onStop ---");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycel","---onRestart ---");
    }

    @Override
    protected void onDestroy() {
        //摧毁之前需要做的事情
        super.onDestroy();
        Log.d("LifeCycel","---onDestroy ---");
    }
}
