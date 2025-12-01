package hello10.T3;

public class Vote {
    static int count;
    public static final int max_count = 100;
    public String name;
    public Vote() {

    }
    public Vote(String name) {
        this.name = name;
    }
    public void voter(){
        if(count==max_count){
            System.out.println("停止投票");
        }else {
            count++;
            System.out.println("感谢"+name+"的投票");
        }
    }
    public static void show(){
        System.out.println("目前"+count+"票");
    }
}
