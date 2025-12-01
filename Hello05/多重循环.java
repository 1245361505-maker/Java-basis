package JavaBasis.Hello05;

public class 多重循环 {
    public static void main(String[] args) {
        for(int j = 1; j <= 33; j++){
            for(int i = 1; i <= 50; i++){
                for(int k = 1; k <= 98; k++){
                    if(i+j+k==100&&3*j+2*i+k/3.0==100){
                        System.out.println(i+"\t"+j+"\t"+k);
                    }

                }
            }
        }
    }
}
