/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author PC
 */
public class DatabaseConnection {
    public static String URL = "jdbc:sqlserver://localhost:1433;databaseName=SchoolSystem;encrypt=false";
    public static String USER = "sa";
    public static String PASSWORD = "123";
       
    

    public static Connection getConnection() throws SQLException, ClassNotFoundException{
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return  DriverManager.getConnection(URL ,USER, PASSWORD);
        
    }
    
}
