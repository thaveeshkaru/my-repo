/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.controller;

import edu.ijse.lms.dto.BookDto;
import edu.ijse.lms.dto.BorrowingDto;
import edu.ijse.lms.dto.MemberDto;
import edu.ijse.lms.service.ServiceFactory;
import edu.ijse.lms.service.custom.BorrowingService;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class BorrowingController {
    
    private BorrowingService borrowingservice=(BorrowingService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BORROW);

//    public MemberDto get(String membID)throws Exception{
//        return borrowingservice.get(membID);
//    }

    public MemberDto getMember(String membID)throws Exception{
        return borrowingservice.getMember(membID);
    }

    public BookDto getBook(String bookCode)throws Exception{
        return borrowingservice.getBook(bookCode);
    }

//    public String save(BorrowingDto borrowingDto) {
//        return borrowingservice.save(borrowingDto);
//    }

    public String placeBorrowing(ArrayList<BorrowingDto> borrowingDtos)throws Exception{
        return borrowingservice.placeBorrowing(borrowingDtos);
    }
    
}
