/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportextractor;

import dbutil.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Grzesiek
 */
public class ExtractorModel {
    Connection connection;
    
    public ExtractorModel(){
        try{
            this.connection = DBConnection.getConnection();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public boolean isConnected(){
        return this.connection != null;
    }
}
