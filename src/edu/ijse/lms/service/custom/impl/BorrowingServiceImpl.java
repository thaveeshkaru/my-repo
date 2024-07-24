/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.service.custom.impl;

import edu.ijse.lms.dao.DaoFactory;
import edu.ijse.lms.dao.coustom.BookDao;
import edu.ijse.lms.dao.coustom.BorrowingDao;
import edu.ijse.lms.dao.coustom.MemberDao;
import edu.ijse.lms.dbconnection.DBConnection;
import edu.ijse.lms.dto.BookDto;
import edu.ijse.lms.dto.BorrowingDto;
import edu.ijse.lms.dto.MemberDto;
import edu.ijse.lms.entity.BookEntity;
import edu.ijse.lms.entity.BorrowingEntity;
import edu.ijse.lms.entity.MemberEntity;
import edu.ijse.lms.service.custom.BorrowingService;
import java.util.ArrayList;
import java.sql.Connection;

/**
 *
 * @author DELL
 */
public class BorrowingServiceImpl implements BorrowingService{

     private BorrowingDao borrowingDao = (BorrowingDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BORROW);
     private MemberDao memberDao= (MemberDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.MEMBER);
     private BookDao bookDao = (BookDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOK);
     
    @Override
    public MemberDto getMember(String membID) throws Exception {
        MemberEntity entity = memberDao.get(membID);
        MemberDto dto = new MemberDto(entity.getMemberID(), entity.getMemberName(), entity.getAddress(),entity.getContact());
        return dto;
                
    }

    @Override
    public BookDto getBook(String bookCode) throws Exception {
        BookEntity entity = bookDao.get(bookCode);
        BookDto dto = new BookDto(entity.getBookCode(), entity.getBookTitle(), entity.getAuthor(), entity.getCategoryCode(), entity.getAvailability());
        return dto;
    }
                

    @Override
    public String placeBorrowing(ArrayList<BorrowingDto> borrowingDtos) throws Exception {
       Connection connection = (Connection) DBConnection.getInstance().getconnection();
        try {
            connection.setAutoCommit(false);
            
            boolean isBorrowSaved=true;
                     
            for(BorrowingDto borrowingdto : borrowingDtos){
                BookEntity bookentity = bookDao.get(borrowingdto.getBookCode());
                if(bookentity.getAvailability()>0){
                    BorrowingEntity entity = new BorrowingEntity(borrowingdto.getMemberID(),borrowingdto.getBookCode(),borrowingdto.getBorrowingDate(),borrowingdto.getDueDate());
                    String borrowresp=borrowingDao.save(entity);  
                    if(!borrowresp.equals("Success")){ 
                        isBorrowSaved = false;
                    }
                }else{
                    connection.rollback();
                    return "Book Not Available";
                }
            }
            
            if(isBorrowSaved){
                
                boolean isBookUpdated=true;
                for(BorrowingDto borrowingdto : borrowingDtos){
                    BookEntity bookentity = bookDao.get(borrowingdto.getBookCode());
                    bookentity.setAvailability(bookentity.getAvailability()-1);
                    String bookUpdate=bookDao.update(bookentity);
                }
                
                if(isBookUpdated){
                    connection.commit();
                    return "Success";
                }
                else{
                    connection.rollback();
                    return "Book Update Error";
                }
            }
          
            else{
                connection.rollback();
                return "Borrowing save Error";
            }
              
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            return "Server Error";
            
        }finally {
            connection.setAutoCommit(true);
        }
    }  


}
