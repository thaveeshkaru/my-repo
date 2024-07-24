/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.service;
import edu.ijse.lms.service.custom.impl.BookCategoryServiceImpl;
import edu.ijse.lms.service.custom.impl.BookServiceImpl;
import edu.ijse.lms.service.custom.impl.BorrowingServiceImpl;
import edu.ijse.lms.service.custom.impl.LoginServiceImpl;
import edu.ijse.lms.service.custom.impl.MemberServiceImpl;
import edu.ijse.lms.service.custom.impl.ReturnServiceImpl;

/**
 *
 * @author DELL
 */
public class ServiceFactory {
    
    private static ServiceFactory serviceFactory;
    
    private ServiceFactory(){
        
    } 
    public static ServiceFactory getInstance(){
        if(serviceFactory==null){
            serviceFactory=new ServiceFactory();
        }
        return serviceFactory;
    }
    
      public SuperService getService(ServiceType type){
        switch (type) {
            case LOGIN:
                return  new LoginServiceImpl();
            case MEMBER:
                return new MemberServiceImpl();
            case BOOK:
                return new BookServiceImpl();
            case BOOK_CATEGORY:
                return new BookCategoryServiceImpl();
            case BORROW:
                return new BorrowingServiceImpl();
            case RETURN:
                return new ReturnServiceImpl();
            default:
                return null;
        }
    }
      
      public enum ServiceType{
        LOGIN,MEMBER,BOOK,BOOK_CATEGORY,BORROW,RETURN
    }
    
}
