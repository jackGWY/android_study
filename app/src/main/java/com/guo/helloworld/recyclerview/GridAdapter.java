package com.guo.helloworld.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guo.helloworld.R;

/**
 * Created by guo_w on 2017/11/24.
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.LinearViewHolder> {
    private Context mContext;
    private OnItemClickListener mlistener;
    //private List<String> list;
    public GridAdapter(Context context, OnItemClickListener listener){//构造器输入private属性
        this.mContext=context;
        this.mlistener=listener;
    }
    @Override
    public GridAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate
                (R.layout.layout_grid_recycleview_item,parent,false));
        //每一个item的布局
    }

    @Override
    public void onBindViewHolder(GridAdapter.LinearViewHolder holder, final int position) {
        holder.textView.setText("Hello!");//每一项的文字内容
        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                mlistener.OnClick(position);
                //Toast.makeText(mContext,"click..."+position,Toast.LENGTH_SHORT).show();
            }
        });
        //holder.itemView.setOnLongClickListener();
    }

    @Override
    public int getItemCount() {//itemCount 列表长度
        return 80;
    }//RecycleView 重复30个

    class LinearViewHolder extends RecyclerView.ViewHolder{//找到线性布局，从xml文件中
        private TextView textView;
        public LinearViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_title);
        }
    }

    public interface OnItemClickListener{
        void OnClick(int pos);
    }
    //长按的方法
}
