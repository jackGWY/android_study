package com.guo.helloworld.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.guo.helloworld.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnMessageClick{
    private AFragment aFragment;
    private TextView mTvTitle;
//    private BFragment bFragment;
//    private Button mBtnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

    //    mBtnChange=(Button) findViewById(R.id.btn_change);
//        mBtnChange.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(bFragment==null){
//                    bFragment=new BFragment();
//                }
//                getFragmentManager().beginTransaction().replace(R.id.f1_container,bFragment).commitAllowingStateLoss();
//            }
//        });
        //实例化AFragment
        mTvTitle=findViewById(R.id.tv_title_container);
        aFragment=AFragment.newInstance("我是参数");
        //把AFragment添加到Activity中，记得调用commit
        getFragmentManager().beginTransaction().add(R.id.f1_container,aFragment,"a").commitAllowingStateLoss();//commit生效
    }
    public void setData(String text){
        mTvTitle.setText(text);
    }

    @Override
    public void onClick(String text) {
        mTvTitle.setText(text);
    }
}
