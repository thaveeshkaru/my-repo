/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.lms.dao.coustom;

import edu.ijse.lms.dao.SuperDao;
import edu.ijse.lms.entity.ReturnEntity;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface ReturnDao extends SuperDao{
    String save(ReturnEntity t) throws Exception;
    public ArrayList<ReturnEntity> getAll()throws Exception;
    public String delete(String memberID, String bookCode, String returnDate)throws Exception;
}
