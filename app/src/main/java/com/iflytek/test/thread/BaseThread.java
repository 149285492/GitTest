//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iflytek.test.thread;

public abstract class BaseThread extends Thread {
    protected boolean running = false;

    public BaseThread() {
    }

    public static final void sleep(int var0) {
        var0 = var0 / 20 + 1;

        for (int var1 = 0; var1 < var0; ++var1) {
            try {
                Thread.sleep(20L);
            } catch (InterruptedException var2) {
                var2.printStackTrace();
            }
        }

    }

    public final void start() {
        this.running = true;
        super.start();
    }

    public final void stop(int var1) {
        if (this.running) {
            this.running = false;
            super.interrupt();
        }
    }

    public boolean isRunning() {
        return this.running && this.isAlive();
    }

    boolean initInstance() {
        return true;
    }

    int exitInstance() {
        return 0;
    }

    protected abstract void threadProc();

    public final void Sleep(int var1) {
        var1 = var1 / 20 + 1;

        for (int var2 = 0; var2 < var1 && this.running; ++var2) {
            try {
                Thread.sleep(20L);
            } catch (InterruptedException var3) {
                var3.printStackTrace();
            }
        }

    }

    public void run() {
        if (this.initInstance()) {
            this.threadProc();
        }

        int var1 = this.exitInstance();
        // Log.d(this.getClass().getSimpleName(), "thread " + this.getName() + " Exit with code:" + var1 + "\n");
        System.out.println("thread " + this.getName() + " Exit with code:" + var1 + "\n");
    }
}
