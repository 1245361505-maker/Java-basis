package hello08;

public class Calcu {
    int chinese;
    int math;
    int english;
    public int gettotal(){
        int total=chinese+math+english;
        return total;
    }
    public double getavg(){
        double result=(chinese+math+english)/3;
        return result;
    }
}
