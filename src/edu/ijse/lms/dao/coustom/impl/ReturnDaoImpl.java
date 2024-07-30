/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.dao.coustom.impl;

import edu.ijse.lms.dao.CrudUtil;
import edu.ijse.lms.dao.coustom.ReturnDao;
import edu.ijse.lms.entity.ReturnEntity;
import java.util.ArrayList;
import java.sql.ResultSet;

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

    @Override
    public ArrayList<ReturnEntity> getAll() throws Exception {
        ArrayList<ReturnEntity> returnEntity= new ArrayList<>();
        ResultSet rst = CrudUtil.exeQuery("SELECT * FROM returnbook");
        
        while(rst.next()){
            ReturnEntity entity = new ReturnEntity(rst.getString("MemberID"),rst.getString("BookCode"),rst.getString("ReturnDate"),rst.getDouble("Fine"));
            returnEntity.add(entity);
        } 
        return returnEntity;
    }

    @Override
    public String delete(String memberID, String bookCode, String returnDate) throws Exception {
        boolean isdeleted=CrudUtil.executeUpdate("DELETE FROM returnbook WHERE MemberID=? AND BookCode=? AND ReturnDate =? ",memberID,bookCode,returnDate);
        return isdeleted ? "Success" : "Fail";
    }
    
}

