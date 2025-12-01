package hello13.T4;

public class Goldfish extends Fish implements Eat,Swim{
    public Goldfish(){

    }
    public Goldfish(String type){
        this.type=type;
    }
    @Override
    public void eat() {
        System.out.println("金鱼吃东西");
    }

    @Override
    public void swim() {
        System.out.println("金鱼游泳中");
    }

    @Override
    public void show() {
        System.out.println("类型为"+this.type);
    }
}
