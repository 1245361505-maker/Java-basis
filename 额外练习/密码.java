package 额外练习;

import java.io.IOException;
import java.util.*;

public class 密码 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 密码长度
        int a = sc.nextInt();  // 原密码
        int k = sc.nextInt();  // 允许变化的位数

        String s = String.format("%0" + n + "d", a); // 补前导0
        Set<String> set = new HashSet<>();

        int total = (int) Math.pow(3, n); // 每位3种情况（不变、+1、-1）

        for (int mask = 0; mask < total; mask++) {
            int temp = mask;
            int changeCount = 0;
            char[] chars = s.toCharArray();

            // 每一位都能独立变化
            for (int i = 0; i < n; i++) {
                int op = temp % 3; // 当前位的操作
                temp /= 3;
                if (op != 0) changeCount++;
                if (changeCount > k) break;
                int digit = chars[i] - '0';
                if (op == 1) digit = (digit + 1) % 10;
                else if (op == 2) digit = (digit + 9) % 10;
                chars[i] = (char) (digit + '0');
            }

            if (changeCount <= k) {
                String result = new String(chars).replaceFirst("^0+", "");
                if (result.equals("")) result = "0";
                set.add(result);
            }
        }

        // 排序输出
        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list, (x, y) -> Integer.compare(Integer.parseInt(x), Integer.parseInt(y)));

        for (String str : list) {
            System.out.println(str);
        }
    }

}
