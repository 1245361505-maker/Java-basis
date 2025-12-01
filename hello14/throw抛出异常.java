package hello14;

public class throw抛出异常 {
    public static void divide(int a,int b){
        if(b==0){
            throw new ArithmeticException("除数不能为0");
        }
        int result=a/b;
        System.out.println("结果为"+result);
    }
    public static void main(String[] args) {
        try{
            divide(5,0);
        }catch(ArithmeticException ex){
            System.out.println(ex.getMessage());
        }
    }
}
