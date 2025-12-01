package 额外练习.BMI;

import java.util.Scanner;

public class BMIcal {
    String name;
    float weight;
    float height;
    float bmi;
    public float BMIcalcu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入姓名身高和体重");
        name = sc.nextLine();
        while(true){
            weight = sc.nextFloat();
            height = sc.nextFloat();
            if(weight>0&&height>0){
                break;
            }else{
                System.out.println("请重新输入身高和体重");
            }
        }
        bmi = weight / (height * height);
        if(bmi<18.5){
            System.out.println(name+"\t"+"BMI指数为"+bmi+"\t"+"体重不足");
        }else if(bmi<24.9){
            System.out.println(name+"\t"+"BMI指数为"+bmi+"\t"+"正常体重");
        }else if(bmi<29.9){
            System.out.println(name+"\t"+"BMI指数为"+bmi+"\t"+"超重");
        }else if(bmi>=29.9){
            System.out.println(name+"\t"+"BMI指数为"+bmi+"\t"+"肥胖");
        }else{
            System.out.println(name+"BMI测量有误，请重新检查");
        }
        sc.close();
        return bmi;
    }
}
