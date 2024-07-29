/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.controller;

import edu.ijse.lms.dto.BorrowingDto;
import edu.ijse.lms.dto.ReturnDto;
import edu.ijse.lms.service.ServiceFactory;
import edu.ijse.lms.service.custom.ReturnService;
import edu.ijse.lms.tm.ReturnTM;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author DELL
 */
public class ReturnController {

    private ReturnService returnservice=(ReturnService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RETURN);
    
    ArrayList <ReturnDto> returnDtos = new ArrayList<>();
    
    @FXML
    private TextField bookCodetxt;

    @FXML
    private TableColumn<ReturnTM, String> colBookCode;

    @FXML
    private TableColumn<ReturnTM, Double> colFine;

    @FXML
    private TableColumn<ReturnTM, String> colMemberID;

    @FXML
    private TableColumn<ReturnTM, String> colReturnDate;
    
    @FXML
    private Label borrowingData;

    @FXML
    private TextField finetxt;

    @FXML
    private TextField memberIDtxt;

    @FXML
    private TableView<ReturnTM> returnBooktbl;

    @FXML
    private DatePicker returnDatetxt;
      
    public void initialize() throws Exception {
        colMemberID.setCellValueFactory(new PropertyValueFactory<>("memberID"));
        colBookCode.setCellValueFactory(new PropertyValueFactory<>("bookCode"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        colFine.setCellValueFactory(new PropertyValueFactory<>("fine"));
       
    }

    @FXML
    void btnAddFineOnAction(ActionEvent event) throws Exception {
        
        ReturnDto dto = new ReturnDto();
        dto.setMemberID(memberIDtxt.getText());
        dto.setBookCode(bookCodetxt.getText());
        LocalDate returnld = returnDatetxt.getValue();
        dto.setReturnDate (returnld.toString());
        Double fine = returnservice.searchFine(dto);
        finetxt.setText(Double.toString(fine));

    }

    @FXML
    void btnAddToTableOnAction(ActionEvent event) {

        ReturnDto returndto = new ReturnDto();
        returndto.setMemberID(memberIDtxt.getText());
        returndto.setBookCode(bookCodetxt.getText());
        LocalDate ld = returnDatetxt.getValue();
        returndto.setReturnDate (ld.toString());
        returndto.setFine(Double.parseDouble(finetxt.getText()));
        returnDtos.add(returndto);
        
        ObservableList<ReturnTM> returnTMList = FXCollections.observableArrayList();
        
        for(ReturnDto dto : returnDtos){
            ReturnTM returnTM = new ReturnTM(dto.getMemberID(),dto.getBookCode(),dto.getReturnDate(),dto.getFine());
            returnTMList.add(returnTM);
        }
        
        returnBooktbl.setItems(returnTMList);
        clearForm();
    }

    @FXML
    void btnBorrowingSearchOnAction(ActionEvent event) throws Exception {

          String membID = memberIDtxt.getText();
          String bookCode = bookCodetxt.getText();
          BorrowingDto dto = returnservice.searchBorrowing(membID,bookCode);
          borrowingData.setText("Borrowed - " + dto.getBorrowingDate() + " | " + "Due - " + dto.getDueDate() );
    }

    @FXML
    void btnPlaceReturnOnAction(ActionEvent event) throws Exception {
        
        String resp=returnservice.placeReturn(returnDtos);
         
        if (resp.equals("Success")) {
            new Alert(Alert.AlertType.CONFIRMATION, "Place Return Success").show();
            returnBooktbl.getItems().clear();

        } else {
            new Alert(Alert.AlertType.ERROR, "Error while Placing Return").show();
        }

    }
    
    private void clearForm(){
         memberIDtxt.setText("");
         bookCodetxt.setText("");
         returnDatetxt.setValue(null);
         finetxt.setText("");
     
    }

    public Double searchFine(ReturnDto dto)throws Exception{
        return returnservice.searchFine(dto);
    }

    public String placeReturn(ArrayList<ReturnDto> returnDtos)throws Exception{
        return returnservice.placeReturn(returnDtos);
    }


    public BorrowingDto searchBorrowing(String membID, String bookCode)throws Exception{
        return returnservice.searchBorrowing(membID,bookCode);
    }
    
}
