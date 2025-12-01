package hello03;
//练习阶乘
import java.util.Scanner;

public class 阶乘 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个数字: ");
        int a = scanner.nextInt();

        long result = 1;  // 使用long类型防止溢出

        for (int i = 1; i <= a; i++) {
            result *= i;
        }

        System.out.println(a + "的阶乘是: " + result);
        scanner.close();
    }
}