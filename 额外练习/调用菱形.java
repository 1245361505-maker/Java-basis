package 额外练习;

import java.util.Scanner;

public class 调用菱形 {
    public static void main(String[] args) {
        Function f = new Function();
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入 n m t（n为奇数）: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        f.Firstline(n, m); // 第一行完整菱形
        for (int i = 2; i <= t; i++) { // 剩下的 t-1 行残缺菱形
            f.Secondline(n, m);
        }
    }
}
