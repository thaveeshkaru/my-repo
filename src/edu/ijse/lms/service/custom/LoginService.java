/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.lms.service.custom;

import edu.ijse.lms.dto.LoginDto;
import edu.ijse.lms.service.SuperService;

/**
 *
 * @author DELL
 */
public interface LoginService extends SuperService{

    public String getLogin(LoginDto dto)throws Exception;
    
}
