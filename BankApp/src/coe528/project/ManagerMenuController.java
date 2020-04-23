/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rinay Shah
 */
public class ManagerMenuController extends LoginController implements Initializable {

    /**
     * Initializes the controller class.
     * @param event
     * @throws java.io.IOException
     */
    
    //Goes to add customer GUI
    @FXML
     public void addCustomer(ActionEvent event) throws IOException {
        FXMLLoader loginPaneLoader = new FXMLLoader(getClass().getResource("AddCustomer.fxml"));
        Parent root = loginPaneLoader.load();
        Scene login = new Scene(root);

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(login);
        primaryStage.show();

    }
     //Goes to delete customer GUI
    @FXML
        public void deleteCustomer(ActionEvent event) throws IOException {
        FXMLLoader loginPaneLoader = new FXMLLoader(getClass().getResource("DeleteCustomer.fxml"));
        Parent root = loginPaneLoader.load();
        Scene login = new Scene(root);

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(login);
        primaryStage.show();

    }
    
    //Goes to login GUI
    @FXML
    public void logout(ActionEvent event) throws IOException {
        FXMLLoader loginPaneLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loginPaneLoader.load();
        Scene login = new Scene(root);

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(login);
        primaryStage.show();

    }
      
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
