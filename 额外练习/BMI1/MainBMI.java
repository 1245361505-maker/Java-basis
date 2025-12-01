package 额外练习.BMI1;

import java.util.Scanner;

public class MainBMI {
    public static void main(String[] args) {
        // 创建一个 BMIana 对象
        BMIana bmiAnalyzer = new BMIana();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("业务代码：1.学生BMI分析。2.退出程序");
            System.out.println("请输入业务代码（0或1）");
            int num = sc.nextInt();
            if(num==1){
                bmiAnalyzer.BMIstu();
                System.out.println("分析完成，感谢使用");
            }else if(num==2){
                System.out.println("感谢使用，祝您生活愉快");
            }else{
                System.out.println("输入有误，请重新输入");
            }
        }
    }
}