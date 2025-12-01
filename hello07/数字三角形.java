package hello07;

import java.util.Scanner;

public class 数字三角形 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [][]numbers=new int[n+1][n+1];
        int num=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                numbers[i][j]=num;
                num++;

            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(numbers[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
