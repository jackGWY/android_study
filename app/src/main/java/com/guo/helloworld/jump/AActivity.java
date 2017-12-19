package com.guo.helloworld.jump;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.guo.helloworld.R;

/**
 * Created by guo_w on 2017/11/26.
 */

public class AActivity extends AppCompatActivity {
    private Button mBtnJump;
    private Button mBtnJump2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.d("AActivity","--onCreate--");
        Log.d("AActivity","taskid:"+getTaskId()+" ,hash:"+hashCode());
        logtaskName();//打印任务站名称

        mBtnJump=(Button)findViewById(R.id.jump) ;
        mBtnJump2=(Button)findViewById(R.id.jump_2) ;
        mBtnJump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AActivity.this,AActivity.class);
                startActivity(intent);
            }
        });
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示跳转
                Intent intent=new Intent(AActivity.this,BActivity.class);//放一个意图
                Bundle bundle=new Bundle();
                bundle.putString("name","天哥");//key,value
                bundle.putInt("number",99);
                intent.putExtras(bundle);
                startActivity(intent);
               // startActivityForResult(intent,0);//从A返回数据

//                Intent intent=new Intent();
//                intent.setClass(AActivity.this,BActivity.class);
//                startActivity(intent);

//                Intent intent=new Intent();
//                intent.setClassName(AActivity.this,"com.guo.helloworld.jump.BActivity");
//                startActivity(intent);

                //Intent intent=new Intent();
                //intent.setComponent(new ComponentName(AActivity.this,"com.guo.helloworld.jump.BActivity"));
                //startActivity(intent);
                //隐身
//                Intent intent=new Intent();
//                intent.setAction("com.guo.test.BActivity");
//                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //requestCode A--0,resultCode---B.RESULT_OK,intent data 是B传过来的

        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this,data.getExtras().getString("title"),Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("AActivity","--onNewIntent--");
        Log.d("AActivity","taskid:"+getTaskId()+" ,hash:"+hashCode());
        logtaskName();//打印任务站名称
    }

    private void logtaskName(){
        try {
            ActivityInfo info=getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("AActivity",info.taskAffinity);//taskAffinnity相互关系，之间的依赖。Acitivity所在任务站的名称
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
