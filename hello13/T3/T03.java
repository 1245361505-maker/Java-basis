package hello13.T3;

import java.util.Scanner;

public class T03 {
    static void main() {
        System.out.println("请输入第一个操作数");
        Scanner input=new Scanner(System.in);
        int num1=input.nextInt();
        System.out.println("请输入第二个操作数");
        int num2=input.nextInt();
        Calculator[] calculators={new Add(),new Sub(),new Mul(),new Div()};
        for(Calculator calc:calculators){
            double result=calc.calc(num1,num2);
            System.out.println(result);
        }
    }
}
