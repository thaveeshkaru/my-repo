/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.lms.dao.coustom;

import edu.ijse.lms.dao.CrudDao;
import edu.ijse.lms.dao.SuperDao;
import edu.ijse.lms.entity.BorrowingEntity;
import edu.ijse.lms.entity.ReturnEntity;

/**
 *
 * @author DELL
 */
public interface BorrowingDao extends SuperDao{
    
    String save(BorrowingEntity t) throws Exception;
    BorrowingEntity get( String memberID,String bookCode) throws Exception;
    public String delete(String memberID,String bookCode)throws Exception;
}
