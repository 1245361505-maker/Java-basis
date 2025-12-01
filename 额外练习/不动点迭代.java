package 额外练习;

public class 不动点迭代 {
    // 定义迭代函数 g(x)
    public static double g(double x) {
        return (x * x + 2 - Math.exp(x)) / 3.0;
    }

    public static void cal() {
        double x0 = 0.0;               // 初始值
        double x1 = g(x0);             // 第一次迭代
        double eps = 1e-8;             // 精度
        int count = 1;                 // 迭代次数计数

        while (Math.abs(x1 - x0) > eps) {
            x0 = x1;                   // 更新上一次
            x1 = g(x0);                // 计算下一次
            count++;
            if (count > 1000) {        // 防止死循环
                System.out.println("不收敛！");
                return;
            }
        }

        System.out.println("方程的近似根为: " + x1);
        System.out.println("迭代次数: " + count);
    }

    public static void main(String[] args) {
        cal();
    }
}
