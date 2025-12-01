package 额外练习;
public class 整数规划 {

    public static void main(String[] args) {
        int count = 0;
        for (int p = 2; p <= 4; p++) {
            for (int q = p; q <= 6; q++) {
                for (int r = q; r <= 200; r++) {
                    double denominator = 1 - 1.0 / p - 1.0 / q - 1.0 / r;
                    if (denominator <= 0) continue;

                    double s = 1.0 / denominator;
                    // 检查 s 是否是整数
                    if (Math.abs(s - Math.round(s)) < 0.1&&p<=q&&q<=r&&r<=s) {
                        count++;
                        System.out.printf("solution: (%d, %d, %d, %.0f)%n", p, q, r, s);
                    }
                }
            }
        }
        System.out.println("*** integer solutions = " + count);
    }
}