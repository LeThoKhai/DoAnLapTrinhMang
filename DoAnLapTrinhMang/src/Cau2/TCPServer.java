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

                    String inputLine;
                    StringBuilder result = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        result.append(inputLine.toUpperCase()).append("\n");
                    }

                    out.println(result.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
