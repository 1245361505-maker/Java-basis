package hello09;

public class Account {
    private double money;
    public double getMoney() {
        return money;
    }
    public void save(double num) {
        if (num <= 0) {
            System.out.println("存款金额必须大于0");
            return;
        }
        money+=num;
        System.out.println("存款成功");
        System.out.println("当前余额为："+money);

    }
    public void withdraw(double num) {
        if (num <= 0) {
            System.out.println("取款金额必须大于0");
            return;
        }
        if(money>=num){
            money=money-num;
            System.out.println("取款成功，余额为"+money);
        }else{
            System.out.println("余额不足，当前余额为"+money);
        }
    }
}
