/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Oscar
 */
public class Main {

    
    public static void main(String[] args) {
        
        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://192.168.2.34\\SQLEXPRESS;databaseName=oso;user=sa;password=1234";

        try (Connection con = 
                    DriverManager.getConnection(connectionUrl); 
                Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM [oso].[dbo].[agenda]";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(
                        rs.getString("nom") + " " + 
                        rs.getString("edad")
                );
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
}
