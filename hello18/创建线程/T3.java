package hello18.创建线程;

public class T3 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"====");
        MyThread m1 = new MyThread();
        MyThread m2 = new MyThread();
        MyThread m3 = new MyThread();
        m1.start();
        m2.start();
        m3.start();
    }
}
