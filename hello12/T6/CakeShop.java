package hello12.T6;

public class CakeShop {
    public Cake makecake(String type) {
        Cake cake;
        if(type.equals("慕斯")){
            cake=new MScake();
        }else if(type.equals("泡芙")){
            cake=new PFcake();
        }else{
            cake=new HSRcake();
        }
        return cake;
    }
}
