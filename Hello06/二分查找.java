package JavaBasis.Hello06;

import java.util.Scanner;

public class 二分查找 {
    public  static void main(String[] args) {
        System.out.println("请输入一个1到100的数");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int left=1,right=100;
        while(left<=right){
            int mid = (left+right)/2;
            if(mid==num){
                System.out.println("猜对了");
                break;
            }
            if(mid>num){
                System.out.println(mid+"猜大了");
                right=mid-1;

            }
            if(mid<num){
                System.out.println(mid+"猜小了");
                left=mid+1;

            }

        }
    }
}
