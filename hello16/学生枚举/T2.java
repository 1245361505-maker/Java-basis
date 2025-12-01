package JavaBasis.hello16.学生枚举;

public class T2 {
    static void main(String[] args) {
        Student stu=new Student();
        stu.name="张三";
        stu.sex=Gender.MALE;
        System.out.println(stu.name+"\n"+stu.sex);
    }
}
