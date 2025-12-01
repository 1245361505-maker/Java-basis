package JavaBasis.hello16.统计字符次数;

import java.util.Scanner;

public class T9 {
    static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String words=input.next();
        int bigNum=0,smallNum=0,digitNum=0;
        for(char item:words.toCharArray()){
            if(item>='A'&&item<='Z'){
                bigNum++;
            }else if(item>='a'&&item<='z'){
                smallNum++;
            }else if(item>='0'&&item<='9'){
                digitNum++;
            }
        }
        System.out.println("大写字母有"+bigNum+"个");
        System.out.println("小写字母有"+smallNum+"个");
        System.out.println("数字有"+digitNum+"个");
    }
}
