package com.iflytek.test;

import android.util.Log;

/**
 * Created by jiwang on 2018/2/7.
 * <p>
 * 备注:
 * 1.所有同步块必须是多线程情况下才需要添加,单个对象,单个线程时,方法执行是顺序执行的,一个方法执行完之后才去执行下一个方法,同一个方法也如此,并且不管是在哪里调用.
 * 2.多线程情况下同步块,synchronized锁住的对象要一致才能生效.synchronized(this)和synchronized方法都是锁的当前对象,但是不包括synchronized的静态方法
 * 3.synchronized同步静态方法块和  synchronized(类名.class) 是锁的同一个对象
 */
public class TestSync {
    public static final String lock = "123";
    private static final String TAG = "TestSync";
    static int mInt = 200;

    public synchronized void testSleep() {
        Log.d(TAG, "testSleep start");
        Log.d(TAG, "testSleep TestSync.this = " + TestSync.this);
        Log.d(TAG, "testSleep TestSync.this = " + TestSync.class);
        Log.d(TAG, "testSleep TestSync.getClass = " + TestSync.super.getClass());
        synchronized (TestSync.class) {
            for (; mInt < 500; mInt++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d(TAG, "cur index =" + mInt);
            }
        }
        Log.d(TAG, "testSleep end");
    }

    public void testSleep1() {
        Log.d(TAG, "testSleep11111 start");
        Log.d(TAG, "testSleep11111 this = " + this);
        Log.d(TAG, "testSleep11111 TestSync.this = " + TestSync.class);
        Log.d(TAG, "testSleep11111 TestSync.getClass = " + TestSync.super.getClass());
        synchronized (TestSync.class) {
            for (; mInt > 0; mInt--) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.e(TAG, "cur index =" + mInt);
            }
        }
        Log.d(TAG, "testSleep11111 end");
    }
}
