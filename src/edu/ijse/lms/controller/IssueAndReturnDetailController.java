/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.controller;

import edu.ijse.lms.dto.BorrowingDto;
import edu.ijse.lms.dto.ReturnDto;
import edu.ijse.lms.service.ServiceFactory;
import edu.ijse.lms.service.custom.BorrowingService;
import edu.ijse.lms.service.custom.ReturnService;
import edu.ijse.lms.tm.BorrowingTM;
import edu.ijse.lms.tm.ReturnTM;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author DELL
 */
public class IssueAndReturnDetailController {
        private BorrowingService borrowingservice=(BorrowingService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BORROW);
        private ReturnService returnservice=(ReturnService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RETURN);
        
        @FXML
        private TableView<BorrowingTM> borrowingtbl;

        @FXML
        private TableColumn<BorrowingTM, String> colBorrowBookCode;

        @FXML
        private TableColumn<BorrowingTM, String> colBorrowMemberID;

        @FXML
        private TableColumn<BorrowingTM, String> colBorrowingDate;

        @FXML
        private TableColumn<BorrowingTM, String> colDueDate;

        @FXML
        private TableColumn<ReturnTM, Double> colFine;

        @FXML
        private TableColumn<ReturnTM, String> colReturnDate;

        @FXML
        private TableColumn<ReturnTM, String> colReturnMemberID;

        @FXML
        private TableColumn<ReturnTM, String> colreturnBookCode;

        @FXML
        private TableView<ReturnTM> returntbl;
        
        
        public void initialize() throws Exception {
            colBorrowMemberID.setCellValueFactory(new PropertyValueFactory<>("memberID"));
            colBorrowBookCode.setCellValueFactory(new PropertyValueFactory<>("bookCode"));
            colBorrowingDate.setCellValueFactory(new PropertyValueFactory<>("borrowingDate"));
            colDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
            
            getAllBorrowings();
            
            colReturnMemberID.setCellValueFactory(new PropertyValueFactory<>("memberID"));
            colreturnBookCode.setCellValueFactory(new PropertyValueFactory<>("bookCode"));
            colReturnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
            colFine.setCellValueFactory(new PropertyValueFactory<>("fine"));
            
            getAllReturnDetails();
         
        }
        
        
        public void getAllBorrowings() throws Exception{
             ArrayList<BorrowingDto> borrowingDtos=borrowingservice.getAll();
             ObservableList<BorrowingTM> borrowingTMList = FXCollections.observableArrayList();
        
             for (BorrowingDto borrowingdto:borrowingDtos){
                  BorrowingTM borrowingTM = new BorrowingTM(borrowingdto.getMemberID(),borrowingdto.getBookCode(),borrowingdto.getBorrowingDate(),borrowingdto.getDueDate());
                  borrowingTMList.add(borrowingTM);
              }
              
             borrowingtbl.setItems(borrowingTMList);
        }
        
        public void getAllReturnDetails() throws Exception{
            ArrayList<ReturnDto> returnDtos=returnservice.getAll();
            ObservableList<ReturnTM> returnTMList = FXCollections.observableArrayList();
            
            for(ReturnDto returndto:returnDtos){
                ReturnTM returnTM = new ReturnTM(returndto.getMemberID(),returndto.getBookCode(),returndto.getReturnDate(),returndto.getFine()); 
                returnTMList.add(returnTM);
            }

                returntbl.setItems(returnTMList);
        }
        
        @FXML
        void btnBorrowingDeleteOnAction(ActionEvent event) throws Exception {
               int index =  borrowingtbl.getSelectionModel().getSelectedIndex();
               
               String memberID = colBorrowMemberID.getCellData(index).toString();
               String bookCode = colBorrowBookCode.getCellData(index).toString();
               
               String resp = borrowingservice.delete(memberID,bookCode);
               
               if (resp.equals("Success")) {
                  new Alert(Alert.AlertType.CONFIRMATION, "Delete Success").show();
                  getAllBorrowings();

              } else {
                 new Alert(Alert.AlertType.ERROR, "Error While Deleting Borrow Book").show();
              }
               
        }

        @FXML
        void btnReturnDeleteOnAction(ActionEvent event) throws Exception {
                 int index = returntbl.getSelectionModel().getSelectedIndex();
                 
               String memberID = colReturnMemberID.getCellData(index).toString();
               String bookCode = colreturnBookCode.getCellData(index).toString();
               String returnDate = colReturnDate.getCellData(index).toString();
               
               String resp = returnservice.delete(memberID,bookCode,returnDate);
               
               if (resp.equals("Success")) {
                  new Alert(Alert.AlertType.CONFIRMATION, "Delete Success").show();
                  getAllReturnDetails();

              } else {
                 new Alert(Alert.AlertType.ERROR, "Error While Deleting Return Book").show();
              }

        }
        
        

}
