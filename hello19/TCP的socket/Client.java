package hello19.TCP的socket;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        InputStream is=null;
        OutputStream os = null;
        BufferedReader br = null;
        System.out.println("请输入内容");
        Scanner input = new Scanner(System.in);
        try {
            socket=new Socket("localhost",50000);
            is=socket.getInputStream();
            os=socket.getOutputStream();
            String msg=input.next();
            //给服务端发送消息
            os.write(msg.getBytes());
            socket.shutdownOutput();
            msg="";
            br=new BufferedReader(new InputStreamReader(is));
            while((msg=br.readLine())!=null){
                System.out.println("服务器的响应是"+msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
                is.close();
                os.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
