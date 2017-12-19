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

public class HorAdapter extends RecyclerView.Adapter<HorAdapter.LinearViewHolder> {
    private Context mContext;
    private OnItemClickListener mlistener;
    //private List<String> list;
    public HorAdapter(Context context, OnItemClickListener listener){
        this.mContext=context;
        this.mlistener=listener;
    }
    @Override
    public HorAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate
                (R.layout.layout_hor_item,parent,false));//传入itemView
    }

    @Override
    public void onBindViewHolder(HorAdapter.LinearViewHolder holder, final int position) {
        holder.textView.setText("Hello!");
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

    class LinearViewHolder extends RecyclerView.ViewHolder{
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
