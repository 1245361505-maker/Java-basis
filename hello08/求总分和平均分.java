package hello08;

import java.util.Scanner;

public class 求总分和平均分 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Calcu calcu=new Calcu();
        System.out.println("请输入语文成绩");
        calcu.chinese=input.nextInt();
        System.out.println("请输入英语成绩");
        calcu.english=input.nextInt();
        System.out.println("请输入数学成绩");
        calcu.math=input.nextInt();
        int total=calcu.gettotal();
        double avg=calcu.getavg();
        String result=String.format("%.2f",avg);
        System.out.println("总分为"+total);
        System.out.println("平均分为"+result);
    }
}
