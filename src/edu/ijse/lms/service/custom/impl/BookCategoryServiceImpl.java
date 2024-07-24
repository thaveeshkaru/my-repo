/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.service.custom.impl;

import edu.ijse.lms.dao.DaoFactory;
import edu.ijse.lms.dao.coustom.BookCategoryDao;
import edu.ijse.lms.dto.BookCategoryDto;
import edu.ijse.lms.entity.BookCategoryEntity;
import edu.ijse.lms.service.custom.BookCategoryService;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class BookCategoryServiceImpl implements BookCategoryService{
    
    private BookCategoryDao categoryDao = (BookCategoryDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOK_CATEGORY);

    @Override
    public String saveCategory(BookCategoryDto categoryDto) throws Exception {
        BookCategoryEntity entity = new BookCategoryEntity(categoryDto.getCategoryCode(),categoryDto.getCategory(),categoryDto.getDescription());
        return categoryDao.save(entity);
    }

    @Override
    public String updateCategory(BookCategoryDto categoryDto) throws Exception {
        BookCategoryEntity bookentity = new BookCategoryEntity(categoryDto.getCategoryCode(),categoryDto.getCategory(),categoryDto.getDescription());
        return categoryDao.update(bookentity);
    }

    @Override
    public String deleteCategory(String categoryCode) throws Exception {
        return categoryDao.delete(categoryCode);
    }

    @Override
    public ArrayList<BookCategoryDto> getAll() throws Exception {
        ArrayList<BookCategoryEntity> entities=categoryDao.getAll();
        ArrayList<BookCategoryDto> dtos = new ArrayList<>();
        for(BookCategoryEntity entity:entities){
            BookCategoryDto categoryDtos = new BookCategoryDto(entity.getCategoryCode(),entity.getCategory(),entity.getDescription());
            dtos.add(categoryDtos);           
        }
        return dtos;
    }

    @Override
    public BookCategoryDto get(String categoryCode) throws Exception {
       BookCategoryEntity entity = categoryDao.get(categoryCode);
       BookCategoryDto dto = new BookCategoryDto(entity.getCategoryCode(),entity.getCategory(),entity.getDescription());
       return dto;
    }
    
}
