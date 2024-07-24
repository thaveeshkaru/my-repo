/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.dao;

import edu.ijse.lms.dbconnection.DBConnection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
    
 
/**
 *
 * @author Sithum
 */
public class CrudUtil {
  
    public static PreparedStatement getPreparedStatement(String sql,Object...args)throws Exception{
        
        Connection connection=DBConnection.getInstance().getconnection();
        PreparedStatement statement=connection.prepareStatement(sql);
        if (args!=null){
            for (int i=0;i<args.length;i++){
                statement.setObject(i+1, args[i]);
                
            }
            
        }
        return statement;
        
        
    }
    public static boolean executeUpdate(String sql,Object ...args)throws Exception{
       
        try {
             return getPreparedStatement(sql, args).executeUpdate()>0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        
        
    }
    
   public static  ResultSet exeQuery(String sql,Object ...args)throws Exception{
        return getPreparedStatement(sql, args).executeQuery();
              
    }
    
}
    

