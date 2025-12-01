package JavaBasis.hello15.T3;

import hello15.T2.Book;

import java.util.LinkedList;
import java.util.List;

public class link的list {
    public static void main(String[] args) {
        List list=new LinkedList();
        Book b1=new Book("阿泰勒的角落",50,"李娟");
        list.add(b1);
        Book b2=new Book("你是人间四月天",60,"林徽因");
        list.addFirst(b2);
        Book b3=new Book("平凡的世界",70,"路遥");
        list.addLast(b3);
        for (int i = 0; i < list.size(); i++) {
            Book b=(Book)list.get(i);
            System.out.println(b);
        }
    }
}
