package 额外练习;

import java.math.BigDecimal;

public class 整数规划自己版2 {
    public static void main(String[] args) {
        int count = 0;
        for (int p = 2; p <=4; p++) {
            for(int q=p;q<100;q++){
                for(int r=q;r<=200;r++){
                    double ss= 1 - 1.0 / p - 1.0 / q - 1.0 / r;
                    if(ss<=0){
                        continue;
                    }
                    double s = 1.0 / ss;

                    if (s%1==0&&p<=q&&q<=r&&r<=s) {
                        count++;
                        System.out.printf("solution: (%d, %d, %d, %.0f)%n", p, q, r, s);
                    }
                }
            }
        }
        System.out.println("*** integer solutions = " + count);
    }
}
