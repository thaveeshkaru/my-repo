/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.dao.coustom.impl;

import edu.ijse.lms.dao.CrudUtil;
import edu.ijse.lms.dao.coustom.BookCategoryDao;
import edu.ijse.lms.entity.BookCategoryEntity;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class BookCategoryDaoImpl implements BookCategoryDao{

    @Override
    public String save(BookCategoryEntity t) throws Exception {
        boolean isSaved = CrudUtil.executeUpdate("INSERT INTO bookcategory VALUES(?,?,?)", t.getCategoryCode(),t.getCategory(),t.getDescription());
        return isSaved ? "Success" : "Fail";
    }

    @Override
    public String delete(String id) throws Exception {
        boolean isDeleted = CrudUtil.executeUpdate("DELETE FROM bookcategory WHERE CategoryCode=?",id);
        return isDeleted ? "Success" : "Fail";
    }

    @Override
    public ArrayList<BookCategoryEntity> getAll() throws Exception {
        ArrayList<BookCategoryEntity> categoryEntity= new ArrayList<>();
        ResultSet rst = CrudUtil.exeQuery("SELECT * FROM bookcategory");
        
        while(rst.next()){
            BookCategoryEntity Entity = new BookCategoryEntity(rst.getString("CategoryCode"),rst.getString("Category"),rst.getString("Description"));
            categoryEntity.add(Entity);
        }
        return categoryEntity;
    }

    @Override
    public String update(BookCategoryEntity t) throws Exception {
       boolean isSaved = CrudUtil.executeUpdate("UPDATE bookcategory SET Category=?,Description=? WHERE CategoryCode=?",t.getCategory(),t.getDescription(),t.getCategoryCode());
       return isSaved ? "Success" : "Fail";
    }

    @Override
    public BookCategoryEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.exeQuery("SELECT * FROM bookcategory WHERE CategoryCode=?", id);
        
        if(rst.next()){
            BookCategoryEntity entity = new BookCategoryEntity(rst.getString("CategoryCode"), rst.getString("Category"), rst.getString("Description"));
            return entity;
        }
        return null;
    }
    
}
