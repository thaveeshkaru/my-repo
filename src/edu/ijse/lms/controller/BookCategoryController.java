/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.controller;

import edu.ijse.lms.dto.BookCategoryDto;
import edu.ijse.lms.service.ServiceFactory;
import edu.ijse.lms.service.custom.BookCategoryService;
import edu.ijse.lms.tm.BookCategoryTM;
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
public class BookCategoryController {
    private BookCategoryService bookcategoryservice=(BookCategoryService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BOOK_CATEGORY);
    
    @FXML
    private TableView<BookCategoryTM> bookCategorytbl;
    
    @FXML
    private TextField categoryCodetxt;

    @FXML
    private TextField categorytxt;

    @FXML
    private TableColumn<BookCategoryTM, String> colCategory;

    @FXML
    private TableColumn<BookCategoryTM, String> colCategoryCode;

    @FXML
    private TableColumn<BookCategoryTM, String> colDescription;

    @FXML
    private TextField descriptiontxt;
    
    
     public void initialize() throws Exception {
        colCategoryCode.setCellValueFactory(new PropertyValueFactory<>("categoryCode"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
       
        getAllBookCategory();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws Exception {
        
         String categoryCode=categoryCodetxt.getText();
         String resp = bookcategoryservice.deleteCategory(categoryCode);
          
         if (resp.equals("Success")) {
            new Alert(Alert.AlertType.CONFIRMATION, "Delete Success").show();
            getAllBookCategory();
            clearForm();

        } else {
            new Alert(Alert.AlertType.ERROR, "Error Wile Deleteing Book Category").show();
        }
        
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws Exception {
        
         BookCategoryDto categoryDto = new BookCategoryDto(categoryCodetxt.getText(),categorytxt.getText(),descriptiontxt.getText());
         String resp=bookcategoryservice.saveCategory(categoryDto);
         
         if (resp.equals("Success")) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved Success").show();
            getAllBookCategory();
            clearForm();

        } else {
            new Alert(Alert.AlertType.ERROR, "Error While Saving Book Category").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws Exception {
        
        BookCategoryDto categoryDto=new BookCategoryDto(categoryCodetxt.getText(),categorytxt.getText(),descriptiontxt.getText());
        String resp=bookcategoryservice.updateCategory(categoryDto);
        
        if (resp.equals("Success")) {
            new Alert(Alert.AlertType.CONFIRMATION, "Update Success").show();
            getAllBookCategory();
            clearForm();

        } else {
            new Alert(Alert.AlertType.ERROR, "Error While Updating Book Category").show();
        }

    }
    
    public void getAllBookCategory() throws Exception{
    
        ArrayList<BookCategoryDto> categoryDto=bookcategoryservice.getAll();
        ObservableList<BookCategoryTM> bookCategoryTMList = FXCollections.observableArrayList();
        
              for(BookCategoryDto dto:categoryDto){
                  BookCategoryTM bookCategoryTM = new BookCategoryTM(dto.getCategoryCode(),dto.getCategory(),dto.getDescription());
                  bookCategoryTMList.add(bookCategoryTM);
              }
        bookCategorytbl.setItems(bookCategoryTMList);
    }
    
        @FXML
    void onMouseClickedAction(MouseEvent event) {
    
         int index =  bookCategorytbl.getSelectionModel().getSelectedIndex();
         
         categoryCodetxt.setText(colCategoryCode.getCellData(index).toString());
         categorytxt.setText(colCategory.getCellData(index).toString());
         descriptiontxt.setText(colDescription.getCellData(index).toString());

    }
    
    private void clearForm(){
        categoryCodetxt.setText("");
        categorytxt.setText("");
        descriptiontxt.setText("");
    }

}
