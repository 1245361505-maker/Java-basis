package hello13.T5;

public class PMprinter extends PrintMachine {
    @Override
    public void show() {
        System.out.println("我是喷墨打印机");
    }

    @Override
    public void print() {
        System.out.println("喷墨打印机打印中");
    }
}
