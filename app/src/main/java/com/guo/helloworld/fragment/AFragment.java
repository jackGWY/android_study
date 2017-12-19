package com.guo.helloworld.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.guo.helloworld.R;

/**
 * Created by guo_w on 2017/11/26.
 */
//继承与Fragment
public class AFragment extends Fragment {
    private TextView mTvTitle_fragment;
    private IOnMessageClick listener;
    //private Activity mActivity;
    private Button mBtnChange,mBtnReset,mBtnMessage;
    private BFragment bFragment;
    public static AFragment newInstance(String title){
        AFragment fragment=new AFragment();
        Bundle bundle=new Bundle();
        bundle.putString("title",title);
        fragment.setArguments(bundle);//framment 带有消息
        return fragment;
    }
    public interface IOnMessageClick{
        void onClick(String text);
    }

    @Override
    //Called when a fragment is first attached to its context.
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener=(IOnMessageClick) context;//这一步很关键
        }catch (ClassCastException e){
            throw new ClassCastException("Activity必须实现 IOnMessageClick接口");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_a,container,false);//给一个布局文件
        Log.d("AFragment","--onCreateView--");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {//当View创建完以后
        super.onViewCreated(view, savedInstanceState);

        mTvTitle_fragment=(TextView) view.findViewById(R.id.tv_title_fragment);
        mBtnChange=(Button) view.findViewById(R.id.btn_change);
        mBtnReset=(Button)view.findViewById(R.id.btn_reset);
        mBtnMessage=(Button)view.findViewById(R.id.btn_message);
        mBtnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //((ContainerActivity)getActivity()).setData("你好");
                listener.onClick("今天天气真好");//回掉接口
            }
        });
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bFragment==null){
                    bFragment=new BFragment();
                }
                //replace是remv和add的叠加
                Fragment fragment=getFragmentManager().findFragmentByTag("a");
                if(fragment!=null){
                    //跟换文字后返回任然可以保持新的文字--addToBackStack
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.f1_container,bFragment)
                            .addToBackStack(null).commitAllowingStateLoss();
                }else {
                    getFragmentManager().beginTransaction().replace(R.id.f1_container,bFragment)
                            .addToBackStack(null).commitAllowingStateLoss();//将bfragment加入回退站中，解决回退问题
                }
            }
        });
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvTitle_fragment.setText("我是新文字");
            }
        });
        if(getArguments()!=null){
            mTvTitle_fragment.setText(getArguments().getString("title"));
        }
    }

//    @Override
//    public void onAttach(Context context) {//重建关系
//        super.onAttach(context);
//        //mActivity=(Activity) context;
//    }

//    @Override
//    public void onDetach() {//解除fragment和activity约束
//        super.onDetach();
//    }

//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        //取消异步任务不要回来，因为activity已经没有了
//    }
}
