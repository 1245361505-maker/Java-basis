package 额外练习;

import java.util.Scanner;

public class 空心菱形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int m;
        System.out.println("please log in two numbers");
        while (true) {
            n=sc.nextInt();
            m=sc.nextInt();
            if (n%2==1){
                break;
            }
            System.out.println("please log in again");
        }
        for (int g = 1; g <= m; g++) {
            for(int i=1;i<=(n+1)/2;i++){
                for(int j=1;j<=(n+1)/2-i;j++){
                    System.out.print(" "+"\t");
                }
                for(int j=1;j<=2*i-1;j++){
                    if(j==1||j==2*i-1){
                        System.out.print("*"+"\t");
                    }else{
                        System.out.print(" "+"\t");
                    }
                }
                System.out.println();
            }
            for(int i=(n+1)/2+1;i<=n;i++){
                for(int j=1;j<=i-(n+1)/2;j++){
                    System.out.print(" "+"\t");
                }
                for(int j=1;j<=-2*i+2*n+1;j++){
                    if(j==-2*i+2*n+1||j==1){
                        System.out.print("*"+"\t");
                    }else{
                        System.out.print(" "+"\t");
                    }
                }
                System.out.println();
            }
        }
    }
}