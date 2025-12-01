package hello14;

public class throws的使用 {
    public static void calc() throws Exception{
        System.out.println(5/0);
    }
    public static void main(String[] args) {
        try {
            calc();
        } catch (Exception e) {
            System.out.println("除数不能为0");
        }
    }
}
