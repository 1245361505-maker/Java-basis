package hello10.T8;

public class Qifish extends Fish {
    public Qifish() {

    }
    public Qifish(int speed) {
        this.speed = speed;
    }
    @Override
    public int calc(int hours) {
        return hours * speed;
    }
}
