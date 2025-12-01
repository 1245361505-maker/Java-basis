package hello03;

import java.util.Scanner;

public class 条件2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        if (a==b){
            System.out.println("=");
        }else if (a>b){
            System.out.println("a");
        }else {
            System.out.println("b");
        }
    }
}
