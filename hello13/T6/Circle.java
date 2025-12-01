package hello13.T6;

public class Circle implements Shape{
    final double PI=3.14;
    double r;
    public Circle(){

    }
    public Circle(double r){
        this.r=r;
    }
    @Override
    public double getArea() {
        return PI*r*r;
    }
}
