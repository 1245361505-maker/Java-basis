package hello10.T8;

public class Feifish extends Fish{
    public Feifish(int speed){
        this.speed = speed;
    }
    public Feifish(){

    }
    @Override
    public int calc(int hours) {
        return speed * hours;
    }
}
