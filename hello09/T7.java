package hello09;

import java.util.Scanner;

public class T7 {
    public static int func(int n){
        if(n==1){
            return 1;
        }else{
            return n*func(n-1);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        System.out.println(func(n));
    }
}
