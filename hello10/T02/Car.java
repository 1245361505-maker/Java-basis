package hello10.T02;

public class Car {
    String brand;
    String model;
    int year;
    private int mile;
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    public void setMile(int mile) {
        if(mile < 0) {
            mile = 0;
        }else{
            this.mile = mile;
        }
    }
    public void show(){
        System.out.println("品牌为"+brand);
        System.out.println("型号为"+model);
        System.out.println("生产年份为"+year);
        System.out.println("里程数为"+mile);
    }
}
