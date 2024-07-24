/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.dao;

import edu.ijse.lms.dao.coustom.impl.BookCategoryDaoImpl;
import edu.ijse.lms.dao.coustom.impl.BookDaoImpl;
import edu.ijse.lms.dao.coustom.impl.BorrowingDaoImpl;
import edu.ijse.lms.dao.coustom.impl.LoginDaoImpl;
import edu.ijse.lms.dao.coustom.impl.MemberDaoImpl;
import edu.ijse.lms.dao.coustom.impl.ReturnDaoImpl;

/**
 *
 * @author DELL
 */
public class DaoFactory {
        private static DaoFactory daoFactory;

    public DaoFactory() {
    }
    public static DaoFactory getInstance(){
        if (daoFactory==null){
            daoFactory=new DaoFactory();
        }
        return daoFactory;
    }
    public SuperDao getDao(DaoTypes type){
        switch(type){
            case LOGIN:
                return  new LoginDaoImpl();
            case MEMBER:
                return new MemberDaoImpl();
            case BOOK:
                return new BookDaoImpl();
            case BOOK_CATEGORY:
                return new BookCategoryDaoImpl();
            case BORROW:
                return  new BorrowingDaoImpl();
            case RETURN:
                return new ReturnDaoImpl();
            default:
                return null;
                
                 
        }
        
    }
    
    public enum DaoTypes{
        LOGIN,MEMBER,BOOK,BOOK_CATEGORY,BORROW,RETURN
    }
}
