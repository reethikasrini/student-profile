/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.profile;

import Connectivity.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lenovo
 */
public class Addaction {
   public boolean add(StudentProfile sp){
       boolean check = false;
       
       try{
           Connection con = DB.getCon();
           String query = "insert into profile(name,domain,address) value(?,?,?)";
           
           PreparedStatement p = con.prepareStatement(query);
           
           p.setString(1, sp.getname());
           p.setString(2, sp.getdomain());
           p.setString(3, sp.getaddress());
           p.executeUpdate();
           
           check = true;
       }
       catch(Exception e){
           System.out.println(e);
       }
       
       return check;
   }
   
   public void display() throws SQLException{
      try{
       Connection con = DB.getCon();
       String query = "select * from profile";
       Statement s= con.createStatement();
       ResultSet rs = s.executeQuery(query);
       
       while(rs.next()){
           System.out.println(
           "ID      ->  "+ rs.getInt(1)+"\n"+
           "Name    ->  "+ rs.getString(2)+"\n"+
           "Domain  ->  "+ rs.getString(3)+"\n"+
           "Address ->  "+ rs.getString(4)
           );
           System.out.println("**********************");
       }
      }
      catch(Exception e){
          System.out.println(e);
      }
   }
   
   public boolean displaybyID(int id){
       boolean check = false;
       try{
       Connection con = DB.getCon();
       String query = "select * from profile where id="+id;
       Statement s= con.createStatement();
       ResultSet rs = s.executeQuery(query);
       
       while(rs.next()){
           System.out.println(
           "ID      ->  "+ rs.getInt(1)+"\n"+
           "Name    ->  "+ rs.getString(2)+"\n"+
           "Domain  ->  "+ rs.getString(3)+"\n"+
           "Address ->  "+ rs.getString(4)
           );
           System.out.println("**********************");
           
       check = true;
       }
      }
      catch(Exception e){
          System.out.println(e);
      }
       return check;
   }
   
   public boolean delete(int de){
       boolean check = false;
       
       try{
           Connection con = DB.getCon();
           String query = "delete from profile where id="+de;
           PreparedStatement p = con.prepareStatement(query);
           p.executeUpdate();           
           check = true;
       }
       catch(Exception e){
           System.out.println(e);
       }
       return check;
   }
   public boolean update(int id, String neww, int se, StudentProfile sp){
       boolean check=false;
       try{
           
           if(se==1){
               Connection con = DB.getCon();
               String query = "update profile set domain=? where id=?";
               PreparedStatement p = con.prepareStatement(query);
               p.setString(1, neww);
               p.setInt(2,id);
               
               p.executeUpdate();
               check =true;
           }
           else if(se==2){
               Connection con = DB.getCon();
               String query = "update profile set address=? where id=?";
               PreparedStatement p = con.prepareStatement(query);
               p.setString(1, neww);
               p.setInt(2,id);
               
               p.executeUpdate();
               check =true;
           }
           
       }
       catch(Exception e){
           System.out.println(e);
       }
       return check;
   }
}
