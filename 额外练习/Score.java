package 额外练习;

import java.util.Scanner;

public class Score {
    String studentname;
    int n=0;
    int total;
    int num=0;
    String avg1;
    public int caltotal(){
        Scanner input=new Scanner(System.in);
        while (true) {
            System.out.println("请输入学生总数");
            try {
                num = input.nextInt();
                if (num > 0) break;
                System.out.println("总数必须大于0！");
            } catch (Exception e) {
                System.out.println("输入无效，请输入整数！");
                input.nextLine(); // 清空错误输入
            }
        }
        String [] stunames=new String[num];
        input.nextLine();
        for (int i = 0; i < stunames.length; i++) {
            System.out.print("第 " + (i + 1) + " 个学生姓名：");
            stunames[i]=input.nextLine();
        }
        System.out.print("请输入学生姓名：");
        studentname=input.nextLine();
        boolean found = false;
        while (found==false) {
            System.out.print("请输入学生姓名：");
            studentname = input.nextLine();
            for (String name : stunames) {
                if (name.equals(studentname)) {
                    found = true; // 找到了
                    break;
                }
            }
            if (found==false) {
                System.out.println("学生姓名输入错误，请重新输入！");
            }
        }

        while (true) {
            System.out.println("请输入该学生成绩总数：");
            try {
                n = input.nextInt();
                if (n > 0) break;
                System.out.println("总数必须大于0！");
            } catch (Exception e) {
                System.out.println("输入无效，请输入整数！");
                input.nextLine(); // 清空错误输入
            }
        }
        total=0;
        int []scores=new int[n];
        for(int i=0;i<n;i++){
            while(true){
                System.out.println("请输入第"+(i+1)+"个成绩");
                int score = input.nextInt();
                if (score >= 0 && score <= 100) {
                    scores[i] = score;
                    total += score;
                    break;
                } else {
                    System.out.println("成绩无效，请重新输入！");
                }
            }
        }
        input.close();
        return total;
    }
    public double calavg(){
        double avg=(double) total/n;
        avg1=String.format("%.2f",avg);
        return avg;
    }
    public void level(){
        System.out.println("学生的姓名为："+studentname+"总分为"+total+"平均分为"+avg1);
        double avgValue = Double.parseDouble(avg1);
        if (avgValue>=85){
            System.out.println("A\n4.00\nDistinction");
        }else if (avgValue>=80){
            System.out.println("A-\n3.70\nDistinction");
        }else if (avgValue>=75){
            System.out.println("B+\n3.30\nGood");
        }else if (avgValue>=70){
            System.out.println("B\n3.00\nGood");
        }else if (avgValue>=65){
            System.out.println("B-\n2.70\nGood");
        }else if (avgValue>=60){
            System.out.println("C+\n2.30\nPass");
        }else if (avgValue>=55){
            System.out.println("C\n2.00\nPass");
        }else if (avgValue>=50){
            System.out.println("C-\n1.70\nConditional Pass");
        }else if (avgValue>=45){
            System.out.println("D+\n1.40\nFail");
        }else if (avgValue>=40){
            System.out.println("D\n1.00\nFail");
        }else{
            System.out.println("F\n0.00\nFail");
        }
    }
}
