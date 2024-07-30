/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.controller;

import edu.ijse.lms.dto.MemberDto;
import edu.ijse.lms.service.ServiceFactory;
import edu.ijse.lms.service.custom.MemberService;
import edu.ijse.lms.tm.MemberTM;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author DELL
 */
public class MemberController {
    
    private MemberService memberservice=(MemberService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBER);
    
    @FXML
    private TextField addresstxt;

    @FXML
    private TableColumn<MemberTM, String> colAddress;

    @FXML
    private TableColumn<MemberTM, Integer> colContact;

    @FXML
    private TableColumn<MemberTM, String> colMemberID;

    @FXML
    private TableColumn<MemberTM, String> colName;

    @FXML
    private TextField contacttxt;

    @FXML
    private TextField memberIdtxt;

    @FXML
    private TableView<MemberTM> membertbl;

    @FXML
    private TextField nametxt;
    
    
    
    public void initialize() throws Exception {
        colMemberID.setCellValueFactory(new PropertyValueFactory<>("memberID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("memberName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        
        getAllMembers();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws Exception {
        
        String membid=memberIdtxt.getText();
        String resp=memberservice.deleteMember(membid);
            
        if (resp.equals("Success")) {
            new Alert(Alert.AlertType.CONFIRMATION, "Delete Success").show();
            getAllMembers();
            clearForm();

        } else {
            new Alert(Alert.AlertType.ERROR, "Error while Deleting Member").show();
        }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws Exception {
        
        MemberDto membdto=new MemberDto(memberIdtxt.getText(),nametxt.getText(),addresstxt.getText(),Integer.parseInt(contacttxt.getText()));
        String resp = memberservice.saveMember(membdto);
          
        if (resp.equals("Success")) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved Success").show();
            getAllMembers();
            clearForm();

        } else {
            new Alert(Alert.AlertType.ERROR, "Error while Saving Member").show();
        }

    }
    
    @FXML
    void btnUpdateOnAction(ActionEvent event) throws Exception {
        
        MemberDto memberDto=new MemberDto(memberIdtxt.getText(),nametxt.getText(),addresstxt.getText(),Integer.parseInt(contacttxt.getText()));
        String resp = memberservice.updateMember(memberDto);
        
        if (resp.equals("Success")) {
            new Alert(Alert.AlertType.CONFIRMATION, "Update Success").show();
            getAllMembers();
            clearForm();

        } else {
            new Alert(Alert.AlertType.ERROR, "Error while Updating Member").show();
        }
 
    }
    
    public void getAllMembers() throws Exception{
        
        ArrayList<MemberDto> memberDtos=memberservice.getAll();
        ObservableList<MemberTM> memberTMList = FXCollections.observableArrayList();
        
              for (MemberDto memberdto:memberDtos){
                  MemberTM memberTM = new MemberTM(memberdto.getMemberID(),memberdto.getMemberName(),memberdto.getAddress(),memberdto.getContact());
                  memberTMList.add(memberTM);
              }
        membertbl.setItems(memberTMList);
    }
    
    private void clearForm(){
        memberIdtxt.setText("");
        nametxt.setText("");
        addresstxt.setText("");
        contacttxt.setText("");
    }
    
    @FXML
    void onMouseClickedAction(MouseEvent event) {

        int index =  membertbl.getSelectionModel().getSelectedIndex();
        
         memberIdtxt.setText(colMemberID.getCellData(index).toString());
         nametxt.setText(colName.getCellData(index).toString());
         addresstxt.setText(colAddress.getCellData(index).toString());
         contacttxt.setText(colContact.getCellData(index).toString());
        
    }
    
}
