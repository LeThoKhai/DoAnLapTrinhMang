package TCPcau2;

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6789);
        System.out.println("Server is running...");

        while (true) {
            Socket connectionSocket = serverSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            String clientSentence = inFromClient.readLine();  // Đọc chuỗi từ client
            System.out.println("Received: " + clientSentence);

            // Tính tổng số ký tự 'i' trong chuỗi
            long count = clientSentence.chars().filter(ch -> ch == 'i').count();
            outToClient.writeBytes("Total 'i': " + count + '\n');  // Gửi kết quả về client
        }
    }
}
