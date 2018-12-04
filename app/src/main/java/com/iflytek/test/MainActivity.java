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
        //测试提交

        //测试提交

        //测试提交1

        //测试提交2 mixed 可以回退commit,从新提交 Hard 不仅回退commit,并且代码也回退

        //测试3

        //测试reset

        //测试interactivity

        //check out version
    }
}
