package com.guo.helloworld.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.guo.helloworld.R;

/**
 * Created by guo_w on 2017/11/22.
 */

public class ListViewActivity extends Activity {
    private ListView mLv1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        mLv1=findViewById(R.id.lv_1);
        mLv1.setAdapter(new MyListAdapter(ListViewActivity.this));
    }
}
