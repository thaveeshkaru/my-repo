/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edu.ijse.lms;

import java.io.FileInputStream;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */

public class main extends Application{
    
    private ImageView backgrountImg;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception{
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
       
       //img path 
       Image image = new Image(new FileInputStream("C:\\Users\\DELL\\Downloads\\studio-background-concept-abstract-empty-light-gradient-purple-studio-room-background-product 222.jpg")); //LoginImg   
        
       this.backgrountImg = new ImageView(image);
       backgrountImg.setFitHeight(500);
       backgrountImg.setFitWidth(350);
        
       URL resource = getClass().getResource("/edu/ijse/lms/view/LoginView.fxml");
       Parent root = FXMLLoader.load(resource);
       Group gpRoot = new Group();
       gpRoot.getChildren().add(backgrountImg);
       gpRoot.getChildren().add(root);
       primaryStage.setScene(new Scene(gpRoot));
       primaryStage.show();
       primaryStage.setTitle("Login");
    
       
    }
    
}
