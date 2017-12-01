/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Grzesiek
 */
public class DBConnection {
 
    private static final String SQCON = "jdbc:sqlite:C:\\Users\\Grzesiek\\Documents\\NetBeansProjects\\SportExtractor\\src\\sportextractor\\Extractor.sqlite";
    
    public static Connection getConnection() throws SQLException{
        try{
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(SQCON);
        }
        catch(ClassNotFoundException ex){
            System.out.println(ex);    
        }
        return null;
    }
}
