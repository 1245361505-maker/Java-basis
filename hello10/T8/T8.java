package hello10.T8;

public class T8 {
    public static void main(String[] args) {
        Fish fish1=new Baifish(48);
        Fish fish2=new Feifish(60);
        Fish fish3=new Qifish(110);
        int num1=fish1.calc(3);
        System.out.println("白鲨的游行公里数"+num1);
        int num2=fish2.calc(5);
        System.out.println("飞鱼的游行公里数"+num2);
        int num3=fish3.calc(7);
        System.out.println("旗鱼的游行公里数"+num3);
    }
}
