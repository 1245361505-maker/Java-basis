package hello17.序列化;

import java.io.*;
import java.util.List;

public class T11反序列化 {
    static void main(String[] args) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try {
            fis=new FileInputStream("C:\\Users\\12453\\Desktop\\Lab group2\\book.bin");
            ois=new ObjectInputStream(fis);
            List<Book> list=(List<Book>) ois.readObject();
            for(Book book:list){
                System.out.println(book.getName()+"\t"+book.getAuthor()+"\t"+book.getPrice());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            try {
                ois.close();
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
