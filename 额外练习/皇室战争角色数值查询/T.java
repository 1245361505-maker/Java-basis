package 额外练习.皇室战争角色数值查询;

import java.util.Scanner;

public class T {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 所有角色放在同一个数组中（父类类型数组）
        People[] heroes = {new Witch(), new PEKKA(), new Prince()};
        while (true) {
            System.out.println("请输入你要查询的角色名字（输入EXIT退出）：");
            String name = sc.nextLine();

            if (name.equals("EXIT")) {
                System.out.println("感谢您的使用");
                break;
            }
            boolean found = false;
            for (People hero : heroes) {
                if (hero.getName().equals(name)) {
                    hero.character(); // ★ 关键：多态体现！
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("您查询的英雄暂未录入系统");
            }
        }
        sc.close();
    }
}
