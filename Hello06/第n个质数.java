package JavaBasis.Hello06;

import java.util.Scanner;

public class 第n个质数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i=0;
        int num=2;
        while(true){
            boolean flag=true;
            for(int j=2;j<num;j++){
                if(num%j==0){
                    flag=false;
                    break;
                }

            }
            if(flag==true){
                i++;
                if(i==n){
                    System.out.println(num);
                    break;
                }
            }
            num++;

        }
    }
}
