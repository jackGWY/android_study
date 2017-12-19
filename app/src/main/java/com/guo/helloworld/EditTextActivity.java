package com.guo.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditTextActivity extends AppCompatActivity {
    private Button mBtnLogin;
    private EditText mEtUserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        mBtnLogin=(Button)findViewById(R.id.btn_Login);
        mBtnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(EditTextActivity.this,"登入成功",Toast.LENGTH_SHORT).show();
            }
        });
        mEtUserName=(EditText) findViewById(R.id.et_1);
        mEtUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            //输入内容的监听，s是输入的额字符串
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("edittext",s.toString());//打印刚才输入的东西
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
