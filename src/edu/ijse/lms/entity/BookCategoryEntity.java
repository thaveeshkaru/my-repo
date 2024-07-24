/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.entity;

/**
 *
 * @author DELL
 */
public class BookCategoryEntity {
    private String categoryCode;
    private String category;
    private String description;

    public BookCategoryEntity(String categoryCode, String category, String description) {
        this.categoryCode = categoryCode;
        this.category = category;
        this.description = description;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BookCategoryEntity{" + "categoryCode=" + categoryCode + ", category=" + category + ", description=" + description + '}';
    }
    
    
}
