package UDBcau1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData;

        System.out.println("Server is running...");
        
        while (true) {
            // Nhận gói tin từ client
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String receivedSentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
            
            System.out.println("Received: " + receivedSentence);

            // Gửi lại dữ liệu nhận được về client
            sendData = receivedSentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
            serverSocket.send(sendPacket);
        }
    }
}
