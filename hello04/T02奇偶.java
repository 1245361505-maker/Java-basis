package JavaBasis.hello04;

public class T02奇偶 {
    public static void main(String[] args) {
        int odd=0,even=0;
        for(int a = 0; a <=100; a++){
            if(a%2==0){
                even=even+a;

            }else{
                odd=odd+a;
            }
        }
        System.out.println(even);
        System.out.println(odd);
    }
}
