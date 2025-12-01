package 额外练习.自定义异常输出学生姓名和成绩;

import java.util.Scanner;
import static 额外练习.自定义异常输出学生姓名和成绩.自定义异常.*;
public class 主函数 {
    public static void main(String[] args) {
        Student student = new Student();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("please input student's name：");
            String name = sc.nextLine();
            System.out.println("please input student's score：");
            double score = sc.nextDouble();
            student.setName(name);
            student.setScore(score);
        } catch (IllegalNameException |IllegalScoreException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
