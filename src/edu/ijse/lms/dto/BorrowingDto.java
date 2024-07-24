/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class BorrowingDto {
    private String memberID;
    private String bookCode;
    private String borrowingDate;
    private String dueDate;
    
   // private ArrayList<BorrowingDto> borrowingDtos;

    public BorrowingDto() {
    }
    
    public BorrowingDto(String memberID, String bookCode, String borrowingDate, String dueDate) {
        this.memberID = memberID;
        this.bookCode = bookCode;
        this.borrowingDate = borrowingDate;
        this.dueDate = dueDate;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(String borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    
    
}
