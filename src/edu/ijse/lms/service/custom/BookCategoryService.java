/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.lms.service.custom;

import edu.ijse.lms.dto.BookCategoryDto;
import edu.ijse.lms.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface BookCategoryService extends SuperService{
    public String saveCategory(BookCategoryDto categoryDto) throws Exception;
    public String updateCategory(BookCategoryDto categoryDto) throws Exception;
    public String deleteCategory(String categoryCode) throws Exception;
    public ArrayList<BookCategoryDto> getAll() throws Exception;
    public BookCategoryDto get(String categoryCode)throws Exception;
    
}
