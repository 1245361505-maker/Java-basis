package hello07;

import java.util.Scanner;

public class 矩阵的和 {
    static void main() {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [][] num1=new int [n+1][m+1];
        int [][] num2=new int [n+1][m+1];
        int [][] sum=new int [n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                num1[i][j]=sc.nextInt();
            }
        }
        for(int i=1;i<=n;i++) {
            for (int j = 1; j <= m; j++) {
                num2[i][j] = sc.nextInt();
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                sum[i][j]=num1[i][j]+num2[i][j];
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                System.out.print(sum[i][j]+"\t");
            }
            System.out.println();
        }

    }
}
