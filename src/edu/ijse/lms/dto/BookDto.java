/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.dto;

/**
 *
 * @author DELL
 */
public class BookDto {
    private String bookCode;
    private String bookTitle;
    private String author;
    private String categoryCode;
    private int availability;

    public BookDto(String bookCode, String bookTitle, String author, String categoryCode, int availability) {
        this.bookCode = bookCode;
        this.bookTitle = bookTitle;
        this.author = author;
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
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
        return "BookDto{" + "bookCode=" + bookCode + ", bookTitle=" + bookTitle + ", author=" + author + ", categoryCode=" + categoryCode + ", availability=" + availability + '}';
    }

    

    
    
    
}
