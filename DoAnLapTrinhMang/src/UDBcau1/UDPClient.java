package UDBcau1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData;
        byte[] receiveData = new byte[1024];

        // Gửi các ký tự từ 'A' đến 'Y'
        for (char ch = 'A'; ch <= 'Y'; ch++) {
            String sentence = Character.toString(ch);
            sendData = sentence.getBytes();

            // Gửi dữ liệu đến server
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
            clientSocket.send(sendPacket);

            // Nhận phản hồi từ server
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String modifiedSentence = new String(receivePacket.getData(), 0, receivePacket.getLength());

            System.out.println("Received from server: " + modifiedSentence);
        }

        clientSocket.close();
    }
}
