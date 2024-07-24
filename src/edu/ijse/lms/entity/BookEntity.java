/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.entity;

/**
 *
 * @author DELL
 */
public class BookEntity {
    private String bookCode;
    private String bookTitle;
    private String Author;
    private String categoryCode;
    private int availability;

    public BookEntity(String bookCode, String bookTitle, String Author, String categoryCode, int availability) {
        this.bookCode = bookCode;
        this.bookTitle = bookTitle;
        this.Author = Author;
        this.categoryCode = categoryCode;
        this.availability = availability;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "BookEntity{" + "bookCode=" + bookCode + ", bookTitle=" + bookTitle + ", Author=" + Author + ", categoryCode=" + categoryCode + ", availability=" + availability + '}';
    }

   
    
    
    
}
