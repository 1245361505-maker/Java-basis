package 额外练习.学校内容1至3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class temperatureTransform {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== Temperature Converter =====");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("3. Exit");
            System.out.print("Please enter your choice (1-3): ");

            // ---- 菜单输入验证 ----
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number 1-3.");
                System.out.print("Please enter again: ");
                sc.next(); // 清除错误输入
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // 华氏 → 摄氏
                    System.out.print("Enter temperature in Fahrenheit: ");
                    double f = getValidDouble(sc);
                    double celsius = (f - 32) * 5 / 9;
                    System.out.printf("Result: %.2f Fahrenheit = %.2f Celsius\n\n", f, celsius);
                    break;

                case 2:
                    // 摄氏 → 华氏
                    System.out.print("Enter temperature in Celsius: ");
                    double c = getValidDouble(sc);
                    double fahrenheit = c * 9 / 5 + 32;
                    System.out.printf("Result: %.2f Celsius = %.2f Fahrenheit\n\n", c, fahrenheit);
                    break;

                case 3:
                    System.out.println("Exiting program... Bye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1-3.\n");
            }

        } while (choice != 3);
    }

    // ----------- 可复用的输入验证方法（double）-----------
    public static double getValidDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.println("Invalid input! Please enter a valid number.");
            System.out.print("Enter again: ");
            sc.next(); // 清除错误输入
        }
        return sc.nextDouble();
    }
}
