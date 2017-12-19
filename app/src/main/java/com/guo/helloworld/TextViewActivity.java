package com.guo.helloworld;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {

    private TextView mtv4,mtv5,mtv6;
    //private TextView mtv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        mtv4=(TextView) findViewById(R.id.tv_4);
        mtv4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//划中线
        mtv4.getPaint().setAntiAlias(true);//去除锯齿

        mtv5=(TextView) findViewById(R.id.tv_5);
        mtv5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        mtv6=(TextView) findViewById(R.id.tv_6);
        mtv6.setText(Html.fromHtml("<u>天哥在奔跑<u>"));


    }
}
