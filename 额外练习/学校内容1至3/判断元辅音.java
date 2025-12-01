package 额外练习.学校内容1至3;

import java.util.Scanner;

//定义一个非字符串的自定义异常
class NotAlphabetException extends Exception {
    public NotAlphabetException(String message) {
        super(message);
    }
}

public class 判断元辅音 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int vowels = 0;//这是元音
        int consonants = 0;//这是辅音

        input = input.toLowerCase();
//全部转为小写便于判断
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            try {
                // 检查是否为字母
                if (ch < 'a' || ch > 'z') {
                    // 抛出自定义异常
                    throw new NotAlphabetException("Character '" + ch + "' is not an alphabet!");
                }

                // 判断元音
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }

            } catch (NotAlphabetException e) {
                // 捕获异常，但程序继续执行
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
//输出结果
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
