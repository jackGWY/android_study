package com.guo.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.guo.helloworld.util.ToastUtil;

public class ToastActivity extends AppCompatActivity {
    private Button mBtnToast1,mBtnToast2,mBtnToast3,mBtnToast4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        mBtnToast1=(Button)findViewById(R.id.btn_toast_1);
        mBtnToast2=(Button)findViewById(R.id.btn_toast_2);
        mBtnToast3=(Button)findViewById(R.id.btn_toast_3);
        mBtnToast4=(Button)findViewById(R.id.btn_toast_4);
        OnClick onClick=new OnClick();
        mBtnToast1.setOnClickListener(onClick);
        mBtnToast2.setOnClickListener(onClick);
        mBtnToast3.setOnClickListener(onClick);
        mBtnToast4.setOnClickListener(onClick);
    }
    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_toast_1:
                    Toast.makeText(getApplicationContext(),"Toast",Toast.LENGTH_LONG).show();
                    break;
                case R.id.btn_toast_2:
                    Toast toastCenter=Toast.makeText(getApplicationContext(),"居中",Toast.LENGTH_LONG);
                    toastCenter.setGravity(Gravity.CENTER,0,0);
                    toastCenter.show();
                    break;
                case R.id.btn_toast_3:
                    Toast toastCustom=new Toast(getApplicationContext());
                    LayoutInflater inflater=LayoutInflater.from(ToastActivity.this);//布局填充器
                    View view=inflater.inflate(R.layout.layout_toast,null);
                    ImageView imageView=view.findViewById(R.id.iv_toast);//注意这里一定是从总视图里面获得
                    //这里错了很多
                    TextView textView=view.findViewById(R.id.tv_toast);
                    imageView.setImageResource(R.drawable.icon_smile1);
                    textView.setText("自定义toast");
                    /*//加载布局管理器
                    LayoutInflater inflater = LayoutInflater.from(context);
                    //将xml布局转换为view对象
                    convertView = inflater.inflate(R.layout.item_myseallist,parent, false);
                    //利用view对象，找到布局中的组件
                    convertView.findViewById(R.id.delete);// 删除*/
                    toastCustom.setView(view);
                    toastCustom.setDuration(Toast.LENGTH_LONG);
                    toastCustom.show();
                    break;
                case R.id.btn_toast_4:
                    ToastUtil.showMsg(getApplicationContext(),"包装过的");
                    break;
            }
        }
    }
}
