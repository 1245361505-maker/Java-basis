package hello12.T2;

public class Dog extends Pet{
    public Dog() {

    }
    public Dog(String name,int power) {
        this.name = name;
        this.power = power;
    }
    @Override
    public void eat(int num) {
        this.power += num;
        System.out.println("狗狗"+this.name+"能量值增加了"+num+"最终能量值为"+this.power);

    }
}
