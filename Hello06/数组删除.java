package JavaBasis.Hello06;

import java.util.Scanner;

public class 数组删除 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]a=new int[101];
        for(int i=1;i<=n;i++){
            a[i]=input.nextInt();
        }
        int num= input.nextInt();
        for(int i=num;i<=n;i++){
            a[i]=a[i+1];
        }
        n--;
        for(int i=1;i<=n;i++){
            System.out.print(a[i]+" ");
        }
    }
}
