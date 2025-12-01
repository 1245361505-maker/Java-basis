package hello13.T5;

public class T5 {
    static void main() {
        PrintMachine[] printers={new JGprinter(),new PMprinter(),new ZSprinter()};
        for(PrintMachine printer:printers){
            printer.show();
            printer.print();
            System.out.println("===============");
        }
    }
}
