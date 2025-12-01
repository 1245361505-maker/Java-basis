package hello12.T6;

import java.util.Random;

public class T06 {
    public static void main(String[] args) {
        CakeShop cakeshop=new CakeShop();
        String[] types={"慕斯","泡芙","红丝绒"};
        int[] sizes={6,8,10};
        Random random=new Random();
        random.nextInt(3);//0 1 2
        for(String type:types){
            Cake cake=cakeshop.makecake(type);
            int num=random.nextInt(3);
            cake.getCake(type,sizes[num]);
        }
    }
}
