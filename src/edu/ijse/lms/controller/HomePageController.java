/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.controller;

import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */
public class HomePageController {
    
    
    
    @FXML
    void btnMemberOnAction(ActionEvent event) throws IOException {
        
        URL resource = this.getClass().getResource("/edu/ijse/lms/view/MemberView.fxml");
        Parent node = FXMLLoader.load(resource);
        Stage stage = new Stage();
        stage.setScene(new Scene(node));
        stage.show();
        stage.setTitle("Member Form");
        

    }
    
    @FXML
    void btnBookOnAction(ActionEvent event) throws IOException {
        
         URL resource = this.getClass().getResource("/edu/ijse/lms/view/BookView.fxml");
         Parent node = FXMLLoader.load(resource);
         Stage stage = new Stage();
         stage.setScene(new Scene(node));
         stage.show();
         stage.setTitle("Book Form");
            
    }
    
    @FXML
    void btnBookCategoryOnAction(ActionEvent event) throws IOException {
        
        URL resourse = this.getClass().getResource("/edu/ijse/lms/view/BookCategoryView.fxml");
        Parent node = FXMLLoader.load(resourse);
        Stage stage = new Stage();
        stage.setScene(new Scene(node));
        stage.show();
        stage.setTitle("Book Category");
        

    }

    

    @FXML
    void btnIssueBookOnAction(ActionEvent event) throws IOException {
        
        URL resourse = this.getClass().getResource("/edu/ijse/lms/view/BorrowingView.fxml");
        Parent node = FXMLLoader.load(resourse);
        Stage stage = new Stage();
        stage.setScene(new Scene(node));
        stage.show();
        stage.setTitle("Borrowing Book");
        

    }

    @FXML
    void btnReturnBookOnAction(ActionEvent event) throws IOException {
        URL resourse = this.getClass().getResource("/edu/ijse/lms/view/ReturnView.fxml");
        Parent node = FXMLLoader.load(resourse);
        Stage stage = new Stage();
        stage.setScene(new Scene(node));
        stage.show();
        stage.setTitle("Return Book");

    }
}
