/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author SethJ
 */
public class VSDataBaseHelper {
    public static Connection getConnection() {
        String host = "localhost";
        String dbName = "artlister";
        int port = 3306;
        String mySqlUrl = "jdbc:mysql://" + host + ":" + port
                + "/" + dbName;

        Properties userInfo = new Properties();
        userInfo.put("user", "root");
        userInfo.put("password", "");
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection connection = DriverManager.getConnection(mySqlUrl, userInfo);

            return connection;

        } catch (Exception ex) {
            System.out.println("Error: database helper class" + ex);
            
        }
        return null;
    }
    
}
