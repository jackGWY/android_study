package com.guo.helloworld.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.guo.helloworld.R;

public class GridRecycleViewActivity extends AppCompatActivity {
    private RecyclerView mRvGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycle_view);
        mRvGrid=(RecyclerView) findViewById(R.id.rv_grid);
        mRvGrid.setLayoutManager(new GridLayoutManager(GridRecycleViewActivity.this,3));//3表示一行显示几个
        mRvGrid.setAdapter(new GridAdapter(GridRecycleViewActivity.this, new GridAdapter.OnItemClickListener() {
            @Override
            public void OnClick(int pos) {
                Toast.makeText(GridRecycleViewActivity.this,"click"+pos,Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
