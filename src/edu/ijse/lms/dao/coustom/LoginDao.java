/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.lms.dao.coustom;

import edu.ijse.lms.dao.SuperDao;
import edu.ijse.lms.entity.LoginEntity;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface LoginDao extends SuperDao{
    
    public LoginEntity get(String userName)throws Exception;
    public ArrayList<LoginEntity> getAll()throws Exception;
    
}
