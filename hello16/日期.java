package JavaBasis.hello16;

import java.text.SimpleDateFormat;
import java.util.Date;

public class 日期 {
    static void main(String[] args) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String a=sdf.format(date);
        System.out.println(a);
    }
}
