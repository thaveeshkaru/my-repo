/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.lms.dao.coustom;

import edu.ijse.lms.dao.SuperDao;
import edu.ijse.lms.entity.ReturnEntity;

/**
 *
 * @author DELL
 */
public interface ReturnDao extends SuperDao{
    String save(ReturnEntity t) throws Exception;
}
