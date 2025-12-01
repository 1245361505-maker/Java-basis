package 额外练习;

import java.util.Scanner;

public class 空心沙漏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please input two numbers");
        int n,m;
        while (true) {
            n = sc.nextInt();
            m = sc.nextInt();
            if (n % 2 == 1) {
                break;
            }
            System.out.println("please input two numbers again");
        }
        for(int i=1;i<=(n+1)/2;i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" "+"\t");
            }
            for (int j = 1; j <= -2 * i + n + 2; j++) {
                if(i==1||j == -2*i+n+2||j==1 ){
                    System.out.print("*"+"\t");
                }else{
                    System.out.print(" "+"\t");
                }
            }
            System.out.println();
        }
        for (int i=1;i<=(n-1)/2;i++) {
            for (int j = 1; j <= -i + (n + 1) / 2; j++) {
                System.out.print(" "+"\t");
            }
            for (int j = 1; j <= 2 * i + 1; j++) {
                if(j == 2*i+1||j==1 ){
                    System.out.print("*"+"\t");
                }else{
                    System.out.print(" "+"\t");
                }
            }
            System.out.println();
        }
        for(int g=1;g<=m-1;g++) {
            for (int i = 2; i <= (n + 1) / 2; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(" "+"\t");
                }
                for (int j = 1; j <= -2 * i + n+2 ; j++) {
                    if(j == -2*i+n+2||j==1 ){
                        System.out.print("*"+"\t");
                    }else{
                        System.out.print(" "+"\t");
                    }
                }
                System.out.println();
            }
            for (int i = 1; i <= (n - 1) / 2; i++) {
                for (int j = 1; j <= -i + (n + 1) / 2; j++) {
                    System.out.print(" "+"\t");
                }
                for (int j = 1; j <= 2 * i + 1; j++) {
                    if(j == 2*i+1||j==1 ){
                        System.out.print("*"+"\t");
                    }else{
                        System.out.print(" "+"\t");
                    }
                }
                System.out.println();
            }
        }
        for (int i = 2; i <= (n + 1) / 2; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" "+"\t");
            }
            for (int j = 1; j <= -2 * i + n+2 ; j++) {
                if(j == -2*i+n+2||j==1 ){
                    System.out.print("*"+"\t");
                }else{
                    System.out.print(" "+"\t");
                }
            }
            System.out.println();
        }
        for (int i = 1; i <= (n - 1) / 2; i++) {
            for (int j = 1; j <= -i + (n + 1) / 2; j++) {
                System.out.print(" "+"\t");
            }
            for (int j = 1; j <= 2 * i + 1; j++) {
                if(j == 2*i+1||j==1 ||i==(n-1)/2){
                    System.out.print("*"+"\t");
                }else{
                    System.out.print(" "+"\t");
                }
            }
            System.out.println();
        }
    }
}
