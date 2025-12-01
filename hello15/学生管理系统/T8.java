package JavaBasis.hello15.学生管理系统;

import java.util.Scanner;

public class T8 {
    public static void main(String[] args) {
        StudentMgr mgr=new StudentMgr();
        Scanner input=new Scanner(System.in);
        String yesOrNo="y";
        while(yesOrNo.equals("y")){
            System.out.println("请输入学号");
            String stuno=input.next();
            System.out.println("请输入姓名");
            String stuname=input.next();
            System.out.println("请输入年龄");
            int stuage=input.nextInt();
            Student stu=new Student(stuno,stuname,stuage);
            boolean flag=mgr.addStudent(stu);
            if(flag){
                System.out.println("添加成功");
                System.out.println("还要继续添加吗？");
                yesOrNo=input.next();
            }else{
                System.out.println("添加失败");
            }
        }
        mgr.printAll();
    }
}
