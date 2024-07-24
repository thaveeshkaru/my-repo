/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.dao.coustom.impl;

import edu.ijse.lms.dao.CrudUtil;
import edu.ijse.lms.dao.coustom.LoginDao;
import edu.ijse.lms.entity.LoginEntity;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class LoginDaoImpl implements LoginDao{

    @Override
    public LoginEntity get(String userName) throws Exception {
        ResultSet rst = CrudUtil.exeQuery("SELECT * FROM logindetails WHERE UsetName=?", userName);
        if(rst.next()){
            LoginEntity entity = new LoginEntity(rst.getString("UserName"),rst.getString("Password"));
            return entity;
        }
        return null;
    }

    @Override
    public ArrayList<LoginEntity> getAll() throws Exception {
       ArrayList<LoginEntity> loginEntity =new ArrayList<>();
       ResultSet rst=CrudUtil.exeQuery("SELECT * FROM logindetails");
       
       while(rst.next()){
            LoginEntity entity= new LoginEntity(rst.getString("UserName"),rst.getString("Password"));
            loginEntity.add(entity);
        }
       return loginEntity;
    }
    
}
