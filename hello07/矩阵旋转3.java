import java.util.Scanner;

public class 矩阵旋转3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 行
        int m = sc.nextInt();  // 列
        int[][] num = new int[n][m];
        int[][] num1 = new int[m][n];

        // 输入原矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                num[i][j] = sc.nextInt();
            }
        }

        // 顺时针旋转 90 度
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                num1[j][n - 1 - i] = num[i][j];
            }
        }

        // 输出旋转后的矩阵
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(num1[i][j] + "\t");
            }
            System.out.println();
        }
    }
}