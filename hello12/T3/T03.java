package hello12.T3;

public class T03 {
    public static void main(String[] args) {
        Dog dog = new Dog("小黑",100);
        Cat cat = new Cat("可乐",100);
        Master master=new Master();
        master.work(dog);
        master.work(cat);
        cat.eat(30);
        dog.eat(50);
    }
}
