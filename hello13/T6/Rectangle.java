package hello13.T6;

public class Rectangle implements Shape{
    double height;
    double width;
    public Rectangle(){

    }
    public Rectangle(double height,double width){
        this.width=width;
        this.height=height;
    }
    @Override
    public double getArea() {
        double area=height*width;
        return area;
    }
}
