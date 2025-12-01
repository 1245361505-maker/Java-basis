package hello07;

import java.util.Scanner;

public class 矩阵旋转 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [][]num=new int[n+1][m+1];
        int [][]num1=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                num[i][j]=sc.nextInt();
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=m;j>=1;j--){
                System.out.print(num[j][i]+"\t");;
            }
            System.out.println();
        }

    }
}
