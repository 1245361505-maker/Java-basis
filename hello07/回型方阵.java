package hello07;

import java.util.Scanner;

public class 回型方阵 {
    public  static void main(String[] args) {
        int [][]numbers=new int[10][10];
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=(n+1)/2;i++){
            for(int j=1;j<=(n+1)/2;j++){
                numbers[i][j]=Math.min(i,j);//左上角
                numbers[i][n+1-j]=Math.min(i,j);//右上角
                numbers[n+1-i][j]=Math.min(i,j);//左下角
                numbers[n+1-i][n+1-j]=Math.min(i,j);//右下角

            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(numbers[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
