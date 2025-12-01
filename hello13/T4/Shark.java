package hello13.T4;

public class Shark extends Fish implements Eat,Swim,Power{
    public Shark(){

    }
    public Shark(String type){
        this.type=type;
    }
    @Override
    public void eat() {
        System.out.println("鲨鱼吃小鱼");
    }

    @Override
    public void show() {
        System.out.println("类型为"+this.type);
    }

    @Override
    public void power() {
        System.out.println("鲨鱼可以进行电感应");
    }

    @Override
    public void swim() {
        System.out.println("鲨鱼游泳");
    }
}
