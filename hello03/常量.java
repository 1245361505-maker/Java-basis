package hello03;

import java.util.Scanner;

public class 常量 {
    public static void main(String[] args) {
        final String uname="CST2509025";
        final String passwd="ljj666666";
        System.out.println("please enter your name:");
        Scanner input=new Scanner(System.in);
        String name=input.next();
        System.out.println("please enter your password:");
        String password=input.next();
        if(password.equals(passwd)){
            if(name.equals(uname)){
                System.out.println("you are now logged in");
            }else{
                System.out.println("name is incorrect");
            }
        }else if (name.equals(uname)){
            System.out.println("you are now logged in");
        }else{
            System.out.println("both are incorrect");
        }
    }

}
