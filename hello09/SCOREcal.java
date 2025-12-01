package hello09;

import java.util.Scanner;

public class SCOREcal {
    public void Scoreana() {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        // ✅ 第一步：安全输入学生人数
        while (true) {
            System.out.println("请输入学生总数：");
            try {
                n = sc.nextInt();
                if (n > 0) break;
                System.out.println("人数必须大于0！");
            } catch (Exception e) {
                System.out.println("输入无效，请输入整数！");
                sc.nextLine(); // 清空错误输入
            }
        }

        // ✅ 第二步：输入成绩
        int[] scores = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.println("请输入第 " + (i + 1) + " 个学生的成绩（0~100）：");
                int stuscore = sc.nextInt();
                if (stuscore >= 0 && stuscore <= 100) {
                    scores[i] = stuscore;
                    total += stuscore;
                    break; // 成绩合法就退出当前循环
                } else {
                    System.out.println("成绩有误，请重新输入！");
                }
            }
        }

        // ✅ 第三步：计算最高分、最低分、平均分
        int max = scores[0];
        int min = scores[0];
        for (int s : scores) {
            if (s > max) max = s;
            if (s < min) min = s;
        }
        double avg = (double) total / n;

        // ✅ 第四步：输出结果
        System.out.println("\n===== 成绩分析结果 =====");
        System.out.println("最低分：" + min);
        System.out.println("最高分：" + max);
        System.out.printf("平均成绩：%.2f\n", avg);
        System.out.println("======================");

        sc.close();
    }
}
