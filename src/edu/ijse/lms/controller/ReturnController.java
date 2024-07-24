/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.controller;

import edu.ijse.lms.dto.BorrowingDto;
import edu.ijse.lms.dto.ReturnDto;
import edu.ijse.lms.service.ServiceFactory;
import edu.ijse.lms.service.custom.ReturnService;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ReturnController {

    private ReturnService returnservice=(ReturnService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RETURN);

    public Double searchFine(ReturnDto dto)throws Exception{
        return returnservice.searchFine(dto);
    }

    public String placeReturn(ArrayList<ReturnDto> returnDtos)throws Exception{
        return returnservice.placeReturn(returnDtos);
    }


    public BorrowingDto searchBorrowing(String membID, String bookCode)throws Exception{
        return returnservice.SearchBorrowing(membID,bookCode);
    }
    
}
