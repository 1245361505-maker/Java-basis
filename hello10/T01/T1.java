package hello10.T01;

public class T1 {
    public static void main(String[] args) {
        hello10.T01.Dog d=new hello10.T01.Dog();
        d.setName("小黑");
        String name=d.getName();
        System.out.println(name);
        d.setAge(-100);
        System.out.println(d.getAge());
    }
}
