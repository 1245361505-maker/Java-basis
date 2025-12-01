package hello14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class 多路异常捕获 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("请输入第一个操作数");
            int num1 = input.nextInt();
            System.out.println("请输入第二个操作数");
            int num2 = input.nextInt();
            int result = num1 / num2;
            System.out.println("结果为" + result);
        } catch (InputMismatchException ex) {
            System.err.println("必须为整数");
        } catch(ArithmeticException ex){
            System.out.println("除数不能为0");
        } catch(Exception ex){
            System.out.println("未知异常");
        }finally{
            System.out.println("程序结束");
        }
    }
}
