package hello19.TCP的socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is=null;
        OutputStream os=null;
        BufferedReader br=null;
        try {
            serverSocket=new ServerSocket(50000);
            //负责通信
            socket=serverSocket.accept();
            //获取输入流对象
            is=socket.getInputStream();
            //输出流对象
            os=socket.getOutputStream();
            br=new BufferedReader(new InputStreamReader(is));
            String line=null;
            while ((line=br.readLine())!=null){
                System.out.println("接收到的消息为"+line);
            }
            socket.shutdownInput();
            line="这里是服务端反馈的消息";
            os.write(line.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
                is.close();
                os.close();
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
