/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.lms.service.custom;

import edu.ijse.lms.dto.BorrowingDto;
import edu.ijse.lms.dto.ReturnDto;
import edu.ijse.lms.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface ReturnService extends SuperService{

    public Double searchFine(ReturnDto dto)throws Exception;
    public String placeReturn(ArrayList<ReturnDto> returnDtos)throws Exception;
    public BorrowingDto SearchBorrowing(String membID, String bookCode)throws Exception;
    
}
