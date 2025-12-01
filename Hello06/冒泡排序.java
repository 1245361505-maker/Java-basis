package JavaBasis.Hello06;

import java.util.Scanner;

public class 冒泡排序 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[]a=new int[5];
        for(int i=0;i<5;i++){
            a[i]=input.nextInt();
        for(int j=0;j<=4;j++){
            for(int k=0;k<4-j;k++){
                if(a[k]<a[k+1]){
                    int temp=a[k];
                    a[k]=a[k+1];
                    a[k+1]=temp;
                }else continue;

            }
        }
        }
        for(int i=0;i<5;i++){
            System.out.println(a[i]);
        }
    }
}

