package hello03;

import java.util.Scanner;

public class T4判断素数 {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();

        // 处理特殊情况
        if (n <= 1) {
            System.out.println(n + "不是素数");
            num.close();
            return;
        }

        // 检查是否为素数
        for (int a = 2; a * a <= n; a++) {
            if (n % a == 0) {
                System.out.println(n + "不是素数");
                num.close();
                return;
            }
        }

        // 如果循环结束都没有找到因子，就是素数
        System.out.println(n + "是素数");
        num.close();
    }
}

