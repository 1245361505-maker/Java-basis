package hello10.T8;

public class Baifish extends Fish {
    public Baifish() {

    }
    public Baifish(int speed){
        this.speed = speed;
    }
    @Override
    public int calc(int hours) {
        return speed*hours;
    }
}
