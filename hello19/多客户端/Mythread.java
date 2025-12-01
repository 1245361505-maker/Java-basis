package hello19.多客户端;

import java.io.*;
import java.net.Socket;

public class Mythread extends Thread{
    Socket socket=null;
    public Mythread(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        InputStream is=null;
        OutputStream os=null;
        ObjectInputStream ois=null;
        try {
            is=socket.getInputStream();
            os=socket.getOutputStream();
            ois=new ObjectInputStream(is);
            try {
                UserInfo info=(UserInfo) ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            socket.shutdownInput();
            String msg="这是服务器反馈的信息";
            os.write(msg.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                ois.close();
                socket.close();
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
