package JavaBasis.hello04;

import java.util.Scanner;

public class T8最大公约数 {
    public static void main(String[] args) {//辗转相除
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        if (n>m){
            int temp = n;
            n = m;
            m = temp;
        }
        int r=m%n;
        while(r!=0)
        {
        m=n;
        n=r;
        r=m%n;
        }
        System.out.println(n+"and"+m+"最大公因数是"+n);
    }

}
