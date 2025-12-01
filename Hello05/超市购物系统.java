package JavaBasis.Hello05;

import java.util.Scanner;

public class 超市购物系统 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean flag=true;
        int money,sum1=0,total=0,num=0;
        while(flag){
            sum1=0;

            do{
                money=input.nextInt();
                if(money==-1){
                    flag=false;
                    break;
                }
                sum1+=money;
            }while(money!=0);
            if(sum1!=0){
                num++;
                System.out.println("您的购物金额："+sum1);
            }
            total+=sum1;
        }
        System.out.println("总数："+num);
        System.out.println("总金额："+total);
    }
}
