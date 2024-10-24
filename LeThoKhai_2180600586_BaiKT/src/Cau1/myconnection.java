/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau1;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author ASUS
 */
public class myconnection {
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String URL="jdbc:mysql://localhost/quanlytaikhoan?user=root&password=";
            Connection con=DriverManager.getConnection(URL);
            return con;
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.toString(),"Loi",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}

