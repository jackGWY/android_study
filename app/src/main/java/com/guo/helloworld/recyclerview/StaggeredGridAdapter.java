package com.guo.helloworld.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.guo.helloworld.R;

/**
 * Created by guo_w on 2017/11/25.
 */

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.LinearViewHolder> {
    private Context mContext;
    private OnItemClickListener mlistener;
    //private List<String> list;
    public StaggeredGridAdapter(Context context, OnItemClickListener listener){//构造器输入private属性
        this.mContext=context;
        this.mlistener=listener;
    }
    @Override
    public StaggeredGridAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate
                (R.layout.layout_staggered_grid_recycleview_item,parent,false));
        //每一个item的布局
    }

    @Override
    public void onBindViewHolder(StaggeredGridAdapter.LinearViewHolder holder, final int position) {
        if(position %2==0){
            holder.imageView.setImageResource(R.drawable.image1);
        }
        else{
            holder.imageView.setImageResource(R.drawable.image2);
        }
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
        return 30;
    }//RecycleView 重复30个

    class LinearViewHolder extends RecyclerView.ViewHolder{//找到线性布局，从xml文件中
        private ImageView imageView;
        public LinearViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.iv_6);//这个很重要，找到那个imageView
        }
    }

    public interface OnItemClickListener{
        void OnClick(int pos);
    }
    //长按的方法
}
