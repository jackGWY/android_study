package com.guo.helloworld.recyclerview;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.guo.helloworld.R;

public class HorRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvHor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hor_recycler_view);

        mRvHor=(RecyclerView) findViewById(R.id.rv_hor);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(HorRecyclerViewActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);//区别在于设置了orientation
        mRvHor.setLayoutManager(linearLayoutManager);
        mRvHor.addItemDecoration(new MyDecoration());
        mRvHor.setAdapter(new HorAdapter(HorRecyclerViewActivity.this, new HorAdapter.OnItemClickListener() {
            @Override
            public void OnClick(int pos) {
                Toast.makeText(HorRecyclerViewActivity.this,"click"+pos,Toast.LENGTH_SHORT).show();
            }
        }));
    }
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            //每个元素下面添加了1dp间距，空出来背景的颜色
            outRect.set(0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight),0);

        }
    }
}
