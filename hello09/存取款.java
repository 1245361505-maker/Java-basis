package hello09;

import java.util.Scanner;

public class 存取款 {
    public static void main(String[] args) {
        Account account = new Account();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1.取款  2.存款  3.退出\t请选择您要办理的业务：");
            int n = sc.nextInt();
            if(n==1){
                System.out.println("这里是取款功能，请输入取款金额");
                double money = sc.nextDouble();
                account.withdraw(money);
            }else if(n==2){
                System.out.println("这里是存款功能，请输入存款金额");
                double money = sc.nextDouble();
                account.save(money);
            }else if(n==3){
                System.out.println("感谢使用");
                break;
            }else{
                System.out.println("选择有误，请重新选择");
            }
        }
       sc.close();
    }
}
