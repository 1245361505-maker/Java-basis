package JavaBasis.hello02;

import java.util.Scanner;

public class 条件从句IF {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int score=input.nextInt();
        if(score>=60)
        {
            System.out.println("success");
        }else{
            System.out.println("fail");
        }
    }
}
