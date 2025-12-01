package hello11.T5;

public class Car {
    //注解用法
    public String brand;
    public String color;
    public int money;
    public Car(String brand, String color, int money) {
        this.brand=brand;
        this.color=color;
        this.money=money;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", money=" + money +
                '}';
    }
}
