package JavaBasis.Hello05;

import java.util.Scanner;

public class 二重循环2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for (int i = 1; i <= a; i++) {
            // 打印前导空格
            for (int j = 1; j <= a - i; j++) {
                System.out.print(" ");
            }
            // 打印星号（2*i - 1 个）
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            // 换行
            System.out.println();
        }
    }
}