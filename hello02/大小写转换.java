package JavaBasis.hello02;

import java.util.Scanner;

public class 大小写转换 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        char ch=input.next().charAt(0);
        char bigch=(char)(ch-32);
        System.out.println(bigch);
    }
}
