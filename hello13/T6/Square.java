package hello13.T6;

public class Square implements Shape{
    double side;
    public Square(){

    }
    public Square(double side){
        this.side=side;
    }
    @Override
    public double getArea() {
        return side*side;
    }
}
