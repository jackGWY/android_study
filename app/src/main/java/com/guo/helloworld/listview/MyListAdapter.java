package com.guo.helloworld.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.guo.helloworld.R;

/**
 * Created by guo_w on 2017/11/23.
 */

public class MyListAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    public MyListAdapter(Context context){
        this.mContext=context;
        mLayoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {//列表长度
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    static class ViewHolder{
        public ImageView imageView;
        public TextView tvTitle,tvTime,tvContent;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //列表每一行张什么样子
        ViewHolder holder=null;
        if(convertView==null){//视图空
            convertView=mLayoutInflater.inflate(R.layout.layout_list_item,null);
            holder=new ViewHolder();
            holder.imageView=(ImageView)convertView.findViewById(R.id.iv);
            holder.tvTitle=(TextView)convertView.findViewById(R.id.tv_title);
            holder.tvTime=(TextView)convertView.findViewById(R.id.tv_time);
            holder.tvContent=(TextView)convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);//settag 方法 类赋值
        }
        else{
            holder=(ViewHolder) convertView.getTag();
        }
        holder.tvTitle.setText("这是标题");
        holder.tvTime.setText("2088-08-08");
        holder.tvContent.setText("这是内容");
        Glide.with(mContext).load("https://www.baidu.com/img/bd_logo1.png").into(holder.imageView);
        return null;
    }
}
