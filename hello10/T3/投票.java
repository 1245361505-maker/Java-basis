package hello10.T3;

public class 投票 {
    public static void main(String[] args) {
        Vote vote=new Vote("张三");
        Vote vote1=new Vote("李四");
        Vote.show();
        vote.voter();
        vote1.voter();
        Vote.show();
    }
}
