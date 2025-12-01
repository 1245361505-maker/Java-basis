package JavaBasis.hello15;

import hello15.T2.Book;

import java.util.HashSet;
import java.util.Set;

public class HARSHSET {
    public static void main(String[] args) {
        Set set=new HashSet();
        Book b1=new Book("阿泰勒的角落",50,"李娟");
        Book b2=b1;
        set.add(b1);
        set.add(b2);
        System.out.println(set.size());
    }
}
