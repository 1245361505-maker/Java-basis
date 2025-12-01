package hello03;

import java.util.Scanner;

public class 嵌套IF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if (a>=1) {
            if(a<=100){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }else{
            System.out.println("no");
        }
        sc.close();
    }
}
