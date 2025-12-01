package JavaBasis.Hello06;

import java.util.Scanner;

public class 数组1 {
    public static void main(String[] args) {
        int[] a=new int [11];
        Scanner input = new Scanner(System.in);
        for(int i=1;i<a.length;i++){
            a[i]=input.nextInt();
        }
        int height= input.nextInt();
        int num=0;
        for(int i=1;i<a.length;i++){
            if(height+30>=a[i]){
                num++;
            }
        }
        System.out.println(num);

    }
}

