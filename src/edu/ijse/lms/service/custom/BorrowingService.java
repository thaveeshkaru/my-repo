/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.lms.service.custom;

import edu.ijse.lms.dto.BookDto;
import edu.ijse.lms.dto.BorrowingDto;
import edu.ijse.lms.dto.MemberDto;
import edu.ijse.lms.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface BorrowingService extends SuperService{
    public MemberDto getMember(String membID)throws Exception;
    public BookDto getBook(String bookCode)throws Exception;
    public String placeBorrowing(ArrayList<BorrowingDto> borrowingDtos)throws Exception;
    

}
