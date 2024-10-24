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

                    int numberOfStrings = Integer.parseInt(in.readLine());

                    String[] receivedStrings = new String[numberOfStrings];
                    for (int i = 0; i < numberOfStrings; i++) {
                        receivedStrings[i] = in.readLine();
                    }

                    for (int i = 0; i < receivedStrings.length; i++) {
                        receivedStrings[i] = receivedStrings[i].toUpperCase();
                    }

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
