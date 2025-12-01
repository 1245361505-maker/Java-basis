package hello03;

import java.util.Scanner;

public class 条件从句else {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int num=input.nextInt();
        if(num>=80){
            System.out.println("Distinction");
        }else if(num>=65){
            System.out.println("good");
        }else if(num>=55){
            System.out.println("pass");
        }else if(num>=50){
            System.out.println("conditional pass");
        }else{
            System.out.println("fail");
        }
    }
}
