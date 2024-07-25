/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.lms.controller;

import edu.ijse.lms.dto.LoginDto;
import edu.ijse.lms.service.ServiceFactory;
import edu.ijse.lms.service.custom.LoginService;
//import java.awt.Button;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */
public class LoginController {
    
     private LoginService Loginservice=(LoginService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.LOGIN);
    
     @FXML
     private PasswordField passwordtxt;

     @FXML
     private TextField usernametxt;
        
     @FXML
     void btnLoginOnAction(ActionEvent event) throws IOException, Exception{
        
        String UName = usernametxt.getText();
        String password = passwordtxt.getText();
        
        LoginDto dto = new LoginDto(UName,password);
        String resp = Loginservice.getLogin(dto);
        
        if(resp.equals("Success")){
            URL resource = this.getClass().getResource("/edu/ijse/lms/view/HomePageView.fxml");
            Parent node = FXMLLoader.load(resource);
            Stage stage = new Stage();
            stage.setScene(new Scene(node));
            stage.show();
            stage.setTitle("LMS Home");
            
        }else {
            new Alert(Alert.AlertType.ERROR, resp).show();
        }
        
        
    }
}
