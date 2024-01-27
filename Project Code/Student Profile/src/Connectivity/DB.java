/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectivity;
import java.sql.*;

public class DB {

public static Connection getCon(){    
    try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student","root","Aman@1919");
           return con;
    }
    
    catch(Exception e){
     System.out.print(e);
     return null;
    }
}
}
    

