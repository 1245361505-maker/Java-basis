package 额外练习.矩阵变换1;

import java.util.Scanner;

// 实现类：实现具体的矩阵输入与转置逻辑
public class Matrixs extends Matrix {
    private int row;
    private int col;
    private int[][] matr;

    public Matrixs(int row, int col) {
        this.row = row;
        this.col = col;
        this.matr = new int[row][col];
    }

    // 从键盘输入矩阵
    public void inputMatrix() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请按行输入矩阵，每行输入 " + col + " 个整数，用空格分隔：");
        for (int i = 0; i < row; i++) {
            System.out.print("第 " + (i + 1) + " 行：");
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            if (parts.length != col) {
                System.out.println("输入的列数不正确，请重新输入该行！");
                i--;
                continue;
            }
            for (int j = 0; j < col; j++) {
                matr[i][j] = Integer.parseInt(parts[j]);
            }
        }
    }

    // 打印矩阵
    public void printMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 实现抽象方法：转置并输出
    @Override
    public void Transfer() {
        System.out.println("矩阵转置后为：");
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                System.out.print(matr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
