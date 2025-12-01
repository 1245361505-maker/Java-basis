package hello17.字节流的使用;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class 文件字符输入流 {
    static void main(String[] args) {
        FileReader reader=null;
        StringBuffer sb=null;
        try {
            reader = new FileReader("C:\\Users\\12453\\Desktop\\Lab group2\\try.txt") ;
            char[] chars=new char[1024];
            int length= reader.read(chars);
            sb=new StringBuffer();
            while(length!=-1){
                sb.append(chars,0,length);
                length= reader.read(chars);
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");;
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sb.toString());
    }
}
