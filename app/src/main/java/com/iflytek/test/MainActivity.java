package com.iflytek.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private TestSync mTestSync;
    private TestSync mTestSync1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_test).setOnClickListener(this);
        findViewById(R.id.btn_test1).setOnClickListener(this);
        mTestSync = new TestSync();
        mTestSync1 = new TestSync();
        //创建分支develop,init this is master
        //创建分支develop,this is develop change
    }

    public void inMaster() {
        Log.d(TAG, "this is in Master git");

        Log.d(TAG, "change method in Master git");

    }

    public void inDevelopMethod() {
        Log.d(TAG, "this is a develop project");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mTestSync.testSleep();
                    }
                }).start();
                break;
            case R.id.btn_test1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mTestSync1.testSleep1();
                    }
                }).start();
                break;
        }
    }
}
