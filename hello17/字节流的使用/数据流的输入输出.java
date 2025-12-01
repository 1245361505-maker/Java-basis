package hello17.字节流的使用;

import java.io.*;

public class 数据流的输入输出 {
    static void main(String[] args) {
        DataInputStream dis=null;
        DataOutputStream dos=null;
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
            fis=new FileInputStream("C:\\Users\\12453\\Desktop\\Lab group2\\21.png");
            dis=new DataInputStream(fis);
            fos=new FileOutputStream("C:\\Users\\12453\\Desktop\\Lab group2\\23.png");
            dos=new DataOutputStream(fos);
            int data;
            while((data= dis.read())!=-1){
                dos.write(data);
            }
            System.out.println("复制成功");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch(IOException E){
            E.printStackTrace();
        }
        try {
            fis.close();
            fos.close();
            dis.close();
            dos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
