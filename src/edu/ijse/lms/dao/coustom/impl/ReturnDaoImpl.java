/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.dao.coustom.impl;

import edu.ijse.lms.dao.CrudUtil;
import edu.ijse.lms.dao.coustom.ReturnDao;
import edu.ijse.lms.entity.ReturnEntity;

/**
 *
 * @author DELL
 */
public class ReturnDaoImpl implements ReturnDao{

    @Override
    public String save(ReturnEntity t) throws Exception {
        boolean isSaved=CrudUtil.executeUpdate("INSERT INTO returnbook VALUES(?,?,?,?)",t.getMemberID(),t.getBookCode(),t.getReturnDate(),t.getFine());
        return isSaved ? "Success" : "Fail";
    }
    
}
