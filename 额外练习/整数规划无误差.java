package 额外练习;

public class 整数规划无误差 {

    // 求最大公约数
    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // 求最小公倍数
    public static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    public static void main(String[] args) {
        int count = 0;
        for (int p = 2; p <= 4; p++) {
            for (int q = p; q <= 6; q++) {
                // 根据公式计算 r 的上限
                int rMax = (int)(2.0 / (1 - 1.0/p - 1.0/q)) + 1;
                for (int r = q; r <= rMax; r++) {

                    // 计算 p, q, r 的最小公倍数
                    int i1 = lcm(p, q);
                    int mu = lcm(i1, r);

                    // 分子和
                    int zi = mu / p + mu / q + mu / r;

                    // 化简
                    int d = gcd(mu, zi);

                    // 判断整数解
                    if (zi / d == mu / d - 1) {
                        int s = mu / d;
                        System.out.printf("solution: (%d, %d, %d, %d)%n", p, q, r, s);
                        count++;
                    }
                }
            }
        }
        System.out.println("*** integer solutions = " + count);
    }
}
