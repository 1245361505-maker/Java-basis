package hello17;

import java.io.File;
import java.io.IOException;

public class 创建文件 {
    static void main(String[] args) {
        File file=new File("C:\\Users\\12453\\Desktop\\Lab group2\\1.c");
        if(!file.exists()) {
            try {
                file.createNewFile();
                System.out.println();
            }catch(IOException e){
                throw new RuntimeException();
            }
            System.out.println("创建成功");
        } else{
            System.out.println("文件已存在");
        }
    }

}
