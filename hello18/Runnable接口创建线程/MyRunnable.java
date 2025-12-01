package hello18.Runnable接口创建线程;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"===="+i);
        }
    }
}
