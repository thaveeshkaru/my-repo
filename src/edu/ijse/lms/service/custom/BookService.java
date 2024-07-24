/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.lms.service.custom;

import edu.ijse.lms.dto.BookDto;
import edu.ijse.lms.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface BookService extends SuperService{
    
    public String saveBook(BookDto bookdto) throws Exception;
    public String updateBook(BookDto bookdto) throws Exception;
    public String deleteBook(String bookID) throws Exception;
    public ArrayList<BookDto> getAll() throws Exception;
    public BookDto get(String bookID)throws Exception;
}
