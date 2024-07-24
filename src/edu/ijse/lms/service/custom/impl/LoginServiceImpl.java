/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.service.custom.impl;

import edu.ijse.lms.dao.DaoFactory;
import edu.ijse.lms.dao.coustom.LoginDao;
import edu.ijse.lms.dto.LoginDto;
import edu.ijse.lms.entity.LoginEntity;
import edu.ijse.lms.service.custom.LoginService;
import edu.ijse.lms.view.MemberView;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class LoginServiceImpl implements LoginService{

    private LoginDao LoginDao = (LoginDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.LOGIN);
    
    @Override
    public String getLogin(LoginDto dto)throws Exception{
        ArrayList<LoginEntity> entities=LoginDao.getAll();
        
        for(LoginEntity Entity:entities){
            if (!Entity.getUserName().equals(dto.getUserName())){
                return "Invalid UserName";
            } if(!Entity.getPassword().equals(dto.getPassword())){
                return "Invalid Password";
              }else{
                 //new MemberView().setVisible(true);
                 return "Success";
            }
            
        }
        return null;
    
    }
    
}
