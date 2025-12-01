package hello09;

import java.util.Scanner;

public class Bookmain {
    public static void menu(){
        System.out.println("欢迎来到图书管理系统");
        System.out.println("1.图书列表");
        System.out.println("2.添加图书");
        System.out.println("0.退出系统");
        System.out.println("请输入对应操作");
    }

    public static void main(String[] args) {
        Bookmanage bookmanage=new Bookmanage();
        bookmanage.initBooks();
        Scanner input = new Scanner(System.in);
        menu();
        int num = input.nextInt();
        while(num!=0){
            if(num==1){
                bookmanage.booklist();
            }else if(num==2){
                System.out.println("这里是添加图书界面");
                Book book=new Book();
                System.out.println("请输入图书名称");
                book.name = input.nextLine();
                input.nextLine();
                System.out.println("请输入图书作者");
                book.author=input.next();
                System.out.println("请输入图书价格");
                book.price=input.nextInt();
                boolean flag=bookmanage.addbooks(book);
                if (flag) {
                    System.out.println("图书添加成功！");
                } else {
                    System.out.println("添加失败：书架已满，无法再放新书。");
                }
            }
            menu();
            num=input.nextInt();
        }
        System.out.println("感谢您使用该系统");
    }
}
