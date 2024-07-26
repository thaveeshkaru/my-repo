/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.controller;

import edu.ijse.lms.dto.BookDto;
import edu.ijse.lms.service.ServiceFactory;
import edu.ijse.lms.service.custom.BookService;
import edu.ijse.lms.tm.BookTM;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class BookController {
    
    private BookService bookservice=(BookService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BOOK);
    
    @FXML
    private TableView<BookTM> booktbl;
    
        @FXML
    private TableColumn<BookTM, String> colAuthor;

    @FXML
    private TableColumn<BookTM, Integer> colAvailability;

    @FXML
    private TableColumn<BookTM, String> colBookCode;

    @FXML
    private TableColumn<BookTM, String> colBookTitle;

    @FXML
    private TableColumn<BookTM, String> colCategoryCode;
    
    @FXML
    private TextField authortxt;

    @FXML
    private TextField availabilitytxt;

    @FXML
    private TextField bookCodetxt;

    @FXML
    private TextField bookTitletxt;

    @FXML
    private TextField categoryCodeTxt;

    @FXML
    void btnBackOnAction(ActionEvent event) {
        
    }
    
    
    public void initialize() throws Exception {
        colBookCode.setCellValueFactory(new PropertyValueFactory<>("bookCode"));
        colBookTitle.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colCategoryCode.setCellValueFactory(new PropertyValueFactory<>("categoryCode"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
       

        getAllBooks();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws Exception {
        String bookCode = bookCodetxt.getText();
        String resp = bookservice.deleteBook(bookCode);
        
        if (resp.equals("Success")) {
            new Alert(Alert.AlertType.CONFIRMATION, "Delete Success").show();
            getAllBooks();
            clearForm();

        } else {
            new Alert(Alert.AlertType.ERROR, "Error while Deleating Book").show();
        }
        

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws Exception {
        String bookCode = bookCodetxt.getText();
        String bookTitle = bookTitletxt.getText();
        String author= authortxt.getText();
        String categoryCode = categoryCodeTxt.getText();
        int availability = Integer.parseInt(availabilitytxt.getText());
        
        BookDto bookDto = new BookDto(bookCode, bookTitle, author, categoryCode, availability);
        String resp = bookservice.saveBook(bookDto);
        
        if (resp.equals("Success")) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved Success").show();
            getAllBooks();
            clearForm();

        } else {
            new Alert(Alert.AlertType.ERROR, "Error while Saving Book").show();
        }
        
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws Exception {
        
        BookDto bookDto=new BookDto(bookCodetxt.getText(),bookTitletxt.getText(),authortxt.getText(),categoryCodeTxt.getText(),Integer.parseInt(availabilitytxt.getText()));
        String resp = bookservice.updateBook(bookDto);
        
         if (resp.equals("Success")) {
            new Alert(Alert.AlertType.CONFIRMATION, "Update Success").show();
            getAllBooks();
            clearForm();

        } else {
            new Alert(Alert.AlertType.ERROR, "Error while Updating Book").show();
        }
         
    }
    
    public void getAllBooks() throws Exception{
        
         ArrayList<BookDto> bookDto=bookservice.getAll();        
         ObservableList<BookTM> bookTmList = FXCollections.observableArrayList();
        
              for(BookDto bookdto:bookDto){
                  BookTM bookTM = new BookTM(bookdto.getBookCode(),bookdto.getBookTitle(),bookdto.getAuthor(),bookdto.getCategoryCode(),bookdto.getAvailability());
                  bookTmList.add(bookTM);
              }
              
          booktbl.setItems(bookTmList);
              
    }
    
    private void clearForm(){
        bookCodetxt.setText("");
        bookTitletxt.setText("");
        authortxt.setText("");
        categoryCodeTxt.setText("");
        availabilitytxt.setText("");
        
    }
    
    public String saveBook(BookDto bookDto)throws Exception{
        return bookservice.saveBook(bookDto);
    }
    
    public String updateBook(BookDto bookDto)throws Exception{
        return bookservice.updateBook(bookDto);
    }
    
    public String deleteBook(String bookID)throws Exception{
        return bookservice.deleteBook(bookID);
    }
    
    public ArrayList<BookDto> getAll() throws Exception{
        return bookservice.getAll();
    }

    public BookDto get(String bookID)throws Exception{
        return bookservice.get(bookID);
                
    }
}
