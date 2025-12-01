package hello18.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T07 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Runnable t1 = new MyTask("Task1");
        Runnable t2 = new MyTask("Task2");
        Runnable t3 = new MyTask("Task3");
        pool.submit(t1);
        pool.submit(t2);
        pool.submit(t3);
        pool.shutdown();
    }
}
