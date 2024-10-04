package udpclient;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9876); // Cổng server 9876
            System.out.println("Server đang lắng nghe trên cổng 9876...");

            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                // Chuyển đổi dữ liệu nhận thành chuỗi
                String input = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Nhận dữ liệu: " + input);

                // Xử lý và tìm số nguyên tố
                String[] numbers = input.split(",");
                StringBuilder primes = new StringBuilder();

                for (String num : numbers) {
                    int n = Integer.parseInt(num.trim());
                    if (isPrime(n)) {
                        primes.append(n).append(",");
                    }
                }

                // Gửi số nguyên tố về client
                byte[] sendData = primes.toString().getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
