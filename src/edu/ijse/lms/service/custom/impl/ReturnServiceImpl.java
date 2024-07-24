/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.service.custom.impl;

import edu.ijse.lms.dao.DaoFactory;
import edu.ijse.lms.dao.coustom.BookDao;
import edu.ijse.lms.dao.coustom.BorrowingDao;
import edu.ijse.lms.dao.coustom.ReturnDao;
import edu.ijse.lms.dbconnection.DBConnection;
import edu.ijse.lms.dto.BorrowingDto;
import edu.ijse.lms.dto.ReturnDto;
import edu.ijse.lms.entity.BookEntity;
import edu.ijse.lms.entity.BorrowingEntity;
import edu.ijse.lms.entity.ReturnEntity;
import edu.ijse.lms.service.custom.ReturnService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;

/**
 *
 * @author DELL
 */
public class ReturnServiceImpl implements ReturnService{

    private BorrowingDao borrowingDao = (BorrowingDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BORROW);
    private ReturnDao returnDao = (ReturnDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.RETURN);
    private BookDao bookDao = (BookDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOK);
    
    @Override
    public Double searchFine(ReturnDto dto) throws Exception {
        try {
//            ReturnEntity entity = new ReturnEntity();
//            entity.setBookCode(dto.getBookCode());
//            entity.setMemberID(dto.getMemberID());
            BorrowingEntity borrowingentity = borrowingDao.get(dto.getMemberID(),dto.getBookCode());
            double fineRate = 1.0; // Fine rate per day
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dueDate = sdf.parse(borrowingentity.getDueDate());
            Date returnDate = sdf.parse(dto.getReturnDate());

            if(returnDate.after(dueDate)){
                long diffInMillis = returnDate.getTime() - dueDate.getTime();
                long daysLate = diffInMillis / (1000 * 60 * 60 * 24); // Convert milliseconds to days
                return daysLate * fineRate;
            }else{
                return 0.0;                 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;         
        }    
    }

    @Override
    public String placeReturn(ArrayList<ReturnDto> returnDtos) throws Exception {
        Connection connection = (Connection) DBConnection.getInstance().getconnection();
        try {
            connection.setAutoCommit(false);
            
            boolean isReturnSaved=true;
                     
            for(ReturnDto returndto:returnDtos){
                    ReturnEntity entity = new ReturnEntity(returndto.getMemberID(),returndto.getBookCode(),returndto.getReturnDate(),returndto.getFine());
                    String borrowresp=returnDao.save(entity);  
                    if(!borrowresp.equals("Success")){ 
                        isReturnSaved = false;
                    }
            }
            
            if(isReturnSaved){
                
                boolean isBookUpdated=true;
                for(ReturnDto returndto:returnDtos){
                    BookEntity bookentity = bookDao.get(returndto.getBookCode());
                    bookentity.setAvailability(bookentity.getAvailability()+1);
                    String bookUpdate=bookDao.update(bookentity);
                    if(!bookUpdate.equals("Success")){
                        isBookUpdated=false;
                    }
                }
                
                if(isBookUpdated){
                    
                    boolean isBorrowDeleted=true;
                    for(ReturnDto returndto :returnDtos){
                        String borrowresp=borrowingDao.delete(returndto.getMemberID(),returndto.getBookCode());
                        if(!borrowresp.equals("Success")){
                            isBorrowDeleted=false;
                        }                    
                    }
                    if(isBorrowDeleted){
                        connection.commit();
                        return "Success";
                        
                    }else{
                        return "Borrowing delete Error";
                    }
                    
                }else{
                    connection.rollback();
                    return "Book Update Error";
                }
                
            } else{
                connection.rollback();
                return "Return save Error";
            }
            
        }catch (Exception e) {
             connection.rollback();
             e.printStackTrace();
             return "Server Error";
                
        }finally {
             connection.setAutoCommit(true);
        }
    }

    @Override
    public BorrowingDto SearchBorrowing(String membID, String bookCode) throws Exception {
        BorrowingEntity entity = borrowingDao.get(membID, bookCode);
        BorrowingDto dto = new BorrowingDto(entity.getMemberID(),entity.getBookCode(),entity.getBorrowingDate(),entity.getDueDate());
        return dto;
    }
    
}
