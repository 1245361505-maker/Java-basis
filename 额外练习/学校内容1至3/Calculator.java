package 额外练习.学校内容1至3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to calculator");
        System.out.println("1 = plus");
        System.out.println("2 = multiply");
        System.out.println("3 = divide");
        System.out.println("4 = power");
        System.out.println("Please enter the operation number:");

        try {
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    System.out.println("How many numbers to add?");
                    int amount = sc.nextInt();
                    int total = 0;
                    int[] nums = new int[amount];

                    for (int i = 0; i < amount; i++) {
                        System.out.println("Enter No." + (i + 1) + " number:");
                        nums[i] = sc.nextInt();
                    }

                    for (int n : nums) {
                        total += n;
                    }

                    System.out.println("The sum of " + amount + " numbers is " + total);
                    break;

                case 2:
                    System.out.println("How many numbers to multiply?");
                    int amount1 = sc.nextInt();
                    int total1 = 1;
                    int[] nums1 = new int[amount1];

                    for (int i = 0; i < amount1; i++) {
                        System.out.println("Enter No." + (i + 1) + " number:");
                        nums1[i] = sc.nextInt();
                    }

                    for (int n : nums1) {
                        total1 *= n;
                    }

                    System.out.println("The multiplication result of " + amount1 + " numbers is " + total1);
                    break;

                case 3:
                    System.out.println("Please enter two numbers:");
                    int over1 = sc.nextInt();
                    int over2 = sc.nextInt();

                    try {
                        if (over2 == 0) {
                            throw new ArithmeticException("Cannot divide by zero");
                        }
                        double over = (double) over1 / over2;
                        System.out.println("The result is " + over);

                    } catch (ArithmeticException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Please enter base and exponent:");
                    double power1 = sc.nextDouble();
                    double power2 = sc.nextDouble();
                    double power = Math.pow(power1, power2);
                    System.out.println("The power result is " + power);
                    break;

                default:
                    System.out.println("Please enter a valid operation number");
            }
        }
        catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("Invalid input! Please enter numbers only.");
        }
    }
}
