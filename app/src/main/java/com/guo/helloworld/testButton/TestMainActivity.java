package com.guo.helloworld.testButton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.guo.helloworld.ButtonActivity;
import com.guo.helloworld.R;

public class TestMainActivity extends AppCompatActivity {
    private Button mBtnShouYe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main);
        mBtnShouYe=(Button)findViewById(R.id.mBtnShouYe);
        mBtnShouYe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestMainActivity.this,"首页被点击",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
