package TCPcau2;

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        Socket clientSocket = new Socket("localhost", 6789);
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.print("Enter a string: ");
        String sentence = inFromUser.readLine();  // Nhập chuỗi từ người dùng

        outToServer.writeBytes(sentence + '\n');  // Gửi chuỗi sang server

        String response = inFromServer.readLine();  // Nhận phản hồi từ server
        System.out.println("Response from server: " + response);

        clientSocket.close();
    }
}
