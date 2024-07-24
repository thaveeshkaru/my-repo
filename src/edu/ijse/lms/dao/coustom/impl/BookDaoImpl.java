/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.dao.coustom.impl;

import edu.ijse.lms.dao.CrudUtil;
import edu.ijse.lms.dao.coustom.BookDao;
import edu.ijse.lms.entity.BookEntity;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class BookDaoImpl implements BookDao{

    @Override
    public String save(BookEntity t) throws Exception {
        boolean isSaved=CrudUtil.executeUpdate("INSERT INTO book VALUES(?,?,?,?,?)",t.getBookCode(),t.getBookTitle(),t.getAuthor(),t.getCategoryCode(),t.getAvailability());
        return isSaved ? "Success" : "Fail";
    }

    @Override
    public String delete(String id) throws Exception {
        boolean isDeleted = CrudUtil.executeUpdate("DELETE FROM book WHERE BookCode=?",id);
        return isDeleted ? "Success" : "Fail";
    }


    @Override
    public ArrayList<BookEntity> getAll() throws Exception {
        ArrayList<BookEntity> bookEntity= new ArrayList<>();
        ResultSet rst = CrudUtil.exeQuery("SELECT * FROM book");
        
        while(rst.next()){
            BookEntity entity = new BookEntity(rst.getString("BookCode"), rst.getString("BookTitle"), rst.getString("Author"),rst.getString("CategoryCode"), rst.getInt("Availability"));
            bookEntity.add(entity);
        } 
        return bookEntity;
        
    }

    @Override
    public String update(BookEntity t) throws Exception {
       boolean isUpdated =CrudUtil.executeUpdate("UPDATE book SET BookTitle=?, Author=?,CategoryCode=?,Availability=? WHERE BookCode=?", t.getBookTitle(),t.getAuthor(),t.getCategoryCode(),t.getAvailability(),t.getBookCode());
       return isUpdated ? "Success" : "Fail";
    }

    @Override
    public BookEntity get(String bookcode) throws Exception {
       ResultSet rst = CrudUtil.exeQuery("SELECT * FROM book WHERE BookCode=?", bookcode);
        if(rst.next()){
            BookEntity entity = new BookEntity(rst.getString("BookCode"),rst.getString("BookTitle"),rst.getString("Author") ,rst.getString("CategoryCode"), rst.getInt("Availability"));
            return entity;
        }
        return null;
    }
    
}
