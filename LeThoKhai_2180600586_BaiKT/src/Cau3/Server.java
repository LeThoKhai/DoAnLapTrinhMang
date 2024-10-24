/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau3;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author ASUS
 */
public class Server {
        public static void main(String[] args) {
        try {
            chuyendoisosangchuimp numberToWords = new chuyendoisosangchuimp();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("NumberToWords", numberToWords);
            System.out.println("Server is ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

