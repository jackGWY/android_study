package com.guo.helloworld.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guo.helloworld.R;

/**
 * Created by guo_w on 2017/11/26.
 */

public class BFragment extends Fragment {
    private TextView mTvTitle_fragment;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_b,container,false);//给一个布局文件
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {//当View创建完以后
        super.onViewCreated(view, savedInstanceState);

        mTvTitle_fragment=(TextView) view.findViewById(R.id.tv_title_fragment);
    }
}
