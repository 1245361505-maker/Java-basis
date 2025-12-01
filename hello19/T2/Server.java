package hello19.T2;

import hello19.多客户端.UserInfo;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket=null;
        Socket socket=null;
        InputStream is=null;
        OutputStream os=null;
        ObjectInputStream ois=null;
        try {
            serverSocket=new ServerSocket(50000);
            socket=serverSocket.accept();
            is=socket.getInputStream();
            os=socket.getOutputStream();
            ois=new ObjectInputStream(is);
            //接收信息
            UserInfo info=(UserInfo) ois.readObject();
            System.out.println("接收到的信息为："+info.getName()+"\t"+info.getPwd());
            socket.shutdownInput();
            String msg="这是服务器的反馈";
            os.write(msg.getBytes());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                ois.close();
                socket.close();
                is.close();
                serverSocket.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
