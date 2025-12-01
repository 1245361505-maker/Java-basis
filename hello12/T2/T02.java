package hello12.T2;

public class T02 {
    //综合调度
    public static void main(String[] args) {
        Dog dog = new Dog("小黑",100);
        Cat cat = new Cat("可乐",100);
        Master master = new Master();
        master.feed(dog,30);
        master.feed(cat,50);
    }
}