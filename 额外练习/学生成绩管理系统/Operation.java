package 额外练习.学生成绩管理系统;

import java.util.Scanner;

public class Operation {
    public static void run(){
        Scanner sc = new Scanner(System.in);
        operatingSystem o = new operatingSystem();
        System.out.println("Welcome to the students operating system");
        System.out.println("please log in the operating number");
        System.out.println("1 represents add");
        System.out.println("2 represents delete");
        System.out.println("3 represents search");
        System.out.println("4 represents list");
        System.out.println("5 represents showstats");
        System.out.println("6 represents update");
        while(!sc.hasNextInt()){
            System.out.println("please enter a number again");
            sc.next();
        }
        int a = sc.nextInt();
        switch (a){
            case 1:
                o.addStudent();
                break;
                case 2:
                    o.deleteStudent();
                    break;
                    case 3:
                        System.out.println("please enter a number");
                        System.out.println("1 represents name");
                        System.out.println("2 represents ID");
                        System.out.println("3 represents exit");
                        while(!sc.hasNextInt()){
                            System.out.println("please enter a number again");
                        }
                        int b = sc.nextInt();
                        if(b==1||b==2||b==3){
                            o.searchStudent(b);
                        }else{
                            System.out.println("Invalid input");
                        }
                        break;
                        case 4:
                            o.listStudents();
                            break;
                            case 5:
                                o.showStats();
                                break;
                                case 6:
                                    o.updateStudent();
                                default:
                                    System.out.println("Invalid input");

        }
    }
    public static void main(String[] args){
        run();
    }
}
