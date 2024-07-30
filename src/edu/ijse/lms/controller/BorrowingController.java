/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.controller;

import edu.ijse.lms.dto.BookDto;
import edu.ijse.lms.dto.BorrowingDto;
import edu.ijse.lms.dto.MemberDto;
import edu.ijse.lms.service.ServiceFactory;
import edu.ijse.lms.service.custom.BorrowingService;
import edu.ijse.lms.tm.BorrowingTM;
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
public class BorrowingController {
    
    private BorrowingService borrowingservice=(BorrowingService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BORROW);
    
    private ArrayList<BorrowingDto> borrowingDtos = new ArrayList<>();

    @FXML
    private Label bookData;
    
    @FXML
    private Label memberData;
        
    @FXML
    private TextField bookCodetxt;

    @FXML
    private DatePicker borrowingDatetxt;

    @FXML
    private TableView<BorrowingTM> borrowingtbl;

    @FXML
    private TableColumn<BorrowingTM, String> colBookCode;

    @FXML
    private TableColumn<BorrowingTM, String> colBorrowingDate;

    @FXML
    private TableColumn<BorrowingTM, String> colDueDate;

    @FXML
    private TableColumn<BorrowingTM, String> colMemberID;

    @FXML
    private DatePicker dueDatetxt;

    @FXML
    private TextField memberIDtxt;

    
    public void initialize() throws Exception {
        colMemberID.setCellValueFactory(new PropertyValueFactory<>("memberID"));
        colBookCode.setCellValueFactory(new PropertyValueFactory<>("bookCode"));
        colBorrowingDate.setCellValueFactory(new PropertyValueFactory<>("borrowingDate"));
        colDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        
    }
    

    @FXML
    void btnAddOnAction(ActionEvent event) {
        
        BorrowingDto borrowingDto = new BorrowingDto();
        borrowingDto.setMemberID(memberIDtxt.getText());
        borrowingDto.setBookCode(bookCodetxt.getText());
        LocalDate borrowld = borrowingDatetxt.getValue();
        borrowingDto.setBorrowingDate(borrowld.toString());
        LocalDate dueld = dueDatetxt.getValue();
        borrowingDto.setDueDate(dueld.toString());
      //System.out.println(borrowingDto.getDueDate());
        
        borrowingDtos.add(borrowingDto);
         
        ObservableList<BorrowingTM> borrowingTMList = FXCollections.observableArrayList();
        
        for(BorrowingDto Dto: borrowingDtos ){
            BorrowingTM borrowingTM = new BorrowingTM(Dto.getMemberID(),Dto.getBookCode(),Dto.getBorrowingDate(),Dto.getDueDate());
            borrowingTMList.add(borrowingTM);
            borrowingtbl.setItems(borrowingTMList);
        }
        
        clearForm();

    }

    @FXML
    void btnBookSearchOnAction(ActionEvent event) throws Exception {

        String bookCode = bookCodetxt.getText();
        BookDto dto = borrowingservice.getBook(bookCode);
        bookData.setText(dto.getBookTitle() + " | " + dto.getAvailability());
        
    }

    @FXML
    void btnMemberSearchOnAction(ActionEvent event) throws Exception {
         String membID = memberIDtxt.getText();
         MemberDto dto = borrowingservice.getMember(membID);
         memberData.setText(dto.getMemberName() + " | " + dto.getAddress() + " | " + dto.getContact());
    }

    @FXML
    void btnPlaceOnAction(ActionEvent event) throws Exception {

         String resp=borrowingservice.placeBorrowing(borrowingDtos);
          
         if (resp.equals("Success")) {
            new Alert(Alert.AlertType.CONFIRMATION, "Place Borrow Success").show();
            borrowingtbl.getItems().clear();
            
        } else {
            new Alert(Alert.AlertType.ERROR, resp).show();
        }
        

    }
    
    private void clearForm(){
        memberIDtxt.setText("");
        bookCodetxt.setText("");
        borrowingDatetxt.setValue(null);
        dueDatetxt.setValue(null);
    }

    public MemberDto getMember(String membID)throws Exception{
        return borrowingservice.getMember(membID);
    }

    public BookDto getBook(String bookCode)throws Exception{
        return borrowingservice.getBook(bookCode);
    }


    public String placeBorrowing(ArrayList<BorrowingDto> borrowingDtos)throws Exception{
        return borrowingservice.placeBorrowing(borrowingDtos);
    }
    
}
