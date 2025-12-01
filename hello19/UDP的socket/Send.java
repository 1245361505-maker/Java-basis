package hello19.UDP的socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Send {
    static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket=new DatagramSocket();
            byte[] data="Java2025".getBytes();
            DatagramPacket packet=new DatagramPacket(data,0,data.length, InetAddress.getByName("localhost"),50000);
            socket.send(packet);
            data=new byte[1024];
            packet=new DatagramPacket(data,1024);
            socket.receive(packet);
            int  length=packet.getLength();
            data=new byte[length];
            String str = new String(packet.getData(), 0, packet.getLength());
            System.out.println(str);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
}
