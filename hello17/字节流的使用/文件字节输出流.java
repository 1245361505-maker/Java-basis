package hello17.字节流的使用;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class 文件字节输出流 {
    static void main(String[] args) {
        FileOutputStream fos=null;
        try{
            fos=new FileOutputStream("C:\\Users\\12453\\Desktop\\Lab group2\\try.txt");
            String words="我爱中国";
            byte[] bytes=words.getBytes();
            fos.write(bytes);
            System.out.println("写入成功");
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");;
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
