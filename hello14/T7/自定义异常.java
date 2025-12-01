package hello14.T7;

import java.util.Scanner;

class AgeException extends Exception{
    public AgeException(String msg){
        super(msg);
    }
}

public class 自定义异常 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入姓名");
        String name=input.next();
        System.out.println("请输入年龄");
        int age=input.nextInt();
        try {
            if(age<0){
                throw new AgeException("年龄不能为负数");
            }
            System.out.println("姓名"+name);
            System.out.println("年龄"+age);
        } catch (AgeException e) {
            System.out.println(e.getMessage());;
        }finally{
            System.out.println("程序结束");
        }
    }
}
