/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.lms.service.custom;

import edu.ijse.lms.service.SuperService;
import edu.ijse.lms.dto.MemberDto;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface MemberService extends SuperService{
   public String saveMember(MemberDto membdto) throws Exception;
   public String deleteMember(String membid)throws Exception;
   public ArrayList<MemberDto> getAll()throws Exception;
   public String updateMember(MemberDto memberdto)throws Exception;
   public MemberDto get(String membID)throws Exception;
}
