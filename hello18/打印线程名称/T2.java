package hello18.打印线程名称;

public class T2 {
    public static void main(String[] args) {
        Thread thread=Thread.currentThread();
        System.out.println("主线程为+"+thread.getName());
        thread.setName("Java-main");
        System.out.println("主线程为+"+thread.getName());
    }
}
