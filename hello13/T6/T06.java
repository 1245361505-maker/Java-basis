package hello13.T6;

import java.util.Scanner;

public class T06 {
    static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(true){
            System.out.println("1.矩形   2.正方形   3.梯形   4.圆   0.退出");
            if (!input.hasNextInt()) {
                System.out.println("请输入有效的整数编号！");
                input.next(); // 清掉错误输入，防止死循环
                continue;
            }
            int num=input.nextInt();
            Shape shape=null;
            if(num==0){
                System.out.println("感谢使用");
                break;
            }else{
                switch(num){
                    case 1:
                        System.out.println("输入矩形的长度和宽度");
                        double h=input.nextDouble();
                        double w=input.nextDouble();
                        shape=new Rectangle(h,w);
                        System.out.println(shape.getArea());
                        break;
                    case 2:
                        System.out.println("请输入正方形的边长");
                        double s=input.nextDouble();
                        shape=new Square(s);
                        System.out.println(shape.getArea());
                        break;
                    case 3:
                        System.out.println("请输入梯形的上底下底和高");
                        double u=input.nextDouble();
                        double d=input.nextDouble();
                        double h1=input.nextDouble();
                        shape=new Trapezoid(u,d,h1);
                        System.out.println(shape.getArea());
                        break;
                    case 4:
                        System.out.println("请输入圆的半径");
                        double r= input.nextDouble();
                        shape=new Circle(r);
                        System.out.println(shape.getArea());
                        break;
                    default:
                        System.out.println("输入有误，请重新输入");
                        break;
                }
            }
        }
    }
}
