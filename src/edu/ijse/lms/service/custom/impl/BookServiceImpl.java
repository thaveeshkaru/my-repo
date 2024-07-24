/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.service.custom.impl;

import edu.ijse.lms.dao.DaoFactory;
import edu.ijse.lms.dao.coustom.BookDao;
import edu.ijse.lms.dto.BookDto;
import edu.ijse.lms.entity.BookEntity;
import edu.ijse.lms.service.custom.BookService;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class BookServiceImpl implements BookService{

    private BookDao bookDao = (BookDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOK);
    @Override
    public String saveBook(BookDto bookdto) throws Exception {
        BookEntity bookentity = new BookEntity(bookdto.getBookCode(),bookdto.getBookTitle(),bookdto.getAuthor(),bookdto.getCategoryCode(),bookdto.getAvailability());
        return bookDao.save(bookentity);
    }
    
    @Override
    public String updateBook(BookDto bookdto) throws Exception {
        BookEntity bookentity = new BookEntity(bookdto.getBookCode(),bookdto.getBookTitle(),bookdto.getAuthor(),bookdto.getCategoryCode(),bookdto.getAvailability());
        return bookDao.update(bookentity);
    }

    @Override
    public String deleteBook(String bookID) throws Exception {
        return bookDao.delete(bookID);
    }
    
    @Override
    public ArrayList<BookDto> getAll() throws Exception {
        ArrayList<BookEntity> entities=bookDao.getAll();
        ArrayList<BookDto> dtos = new ArrayList<>();
        for(BookEntity entity:entities){
            BookDto bookDtos = new BookDto(entity.getBookCode(),entity.getBookTitle(),entity.getAuthor(),entity.getCategoryCode(),entity.getAvailability());
            dtos.add(bookDtos);           
        }
        return dtos;
    }

    @Override
    public BookDto get(String bookID) throws Exception {
        BookEntity entity = bookDao.get(bookID);
        
        BookDto dto = new BookDto(entity.getBookCode(), entity.getBookTitle(),entity.getAuthor(),entity.getCategoryCode(),entity.getAvailability());
        return  dto;
    }
    
    
    
}
