package com.guo.helloworld;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.guo.helloworld.util.ToastUtil;

public class DialogActivity extends AppCompatActivity {
    private Button mBtnDialog1,mBtnDialog2,mBtnDialog3,mBtnDialog4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        mBtnDialog1=(Button)findViewById(R.id.btn_dialog1);
        mBtnDialog2=(Button)findViewById(R.id.btn_dialog2);
        mBtnDialog3=(Button)findViewById(R.id.btn_dialog3);
        mBtnDialog4=(Button)findViewById(R.id.btn_dialog4);
        OnClick onClick=new OnClick();
        mBtnDialog1.setOnClickListener(onClick);
        mBtnDialog2.setOnClickListener(onClick);
        mBtnDialog3.setOnClickListener(onClick);
        mBtnDialog4.setOnClickListener(onClick);

    }
    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            switch(v.getId()){
                case R.id.btn_dialog1:
                    AlertDialog.Builder builder=new AlertDialog.Builder(DialogActivity.this);
                    builder.setTitle("请回答").setMessage("你觉得课程如何？").setIcon(R.drawable.icon_user)
                            .setPositiveButton("棒", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,"你很好");
                        }
                    }).setNeutralButton("还行", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,"你在瞅瞅");
                        }
                    }).setNegativeButton("不好", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,"睁眼说瞎话");
                        }
                    }).show();
                    break;
                case R.id.btn_dialog2:
                    final String[] array2=new String[]{"男","女"};
                    AlertDialog.Builder builder2=new AlertDialog.Builder(DialogActivity.this);
                    builder2.setTitle("选择性别").setItems(array2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,array2[which]);
                        }
                    }).show();
                    break;
                case R.id.btn_dialog3:
                    final String[] array3=new String[]{"男","女"};
                    AlertDialog.Builder builder3=new AlertDialog.Builder(DialogActivity.this);
                    builder3.setTitle("选择性别").setSingleChoiceItems(array3, 1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,array3[which]);
                            dialog.dismiss();
                        }
                    }).show();
                    break;
                case R.id.btn_dialog4:
                    final String[] array4=new String[]{"唱歌","跳舞","写代码"};
                    boolean[] isSelected=new boolean[]{false,false,true};
                    AlertDialog.Builder builder4=new AlertDialog.Builder(DialogActivity.this);
                    builder4.setTitle("选择兴趣").setMultiChoiceItems(array4, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtil.showMsg(DialogActivity.this,array4[which]+":"+isChecked);
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //
                        }
                    }).show();
                    break;
            }
        }
    }
}
