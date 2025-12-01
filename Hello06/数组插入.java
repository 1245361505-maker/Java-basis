package JavaBasis.Hello06;

import java.util.Scanner;

public class 数组插入 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] num={78,87,95,98,100};
        int score= input.nextInt();
        int index=num.length-1;
        for(int i=0;i<num.length;i++){
            if(score<num[i]){
                index=i;
                break;

            }
        }
        for(int j=num.length-1;j>index;j--){
            num[j]=num[j-1];
        }
        num[index]=score;
        for(int j=0;j<num.length;j++){
            System.out.print(num[j]+" ");
        }

    }
}
