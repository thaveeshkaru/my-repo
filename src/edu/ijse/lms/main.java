/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edu.ijse.lms;

//import edu.ijse.lms.view.BookCategoryView;
//import edu.ijse.lms.view.BookView;
//import edu.ijse.lms.view.BorrowingView;
//import edu.ijse.lms.view.LoginView;
//import edu.ijse.lms.view.MemberView;
//import edu.ijse.lms.view.ReturnView;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */

public class main extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception{
        System.out.println("Hello, World!");
        launch(args);
        // TODO code application logic here
        //  new LoginView().setVisible(true);
       //  new MemberView().setVisible(true);
     //    new BookView().setVisible(true);
       //   new BookCategoryView().setVisible(true);
      //    new BorrowingView().setVisible(true);
       //   new ReturnView().setVisible(true);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
       URL resource = getClass().getResource("/edu/ijse/lms/view/LoginView.fxml");
       Parent root = FXMLLoader.load(resource);
       primaryStage.setScene(new Scene(root));
       primaryStage.show();
       primaryStage.setTitle("Login");
    
       
    }
    
}
