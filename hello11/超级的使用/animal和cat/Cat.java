package hello11.超级的使用.animal和cat;

public class Cat extends Animal {
    public void show(){
        super.age=20;
    }
    public Cat(){
        super(2);
        System.out.println("cat构造");
    }
}
