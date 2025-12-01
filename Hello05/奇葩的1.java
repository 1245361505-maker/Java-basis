package JavaBasis.Hello05;

import java.util.Scanner;

public class 奇葩的1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int total = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp != 0) {
                int k = temp % 10;
                if (k == 1) {
                    total += 1;

                }
                temp = temp / 10;
            }
        }
        System.out.println(total);
    }
}