package com.guo.helloworld.jump;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.guo.helloworld.R;

/**
 * Created by guo_w on 2017/11/26.
 */

public class BActivity extends AppCompatActivity {
    private TextView mTvTitle2;
    private Button mBtnFinish,mBtnJump;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Log.d("BActivity","--onCreate--");
        Log.d("BActivity","taskid:"+getTaskId()+" ,hash:"+hashCode());
        logtaskName();//打印任务站名称

        mBtnJump=(Button) findViewById(R.id.btn_jumptoA);
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BActivity.this,AActivity.class);
                startActivity(intent);
            }
        });
        mTvTitle2=(TextView) findViewById(R.id.tv_title2);
        mBtnFinish=(Button)findViewById(R.id.btn_finish);
        final Bundle bundle=getIntent().getExtras();
        String name=bundle.getString("name");
        int number=bundle.getInt("number");
        mTvTitle2.setText(name+","+number);

        mBtnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                Bundle bundle1=new Bundle();
                bundle1.putString("title","我回来了");
                intent.putExtras(bundle1);
                setResult(Activity.RESULT_OK,intent);
                finish();//当前页面关闭
            }
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("BActivity","--onNewIntent--");
        Log.d("BActivity","taskid:"+getTaskId()+" ,hash:"+hashCode());
        logtaskName();//打印任务站名称
    }

    private void logtaskName(){
        try {
            ActivityInfo info=getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("BActivity",info.taskAffinity);//taskAffinnity相互关系，之间的依赖。Acitivity所在任务站的名称
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
