/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.dao.coustom.impl;

import java.sql.ResultSet;
import edu.ijse.lms.dao.CrudUtil;
import edu.ijse.lms.dao.coustom.MemberDao;
import edu.ijse.lms.entity.MemberEntity;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class MemberDaoImpl implements MemberDao{

    @Override
    public String save(MemberEntity t) throws Exception {
        boolean isSaved = CrudUtil.executeUpdate("INSERT INTO member VALUES(?,?,?,?)",t.getMemberID(),t.getMemberName(),t.getAddress(),t.getContact());
        return isSaved ? "Success" : "Fail";
       
    }

    @Override
    public String delete(String id) throws Exception {
        boolean isSaved=CrudUtil.executeUpdate("DELETE FROM member WHERE MemberID=?",id);
        return isSaved ? "Success" : "Fail";
    }

    @Override
    public ArrayList<MemberEntity> getAll() throws Exception {
        ArrayList<MemberEntity> memberEntity =new ArrayList<>();
        ResultSet rst=CrudUtil.exeQuery("SELECT * FROM member");
        
        while(rst.next()){
            MemberEntity entity= new MemberEntity(rst.getString("MemberID"),rst.getString("MemberName"),rst.getString("Address"),rst.getInt("Contact"));
            memberEntity.add(entity);
        }
        
        return memberEntity;
        
    }

    @Override
    public String update(MemberEntity t) throws Exception {
        boolean isUpdate=CrudUtil.executeUpdate("UPDATE member SET MemberName=?,Address=?,Contact=? WHERE MemberId=?",t.getMemberName(),t.getAddress(),t.getContact(),t.getMemberID());
        return isUpdate ? "Success" : "Fail";
    }

    @Override
    public MemberEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.exeQuery("SELECT * FROM member WHERE MemberID=?", id);
        if(rst.next()){
            MemberEntity entity = new MemberEntity(rst.getString("MemberID"),rst.getString("MemberName"), rst.getString("Address"), rst.getInt("Contact"));
            return entity;
        }
        return null;
    }
    
}
