package 额外练习;

import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class 大羁绊 {
    private static final Logger logger = Logger.getLogger(大羁绊.class);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please log in a number");
        int n = 1;

        while (true) {
            try {
                n = sc.nextInt();
                logger.info("User input: " + n);

                if (n > 1) {
                    System.out.println("Accepted: " + n);
                    logger.info("Input accepted: " + n);
                    break;
                } else if (n == 1) {
                    System.out.println("num1 size is too small, please log in a bigger number");
                    logger.warn("Input too small: " + n);
                } else {
                    System.out.println("please log in a correct number");
                    logger.warn("Invalid number: " + n);
                }

            } catch (InputMismatchException e) {
                String invalid = sc.next(); // 清除错误输入
                System.out.println("Error: Please enter a valid integer!");
                logger.error("Invalid input (non-integer): " + invalid);
                logger.error("Exception caught: ", e); // 记录完整异常堆栈
            }
        }

        System.out.println("You entered: " + n);
        logger.info("Final accepted input: " + n);
        sc.close();



        if(n%2==1){
            for(int i=1;i<=(n-1)/2;i+=1){
                for(int j=1;j<=(3*n-1)/2+(n+1)/2-i;j+=1){
                    System.out.print(" "+"\t");
                }
                for(int j=1;j<=2*i-1;j+=1){
                    System.out.print("*"+"\t");
                }
                System.out.println();
            }
            for(int i=1;i<=3*n;i+=1){
                for(int j=1;j<=n+(n-1)/2;j+=1){
                    System.out.print(" "+"\t");
                }
                for(int j=1;j<=n;j+=1){
                    System.out.print("*"+"\t");
                }
                System.out.println();
            }
            for(int j=1;j<=n;j+=1){
                if(j!=(n+1)/2){
                    for(int i=1;i<=n;i+=1){
                        System.out.print("*"+"\t");
                    }
                    for (int i = 0; i < (n-1)/2; i++) {
                        System.out.print(" "+"\t");
                    }
                    for(int i=1;i<=n;i+=1){
                        System.out.print("*"+"\t");
                    }
                    for (int i = 0; i < (n-1)/2; i++) {
                        System.out.print(" "+"\t");
                    }
                    for(int i=1;i<=n;i+=1) {
                        System.out.print("*"+"\t");
                    }
                    System.out.println();
                }else{
                    for(int i=1;i<=4*n-1;i+=1){
                        System.out.print("*"+"\t");
                    }
                    System.out.println();
                }
            }
        }else if(n!=2){
            for (int i=1;i<=n/2-1;i+=1){
                for(int j=1;j<=n+n/2+n/2-i;j+=1){
                    System.out.print(" "+"\t");
                }
                for(int j=1;j<=2*i;j+=1){
                    System.out.print("*"+"\t");
                }
                System.out.println();
            }
            for(int i=1;i<=3*n;i+=1) {
                for (int j = 1; j <= n + n / 2; j++) {
                    System.out.print(" " + "\t");
                }
                for (int j = 1; j <=n; j++) {
                    System.out.print("*"+"\t");
                }
                System.out.println();
            }
            for(int i=1;i<=n;i+=1) {
                for (int j = 1; j <= n; j++) {
                    System.out.print("*"+"\t");
                }
                if(i==n/2||i==n/2+1){
                    for(int j=1;j<=n/2;j+=1){
                        System.out.print("*"+"\t");
                    }
                }else{
                    for(int j=1;j<=n/2;j+=1) {
                        System.out.print(" " + "\t");
                    }
                }
                for(int j=1;j<=n;j+=1) {
                    System.out.print("*"+"\t");
                }
                if(i==n/2||i==n/2+1){
                    for(int j=1;j<=n/2;j+=1){
                        System.out.print("*"+"\t");
                    }
                }else{
                    for(int j=1;j<=n/2;j+=1) {
                        System.out.print(" " + "\t");
                    }
                }
                for (int j = 1; j <= n; j++) {
                    System.out.print("*"+"\t");
                }
                System.out.println();
            }
        }else{
            for(int i=1;i<=6;i+=1){
                if(i<=4){
                    for(int j=1;j<=2;j+=1){
                        System.out.print(" "+"\t");
                    }
                    for(int j=1;j<=2;j+=1){
                        System.out.print("*"+"\t");
                    }
                    System.out.println();
                }else{
                    for(int j=1;j<=6;j+=1){
                        System.out.print("*" + "\t");
                    }
                    System.out.println();
                }
            }
        }
    }
}
