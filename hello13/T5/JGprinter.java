package hello13.T5;

public class JGprinter extends PrintMachine{
    @Override
    public void show() {
        System.out.println("我是激光打印机");
    }

    @Override
    public void print() {
        System.out.println("激光打印打印中");
    }
}
