package hello07;

import java.util.Scanner;

public class 最大最小数的差 {
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        int a=input.nextInt();
        int [] num=new int [100];
        for(int i=1;i<=a;i++){
            num[i] = input.nextInt();
        }
        int max=num[1];
        int min=num[1];
        for(int i=1;i<=a;i++){
            if(num[i]>max){
                max=num[i];
            }
            if(num[i]<min){
                min=num[i];
            }
        }
        int result=max-min;
        System.out.println(result);
    }




}
