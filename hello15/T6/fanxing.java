package JavaBasis.hello15.T6;


import hello15.T2.Book;

import java.util.ArrayList;
import java.util.List;

public class fanxing {
    public static void main(String[] args) {
        List<Book>list=new ArrayList<Book>();
        Book b1=new Book("阿泰勒的角落",60,"李娟");
        list.add(b1);
        Book b2=new Book("你是人间四月天",70,"林徽因");
        list.add(0,b2);
        for(Book item:list){
            System.out.println(item);
        }
    }
}
