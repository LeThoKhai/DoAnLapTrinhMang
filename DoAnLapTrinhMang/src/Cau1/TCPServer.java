import java.io.*;
import java.net.*;
import java.util.Arrays;

public class TCPServer {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                // Chấp nhận kết nối từ client
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Tạo luồng mới để xử lý client
                new ClientHandler(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Nhận dữ liệu từ client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Đọc kích thước ma trận
            int rows = Integer.parseInt(in.readLine());
            int cols = Integer.parseInt(in.readLine());

            // Tạo ma trận từ dữ liệu nhận được
            double[][] matrix = new double[rows][cols];
            for (int i = 0; i < rows; i++) {
                String[] row = in.readLine().split(" ");
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = Double.parseDouble(row[j]);
                }
            }

            // Sắp xếp từng hàng theo thứ tự giảm dần
            for (int i = 0; i < rows; i++) {
                Arrays.sort(matrix[i]);
                // Đảo ngược mảng để có thứ tự giảm dần
                for (int j = 0; j < cols / 2; j++) {
                    double temp = matrix[i][j];
                    matrix[i][j] = matrix[i][cols - 1 - j];
                    matrix[i][cols - 1 - j] = temp;
                }
            }

            // Gửi lại ma trận đã sắp xếp cho client
                     // Gửi lại ma trận đã sắp xếp về client (làm tròn đến 2 chữ số thập phân)
                for (int i = 0; i < rows; i++) {
                    StringBuilder sortedRow = new StringBuilder();
                    for (int j = 0; j < cols; j++) {
                        // Làm tròn số đến 2 chữ số thập phân
                        String formattedNumber = String.format("%.2f", matrix[i][j]);
                        sortedRow.append(formattedNumber).append(" ");
                    }
                    out.println(sortedRow.toString().trim());
                }

            socket.close();
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
