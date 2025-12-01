package hello17.字节流的使用;

import java.io.*;

public class 缓冲字符输入流 {
    static void main(String[] args) {
        //缓冲流读取文件
        BufferedReader br=null;
        Reader reader=null;
        try {
            reader=new FileReader("C:\\Users\\12453\\Desktop\\Lab group2\\try.txt");
            br=new BufferedReader(reader);
            String line=br.readLine();
            while(line!=null){
                System.out.println(line);
                line=br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
