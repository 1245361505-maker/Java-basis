package 额外练习;

import java.util.Scanner;

public class Function {
    public int[] Numberinput() {
        Scanner sc = new Scanner(System.in);
        int n, m, t;
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
        return new int[]{n, m, t}; // ✅ 返回结果
    }

    public void Firstline(int n, int m) {
        // 上半部分
        for (int i = 1; i <= (n + 1) / 2; i++) {
            for (int col = 1; col <= m; col++) {
                for (int k = 1; k <= (n + 1) / 2 - i; k++) {
                    System.out.print(" ");
                }
                for (int l = 1; l <= 2 * i - 1; l++) {
                    if (l == 1 || l == 2 * i - 1) {
                        System.out.print("*");
                    } else{
                        System.out.print(" ");
                    }
                }
                for (int k = 1; k <= (n + 1) / 2 - i + 2; k++){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // 下半部分
        for (int i = 1; i <= (n - 1) / 2; i++) {
            for (int col = 1; col <= m; col++) {
                for (int k = 1; k <= i; k++) {System.out.print(" ");}
                for (int l = 1; l <= n - 2 * i; l++) {
                    if (l == 1 || l == n - 2 * i) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                for (int k = 1; k <= i + 2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public void Secondline(int n, int m) {
        // 上半部分（从第二行开始）
        for (int i = 2; i <= (n + 1) / 2; i++) {
            for (int col = 1; col <= m; col++) {
                for (int k = 1; k <= (n + 1) / 2 - i; k++) {
                    System.out.print(" ");
                }
                for (int l = 1; l <= 2 * i - 1; l++) {
                    if (l == 1 || l == 2 * i - 1) {
                        System.out.print("*");
                    } else{
                        System.out.print(" ");
                    }
                }
                for (int k = 1; k <= (n + 1) / 2 - i + 2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // 下半部分
        for (int i = 1; i <= (n - 1) / 2; i++) {
            for (int col = 1; col <= m; col++) {
                for (int k = 1; k <= i; k++) {
                    System.out.print(" ");
                }
                for (int l = 1; l <= n - 2 * i; l++) {
                    if (l == 1 || l == n - 2 * i) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                for (int k = 1; k <= i + 2; k++) {System.out.print(" ");}
            }
            System.out.println();
        }
    }
}

