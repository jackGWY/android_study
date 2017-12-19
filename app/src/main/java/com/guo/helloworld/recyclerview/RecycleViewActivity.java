package com.guo.helloworld.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.guo.helloworld.R;

public class RecycleViewActivity extends AppCompatActivity {
    private Button mBtnLinear,mBtnHor,mBtnGrid,mBtnPu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        mBtnLinear=(Button)findViewById(R.id.btn_linear);
        mBtnHor=(Button)findViewById(R.id.btn_hor);
        mBtnGrid=(Button)findViewById(R.id.btn_grid);
        mBtnPu=(Button)findViewById(R.id.btn_pu);
        mBtnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecycleViewActivity.this,LinearRecycleViewActivity.class);
                startActivity(intent);
            }
        });
        mBtnHor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecycleViewActivity.this,HorRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        mBtnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecycleViewActivity.this,GridRecycleViewActivity.class);
                startActivity(intent);
            }
        });
        mBtnPu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecycleViewActivity.this,PuRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
