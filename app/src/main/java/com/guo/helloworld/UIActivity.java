package com.guo.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.guo.helloworld.fragment.ContainerActivity;
import com.guo.helloworld.jump.AActivity;
import com.guo.helloworld.listview.ListViewActivity;
import com.guo.helloworld.recyclerview.PuRecyclerViewActivity;
import com.guo.helloworld.recyclerview.RecycleViewActivity;
import com.guo.helloworld.testButton.TestMainActivity;
import com.guo.helloworld.util.LifeCycleActivity;

public class UIActivity extends AppCompatActivity {
    private Button mBtnTextView,mbtnButton,mBtnEditText,mBtnRadioButton,mBtnCheckBox;
    private Button mBtnImageView,mBtnListView,mBtnRv;//命名mBtn开头
    private Button mBtnTest1,mBtnWebView,mBtnToast,mBtnDialog,mBtnPopWindow;
    private Button mBtnLifeCycle,mBtnJump,mBtnFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        mBtnTextView =(Button) findViewById(R.id.btn_textview);
        mbtnButton=(Button) findViewById(R.id.btn_button);
        mBtnEditText=(Button) findViewById(R.id.btn_edittext);
        mBtnRadioButton=(Button) findViewById(R.id.btn_radiobutton);
        mBtnCheckBox=(Button)findViewById(R.id.btn_CheckBox) ;
        mBtnImageView=(Button)findViewById(R.id.btn_imageview);
        mBtnListView=(Button) findViewById(R.id.btn_listview);
        mBtnRv=(Button)findViewById(R.id.btn_recyclerview);
        mBtnTest1=(Button)findViewById(R.id.btn_test1);
        mBtnWebView=(Button)findViewById(R.id.btn_webview);
        mBtnToast=(Button) findViewById(R.id.btn_toast);
        mBtnDialog=(Button) findViewById(R.id.btn_dialog);
        mBtnPopWindow=(Button)findViewById(R.id.btn_popwindow);
        mBtnLifeCycle=(Button)findViewById(R.id.btn_lifecycle);
        mBtnJump=(Button)findViewById(R.id.btn_jump);
        mBtnFragment=(Button)findViewById(R.id.btn_fragment);
        setListener();
    }

    private void setListener(){
        OnClick onClick=new OnClick();
        mbtnButton.setOnClickListener(onClick);
        mBtnTextView.setOnClickListener(onClick);
        mBtnEditText.setOnClickListener(onClick);
        mBtnRadioButton.setOnClickListener(onClick);
        mBtnCheckBox.setOnClickListener(onClick);
        mBtnImageView.setOnClickListener(onClick);
        mBtnListView.setOnClickListener(onClick);
        mBtnRv.setOnClickListener(onClick);
        mBtnTest1.setOnClickListener(onClick);
        mBtnWebView.setOnClickListener(onClick);
        mBtnToast.setOnClickListener(onClick);
        mBtnDialog.setOnClickListener(onClick);
        mBtnPopWindow.setOnClickListener(onClick);
        mBtnLifeCycle.setOnClickListener(onClick);
        mBtnJump.setOnClickListener(onClick);
        mBtnFragment.setOnClickListener(onClick);
    }


    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent=null;
            switch (v.getId()){//获取视图的ID

                case R.id.btn_radiobutton:
                    intent=new Intent(UIActivity.this,RadioButtonActivity.class);
                    break;
                case R.id.btn_edittext:
                    intent=new Intent(UIActivity.this,EditTextActivity.class);
                    break;
                case R.id.btn_textview:
                    intent=new Intent(UIActivity.this,TextViewActivity.class);
                    break;
                case R.id.btn_button:
                    intent=new Intent(UIActivity.this,ButtonActivity.class);
                    break;
                case R.id.btn_CheckBox:
                    //跳转到CheckBox演示界面
                    intent=new Intent(UIActivity.this,CheckBoxActivity.class);
                    break;
                case R.id.btn_imageview:
                    intent=new Intent(UIActivity.this,ImageViewActivity.class);
                    break;
                case R.id.btn_listview:
                    intent=new Intent(UIActivity.this,ListViewActivity.class);
                    break;
                case R.id.btn_recyclerview:
                    intent=new Intent(UIActivity.this,RecycleViewActivity.class);
                    break;
                case R.id.btn_test1:
                    intent=new Intent(UIActivity.this, TestMainActivity.class);
                    break;
                case R.id.btn_webview:
                    intent=new Intent(UIActivity.this, WebViewActivity.class);
                    break;
                case R.id.btn_toast:
                    intent=new Intent(UIActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_dialog:
                    intent=new Intent(UIActivity.this, DialogActivity.class);
                    break;
                case R.id.btn_popwindow:
                    intent=new Intent(UIActivity.this, PopupWindowActivity.class);
                    break;
                case R.id.btn_lifecycle:
                    intent=new Intent(UIActivity.this, LifeCycleActivity.class);
                    break;
                case R.id.btn_jump:
                    intent=new Intent(UIActivity.this, AActivity.class);
                    break;
                case R.id.btn_fragment:
                    intent=new Intent(UIActivity.this, ContainerActivity.class);
                    break;

            }
            startActivity(intent);
        }
    }
}
