/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.entity;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class BorrowingEntity {
    private String memberID;
    private String bookCode;
    private String borrowingDate;
    private String dueDate;

    public BorrowingEntity(String memberID, String bookCode, String borrowingDate, String dueDate) {
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

    @Override
    public String toString() {
        return "BorrowingEntity{" + "memberID=" + memberID + ", bookCode=" + bookCode + ", borrowingDate=" + borrowingDate + ", dueDate=" + dueDate + '}';
    }
  
}
