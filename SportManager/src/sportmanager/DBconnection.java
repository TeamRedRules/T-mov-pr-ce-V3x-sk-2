/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author skolniPC
 */
public class DBconnection {
    
   public static Connection connectToDB(){
     try {
        Connection connection = null;
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:sportDB.db");
        System.out.println("db jede");
        return connection;
    }catch(ClassNotFoundException | SQLException e){
        System.out.println(e);
    
    }
    return null;
   }
    
}
