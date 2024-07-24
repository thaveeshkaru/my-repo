/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.service.custom.impl;

import edu.ijse.lms.dao.DaoFactory;
import edu.ijse.lms.dao.coustom.MemberDao;
import edu.ijse.lms.dto.MemberDto;
import edu.ijse.lms.entity.MemberEntity;
import edu.ijse.lms.service.custom.MemberService;
import java.util.ArrayList;



/**
 *
 * @author DELL
 */
public class MemberServiceImpl implements MemberService{
    
     private MemberDao memberDao= (MemberDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.MEMBER);

    @Override
    public String saveMember(MemberDto membdto) throws Exception {
        MemberEntity entity = new MemberEntity(membdto.getMemberID(),membdto.getMemberName(),membdto.getAddress(),membdto.getContact());
        return memberDao.save(entity);
    }

    @Override
    public String deleteMember(String membid) throws Exception {
        return memberDao.delete(membid);
    }

    @Override
    public ArrayList<MemberDto> getAll() throws Exception {
        ArrayList<MemberEntity> entities=memberDao.getAll();
        ArrayList<MemberDto> dtos=new ArrayList<>();
        for(MemberEntity memberEntity:entities){
            MemberDto memberDto=new MemberDto(memberEntity.getMemberID(),memberEntity.getMemberName(),memberEntity.getAddress(),memberEntity.getContact());  
            dtos.add(memberDto);
        }
        return dtos;
    }

    @Override
    public String updateMember(MemberDto memberdto) throws Exception {
        MemberEntity entity = new MemberEntity(memberdto.getMemberID(),memberdto.getMemberName(),memberdto.getAddress(),memberdto.getContact());
        return memberDao.update(entity);
    }

    @Override
    public MemberDto get(String membID) throws Exception {
        MemberEntity entity = memberDao.get(membID);
        MemberDto dto = new MemberDto(entity.getMemberID(),entity.getMemberName(),entity.getAddress(),entity.getContact());
        return dto;
    }
    
    
    
}
