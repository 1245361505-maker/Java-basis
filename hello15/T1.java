package JavaBasis.hello15;

import java.util.ArrayList;

public class T1 {
    public static void main(String[] args) {
        ArrayList list=new ArrayList();
        list.add(1);
        list.add("你好");
        list.add(1,"new");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
