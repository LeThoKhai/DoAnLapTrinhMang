/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau3;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author ASUS
 */
public interface chuyensosangchu extends Remote{
    String convertNumberToWords(int number) throws RemoteException;
}
