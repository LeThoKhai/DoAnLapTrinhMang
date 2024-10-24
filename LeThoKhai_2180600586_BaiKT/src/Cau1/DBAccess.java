/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau1;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author dangv
 */
public class DBAccess {
    private Connection con;
    private Statement stmt;
    public DBAccess(){
    try{
    myconnection mycon =new myconnection();
    con =mycon.getConnection();
    stmt = con.createStatement();
    }catch(Exception e)
          {
       }
    }
   public int Update(String str){
   try{
   int i=stmt.executeUpdate(str);
   return i;
   }catch(Exception e){
   
   return -1;}
   }
   public ResultSet Query(String str){
   try{
   ResultSet rs=stmt.executeQuery(str);
   return rs;
   }catch(Exception e){
   return null;
     }
   }
}