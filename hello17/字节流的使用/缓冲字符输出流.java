package hello17.字节流的使用;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class 缓冲字符输出流 {
    static void main(String[] args) {
        //缓冲流写入
        Writer writer=null;
        BufferedWriter bw=null;
        try {
            writer=new FileWriter("C:\\Users\\12453\\Desktop\\Lab group2\\try.txt");
            bw=new BufferedWriter(writer);
            bw.write("I love Malaysia");
            System.out.println("写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                bw.close();
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
