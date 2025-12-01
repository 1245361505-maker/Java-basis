package hello17.字节流的使用;

import java.io.FileWriter;
import java.io.IOException;

public class 文件字符输出流 {
    static void main(String[] args) {
        //字符流写入
        FileWriter writer=null;
        try {
            writer=new FileWriter("C:\\Users\\12453\\Desktop\\Lab group2\\try.txt");
            String words="I love China";
            writer.write(words);
            writer.flush();//刷新缓冲
            System.out.println("导入成功");
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
