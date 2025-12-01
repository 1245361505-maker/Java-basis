package hello18.复制文件内容;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class T1 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis=new FileInputStream("C:\\Users\\12453\\Desktop\\Lab group2\\try.txt");
            fos=new FileOutputStream("C:\\Users\\12453\\Desktop\\Lab group2\\try1.txt");
            byte[] b=new byte[1024];
            while(fis.available()!=0){
                int data= fis.read(b);
                fos.write(b,0,data);
            }
            System.out.println("复制成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
