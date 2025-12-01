package hello18.Runnable接口创建线程;

import hello18.创建线程.MyThread;

public class T4 {
    public static void main(String[] args) {
        MyRunnable r1 = new MyRunnable();
        Thread t1=new Thread(r1);
        t1.start();
    }
}
