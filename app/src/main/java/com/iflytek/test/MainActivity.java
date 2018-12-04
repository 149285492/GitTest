package com.iflytek.test;

import android.content.Intent;
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
        //测试提交
        Intent intent = new Intent();
        //reset current branch to hear 之后还要合并提交一次
        //revert则直接恢复到那个状态,新增一次提交

        //测试commit 1
        // 2131231

        // 测试commit reset current branch to here

        //ceshi
    }
}
