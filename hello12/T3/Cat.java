package hello12.T3;

public class Cat extends Pet {
    public Cat(){

    }
    public Cat(String name,int power){
        this.name=name;
        this.power=power;
    }
    public void catchMice(){
        System.out.println("猫猫在抓老鼠");
    }
    @Override
    public void eat(int num) {
        this.power += num;
        System.out.println("猫猫"+this.name+"能量值增加了"+num+"最终能量值为"+this.power);
    }
}
