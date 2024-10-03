package Cau2;

import java.io.*;
import java.net.*;

public class TCPServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server đang chờ kết nối...");
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                    // Đọc số lượng chuỗi mà client sẽ gửi
                    int numberOfStrings = Integer.parseInt(in.readLine());

                    // Nhận mảng chuỗi từ client
                    String[] receivedStrings = new String[numberOfStrings];
                    for (int i = 0; i < numberOfStrings; i++) {
                        receivedStrings[i] = in.readLine();
                    }

                    // Chuyển chuỗi thành chữ hoa
                    for (int i = 0; i < receivedStrings.length; i++) {
                        receivedStrings[i] = receivedStrings[i].toUpperCase();
                    }

                    // Gửi lại mảng chuỗi đã chuyển thành chữ hoa về client
                    for (String str : receivedStrings) {
                        out.println(str);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
