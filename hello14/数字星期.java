package hello14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class 数字星期 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入1-7之间的整数");
        try{
            int num= input.nextInt();
            switch(num){
                case 1:
                    System.out.println("星期一");
                    break;
                case 2:
                    System.out.println("星期二");
                    break;
                case 3:
                    System.out.println("星期三");
                    break;
                case 4:
                    System.out.println("星期四");
                    break;
                case 5:
                    System.out.println("星期五");
                    break;
                case 6:
                    System.out.println("星期六");
                    break;
                case 7:
                    System.out.println("星期七");
                    break;
                default:
                    System.out.println("无匹配数据");
                    break;
            }

        }catch(InputMismatchException ex){
            System.out.println("输入的不是数字");
        } catch (Exception ex) {
            System.out.println("未知异常");
        }finally{
            System.out.println("程序结束");
        }
    }
}
