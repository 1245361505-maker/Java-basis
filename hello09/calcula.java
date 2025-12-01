package hello09;

import java.util.Scanner;

public class calcula {
    public static void main(String[] args) {
        CALC calc=new CALC();
        Scanner sc=new Scanner(System.in);
        System.out.println("输入第一个正数：");
        int a=sc.nextInt();
        System.out.println("输入第二个正数：");
        int b=sc.nextInt();
        System.out.println("请输入运算符");
        char oper=sc.next().charAt(0);
        int result=calc.calcData(a,b,oper);
        if(result==0){
            System.out.println("除数不能为0");
        }else if(result==-2){
            System.out.println("运算符错误");
        }else{
            System.out.println(result);
        }
    }
}
