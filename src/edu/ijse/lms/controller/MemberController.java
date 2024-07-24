/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.controller;

import edu.ijse.lms.dto.MemberDto;
import edu.ijse.lms.service.ServiceFactory;
import edu.ijse.lms.service.custom.MemberService;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class MemberController {
    
    private MemberService memberservice=(MemberService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBER);
    
    public String saveMember(MemberDto membdto)throws Exception{
        return memberservice.saveMember(membdto);
    
    }
    
    public String deleteMember(String membid)throws Exception{
        return memberservice.deleteMember(membid);
    }
    
    public ArrayList<MemberDto> getAll()throws Exception{
        return memberservice.getAll();
    }
    
    public String updateMember(MemberDto memberdto)throws Exception{
        return memberservice.updateMember(memberdto);
    }
    

    public MemberDto get(String membID)throws Exception{
         return memberservice.get(membID);
    }
    
}
