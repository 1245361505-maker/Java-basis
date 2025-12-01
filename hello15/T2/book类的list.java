package JavaBasis.hello15.T2;


import java.util.ArrayList;
import java.util.List;

public class book类的list {
    public static void main(String[] args) {
        List list=new ArrayList();
        Book b1=new Book("阿泰勒的角落",60,"李娟");
        Book b2=new Book("你是人间四月天",70,"林徽因");
        list.add(b1);
        list.add(b2);
        Book b3=new Book("平凡的世界",80,"路遥");
        list.add(1,b3);
        if(list.contains(b2)){
            System.out.println("存在该图书");
        }
        for (int l = 0; l < list.size(); l++) {
            Book b=(Book)list.get(l);
            System.out.println(b);
        }
    }
}
