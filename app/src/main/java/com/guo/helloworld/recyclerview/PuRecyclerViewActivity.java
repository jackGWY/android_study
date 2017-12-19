package com.guo.helloworld.recyclerview;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.guo.helloworld.R;

public class PuRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvPu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_recycler_view);

        mRvPu=(RecyclerView) findViewById(R.id.rv_pu);
        mRvPu.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));//表示多少列
        mRvPu.addItemDecoration(new MyDecoration());//设置每一项的Decoration

        mRvPu.setAdapter(new StaggeredGridAdapter(PuRecyclerViewActivity.this, new StaggeredGridAdapter.OnItemClickListener() {
            //构造器注入值
            @Override
            //这个是接口里面的方法，需要实现
            public void OnClick(int pos) {//makeText 最后的参数是时间 int
                Toast.makeText(PuRecyclerViewActivity.this,"click"+pos,Toast.LENGTH_SHORT).show();
            }
        }));
        //查看原来类可以知道构造器传入参数为监听器
    }
    class MyDecoration extends RecyclerView.ItemDecoration{//设置图片间距用的
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);//自动跳出来的方法
            int gap=getResources().getDimensionPixelOffset(R.dimen.dividerHeight2);
            outRect.set(gap,gap,gap,gap);//左上右下
        }
    }
}
