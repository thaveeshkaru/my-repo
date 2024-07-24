/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.controller;

import edu.ijse.lms.dto.BookCategoryDto;
import edu.ijse.lms.service.ServiceFactory;
import edu.ijse.lms.service.custom.BookCategoryService;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class BookCategoryController {
    private BookCategoryService bookcategoryservice=(BookCategoryService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BOOK_CATEGORY);
    
//    public String saveCategory(BookCategoryDto categoryDto )throws Exception{
//        return bookcategoryservice.saveCategory(categoryDto);
//    }

    public String saveCategory(BookCategoryDto categoryDto)throws Exception{
        return bookcategoryservice.saveCategory(categoryDto);        
    }
    
    public String updateCategory(BookCategoryDto categoryDto)throws Exception{
        return bookcategoryservice.updateCategory(categoryDto);        
    }
    
     public String deleteCategory(String categoryCode)throws Exception{
        return bookcategoryservice.deleteCategory(categoryCode);
    }
     
      public ArrayList<BookCategoryDto> getAll() throws Exception{
        return bookcategoryservice.getAll();
    }

    public BookCategoryDto get(String categoryCode)throws Exception{
        return bookcategoryservice.get(categoryCode);
    }

}
