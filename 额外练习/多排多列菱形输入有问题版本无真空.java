package 额外练习;

import java.util.Scanner;

public class 多排多列菱形输入有问题版本无真空 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m,t; // n为菱形行数，m为列数，n必须为奇数,t为一列内菱形的个数

        while (true) {
            System.out.println("请输入三个正整数（n为奇数）:");
            n = sc.nextInt();
            m = sc.nextInt();
            t = sc.nextInt();
            if (n >= 1 && m >= 1 && n % 2 == 1) {
                break;
            } else {
                System.out.println("输入不符合要求，请重新输入！");
            }
        }
        for (int a = 1; a <= t; a++) {
            for (int i = 1; i <= (n + 1) / 2; i++) { // 控制行
                for (int j = 1; j <=m; j++) {       // 控制列
                    for (int k = 1; k <= (n + 1) / 2 - i; k++) {
                        System.out.print(" ");
                    }
                    for (int l = 1; l <= 2 * i - 1; l++) {
                        System.out.print("*");
                    }
                    for (int k = 1; k <= (n + 1) / 2 - i; k++) {
                        System.out.print(" ");
                    }
                    System.out.print("  "); // 不同行之间的间隔
                }
                System.out.println(); // 换行
            }
            for (int i = 1; i <= (n-1) / 2; i++) {
                for (int j = 1; j <= m; j++) {
                    for (int k = 1; k <= i; k++) {
                        System.out.print(" ");
                    }
                    for (int l = 1; l <= -2 * i+n; l++) {
                        System.out.print("*");
                    }
                    for (int k = 1; k <= i; k++) {
                        System.out.print(" ");
                    }
                    System.out.print("  ");
                }
                System.out.println();
            }
        }
        // 输出图形

        sc.close();
    }
}
