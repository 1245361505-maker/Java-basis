package hello17.字节流的使用;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class 文件字节输入流 {
    static void main(String[] args) {
        FileInputStream fis=null;
        try{
            fis=new FileInputStream("C:\\Users\\12453\\Desktop\\Lab group2\\try.txt");
            byte[] bytes=new byte[1024];
            while(fis.available()!=0){
                int data=fis.read(bytes);
                String temp=new String(bytes,0,data);
                System.out.println(temp);
            }

        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");;
        } catch (IOException e) {
            e.printStackTrace();;
        }finally{
            try{
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
