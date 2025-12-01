package JavaBasis.Hello05;

import java.util.Scanner;

public class 小数写法double {
    public  static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int sum=0;
        for (int i = 1; i <= num; i++) {
            int age=sc.nextInt();
            sum+=age;

        }
        double avg=sum*1.0/num;
        String result=String.format("%.2f",avg);
        System.out.println(result);
    }
}
