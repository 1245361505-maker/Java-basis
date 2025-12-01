package hello03;

import java.util.Scanner;

public class 等值判断SWITCH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String day = sc.next();
        switch (day){
            case "MONDAY":
                System.out.println('1');
                break;
            case "TUESDAY":
                System.out.println('2');
                break;
            case "WEDNESDAY":
                System.out.println('3');
                break;
            case "THURSDAY":
                System.out.println('4');
                break;
            case "FRIDAY":
                System.out.println('5');
                break;
            default:
                System.out.println("no");
                break;
        }
    sc.close();
    }
}
