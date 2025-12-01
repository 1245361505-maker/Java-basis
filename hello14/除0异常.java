package hello14;

import java.util.Scanner;

public class 除0异常 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入第一个操作数");
        int num1=input.nextInt();
        System.out.println("请输入第二个操作数");
        int num2=input.nextInt();
        int result=0;
        try{
            result=num1/num2;
            System.out.println("结果为"+result);
        }catch(Exception ex){
            System.err.println("除数不能为0");
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            return;
        }finally{
            System.out.println("程序结束");
        }
    }
}
