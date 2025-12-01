package hello17.序列化;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
public class 序列化 {
    static void main(String[] args) {
        List<Book> list=new ArrayList<>();
        Book b1=new Book("阿泰勒的角落",60,"李娟");
        Book b2=new Book("平凡的世界",70,"路遥");
        list.add(b1);
        list.add(b2);
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try {
            fos=new FileOutputStream("C:\\Users\\12453\\Desktop\\Lab group2\\book.bin");
            oos=new ObjectOutputStream(fos);
            oos.writeObject(list);
            System.out.println("序列化成功");
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");;
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try {
                oos.close();
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
