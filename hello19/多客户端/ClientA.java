package hello19.多客户端;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientA {
    public static void main(String[] args) {
        Socket socket = null;
        InputStream is=null;
        OutputStream os = null;
        ObjectOutputStream oos = null;
        BufferedReader br = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入内容");
        try {
            socket=new Socket("localhost",50000);
            is = socket.getInputStream();
            os = socket.getOutputStream();
            oos = new ObjectOutputStream(os);
            String uname=sc.next();
            String upwd=sc.next();
            UserInfo info=new UserInfo();
            info.setName(uname);
            info.setPwd(upwd);
            oos.writeObject(info);
            socket.shutdownOutput();
            //以下接收消息
            br = new BufferedReader(new InputStreamReader(is));
            String str = null;
            while ((str = br.readLine()) != null) {
                System.out.println("服务器的响应是："+str+socket.getLocalPort());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
                oos.close();
                is.close();
                os.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
