package hello13.T6;

public class Trapezoid implements Shape {
    double up;
    double down;
    double height;
    public Trapezoid(){

    }
    public Trapezoid(double up,double down,double height){
        this.up=up;
        this.down=down;
        this.height=height;
    }
    @Override
    public double getArea() {
        return (up+down)*height/2;
    }
}
