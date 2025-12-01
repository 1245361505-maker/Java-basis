package 额外练习.矩阵变换1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = 0, col = 0;
        // 检查行数
        while (true) {
            System.out.print("请输入矩阵的行数（正整数）：");
            try {
                row = sc.nextInt();
                if (row > 0) break;
                else System.out.println("行数必须是正整数，请重新输入！");
            } catch (InputMismatchException e) {
                System.out.println("输入无效，请输入正整数！");
                sc.nextLine(); // 清除错误输入
            }
        }
        // 检查列数
        while (true) {
            System.out.print("请输入矩阵的列数（正整数）：");
            try {
                col = sc.nextInt();
                if (col > 0) {
                    break;
                } else {
                    System.out.println("列数必须是正整数，请重新输入！");
                }
            } catch (InputMismatchException e) {
                System.out.println("输入无效，请输入正整数！");
                sc.nextLine(); // 清除错误输入
            }
        }
        sc.nextLine(); // 清除换行符
        Matrixs matrix = new Matrixs(row, col);
        matrix.inputMatrix();
        System.out.println("\n输入的矩阵为：");
        matrix.printMatrix();
        System.out.println("\n转置结果：");
        matrix.Transfer();
    }
}

