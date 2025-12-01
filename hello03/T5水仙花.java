package hello03;

public class T5水仙花 {
    public static void main(String[] args) {
        for (int i = 100; i <= 999; i++) {
            int a=i%10;
            int b=i/100;
            int c=i/10%10;
            if(i==a*a*a+b*b*b+c*c*c){
                System.out.println(i);
            }else{
                continue;
            }
        }
    }
}
