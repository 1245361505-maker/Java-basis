package 额外练习.BMI1;

import java.util.Scanner;

public class BMIana {
    String name;
    int num;
    int L=0,N=0,M=0,F=0;
    double weight;
    double height;
    double bmi;
    public void BMIstu(){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while(flag==true){
            System.out.println("请输入学生人数");
            num = sc.nextInt();
            sc.nextLine();
            if(num>=1){
                flag = false;
                break;
            }else{
                System.out.println("请重新输入学生人数");
            }
        }
        double [] stubmi=new double[num];
        String [] studentname=new String[num];
        System.out.println("请输入"+num+"个学生姓名");
        for(int i=0;i<num;i++) {
            studentname[i] = sc.nextLine();
        }
        for(int a=0;a<num;a++){
            boolean flag1 = true;
            while(flag1==true){
                System.out.println("请输入体重（kg）");
                weight = sc.nextDouble();
                System.out.println("请输入身高（m）");
                height = sc.nextDouble();
                sc.nextLine();
                bmi = weight / (height * height);
                if(weight >0 && height > 0){
                    stubmi[a]=bmi;
                    flag1 = false;
                    break;
                }else{
                    System.out.println("请重新输入学生姓名，身高和体重");
                }
            }
        }
        for(int i=0;i<=num-1;i++){
            if(stubmi[i]<=18.5){
                System.out.println(studentname[i]+"体重过轻");
                L++;
            }else if(stubmi[i]<24.9){
                System.out.println(studentname[i]+"体重正常");
                N++;
            }else if(stubmi[i]<29.9){
                System.out.println(studentname[i]+"超重");
                M++;
            }else{
                System.out.println(studentname[i]+"肥胖");
                F++;
            }
        }
        System.out.println(num+"名学生中体重过轻者有"+L+"人体重正常者有"+N+"人体重超重者有"+M+"人肥胖者有"+F+"人");
    }
}
