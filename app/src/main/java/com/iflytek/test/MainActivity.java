package com.iflytek.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        //1.回退本地commit
        //soft 方式,当前代码不变
        //Mixed 方式,当前代码不变,只是撤销commit
        //Hard 方式 会回退到指定版本的代码,丢弃当前代码
        //Keep 方式 貌似和Hard差不多,并丢弃当前代码

        //2 revert 回退到当前commit,并且又一次merge(包含:本地代码更改,本地commit树,服务器代码),并且声称一次提交,丢弃当前代码
        // 可以再使用reset current branch to here soft 方式,将这次revert合并
        // 本地代码变动
        //会弹出弹框选择第一个会丢弃当前代码,选择第二个会保存当前代码
        // 测试选择第二个,会保存当前代码吗,会保存
    }
}
