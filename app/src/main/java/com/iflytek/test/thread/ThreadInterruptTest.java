package com.iflytek.test.thread;

import java.util.Arrays;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by jiwang on 2018/2/23.
 * 备注:
 */
public class ThreadInterruptTest extends BaseThread {
    private static final String TAG = "ThreadInterruptTest";
    LinkedBlockingDeque<byte[]> mLinkedBlockingDeque;

    public ThreadInterruptTest() {
        mLinkedBlockingDeque = new LinkedBlockingDeque<>();
    }

    public ThreadInterruptTest(LinkedBlockingDeque<byte[]> linkedBlockingDeque) {
        mLinkedBlockingDeque = linkedBlockingDeque;
    }

    public static void main(String[] args) {
        LinkedBlockingDeque<byte[]> bytes = new LinkedBlockingDeque<>();
        ThreadInterruptTest threadInterruptTest = new ThreadInterruptTest(bytes);
        threadInterruptTest.mLinkedBlockingDeque.add(new byte[]{1});
        threadInterruptTest.mLinkedBlockingDeque.add(new byte[]{2});
        threadInterruptTest.mLinkedBlockingDeque.add(new byte[]{3});
        threadInterruptTest.mLinkedBlockingDeque.add(new byte[]{4});
        threadInterruptTest.mLinkedBlockingDeque.add(new byte[]{5});
        threadInterruptTest.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadInterruptTest.stop(0);

    }

    @Override
    protected void threadProc() {
        while (isRunning()) {
            byte[] bytes = null;
            try {
                bytes = mLinkedBlockingDeque.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (bytes != null) {
                // Log.d(TAG, "take data = " + Arrays.toString(bytes));
                System.out.println("take data = " + Arrays.toString(bytes));
            }
        }
    }
}
