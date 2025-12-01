package 额外练习.学校内容1至3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class calculateSumAvg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;

        System.out.println("please input ten numbers");

        for (int i = 1; i <= 10; i++) {
            while (true) {
                System.out.println("please input No." + i + " number:");
                try {
                    int num = sc.nextInt();
                    total += num;
                    break; // 正确输入 → 跳出 while 进入下一次 for
                } catch (InputMismatchException e) {
                    e.printStackTrace();
                    System.out.println("Invalid input! Please enter an integer!");
                    sc.next();  // 清除错误输入
                }
            }
        }

        double avg = total / 10.0;

        System.out.println("please input operation number (1 for sum, 2 for avg)");
        while (true) {
            try {
                int op = sc.nextInt();
                if (op == 1) {
                    System.out.println("the sum is " + total);
                } else if (op == 2) {
                    System.out.println("the avg is " + avg);
                } else {
                    System.out.println("wrong operation number");
                }
                break;
            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.println("Invalid operation number! Please input again!");
                sc.next(); // 清除错误输入
            }
        }
    }
}
