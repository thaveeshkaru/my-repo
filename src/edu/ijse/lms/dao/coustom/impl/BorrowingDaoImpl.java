/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.dao.coustom.impl;

import edu.ijse.lms.dao.CrudUtil;
import edu.ijse.lms.dao.coustom.BorrowingDao;
import edu.ijse.lms.entity.BorrowingEntity;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class BorrowingDaoImpl implements BorrowingDao{

    @Override
    public String save(BorrowingEntity t) throws Exception {
         boolean isSaved=CrudUtil.executeUpdate("INSERT INTO borrowing VALUES(?,?,?,?)",t.getMemberID(),t.getBookCode(),t.getBorrowingDate(),t.getDueDate());
         return isSaved ? "Success" : "Fail";
    }

    @Override
    public BorrowingEntity get(String memberID, String bookCode) throws Exception {
            ResultSet rst = CrudUtil.exeQuery("SELECT * FROM borrowing WHERE MemberID=? AND BookCode=?", memberID,bookCode);
        if(rst.next()){
            BorrowingEntity entity = new BorrowingEntity(rst.getString("MemberID"),rst.getString("BookCode"), rst.getString("BorrowingDate"), rst.getString("DueDate"));
            return entity;
        }
        return null;
    }

    @Override
    public String delete(String memberID, String bookCode) throws Exception {
       boolean isDeleted=CrudUtil.executeUpdate("DELETE FROM borrowing WHERE MemberID=? AND BookCode=?", memberID,bookCode);
       return isDeleted ? "Success" : "Fail";
    }

    @Override
    public ArrayList<BorrowingEntity> getAll() throws Exception {
        ArrayList<BorrowingEntity> borrowingEntity= new ArrayList<>();
        ResultSet rst = CrudUtil.exeQuery("SELECT * FROM borrowing ORDER BY BorrowingDate");
        
        while(rst.next()){
            BorrowingEntity entity = new BorrowingEntity(rst.getString("MemberID"),rst.getString("BookCode"),rst.getString("BorrowingDate"),rst.getString("DueDate"));
            borrowingEntity.add(entity);
        } 
        return borrowingEntity;
    }
    
}
