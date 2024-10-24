/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau3;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
/**
 *
 * @author ASUS
 */
public class chuyendoisosangchuimp  extends UnicastRemoteObject implements chuyensosangchu{
    public chuyendoisosangchuimp() throws RemoteException{
        super();
    }
    @Override
     public String convertNumberToWords(int number) throws RemoteException {
             String[] units = {"", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín"};
        if (number < 1 || number > 9) {
            return "Số không hợp lệ!";
        }
        return units[number];
     }
}
