package hello19.UDP的socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Receive {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket=new DatagramSocket(50000);
            System.out.println("接收端等待接收数据");
            DatagramPacket packet=new DatagramPacket(new byte[1024], 1024);
            socket.receive(packet);
            byte[]data2=packet.getData();
            String msg=new String(data2,0,packet.getLength());
            System.out.println(msg);
            data2="这是Receive回复的消息".getBytes();
            packet=new DatagramPacket(data2,data2.length, InetAddress.getByName("localhost"),packet.getPort());
            socket.send(packet);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            socket.close();
        }
    }
}
