/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Rinay Shah
 */
public class DeleteCustomerController extends ManagerMenuController implements Initializable {


    @FXML
    private TextField deletetxt;

    @FXML
    private Label output;
    
    
  // Deletes customer's file 
   @FXML
    public void delete(ActionEvent event) throws IOException {
      
      File file = new File(deletetxt.getText());
      if(file.delete()){
      output.setText("File Deleted Successfully");

      }
      else{
        output.setText("Failed to Delete File");

      }
    }
    
    //Returns to Manager interface
    @FXML
    public void back(ActionEvent event) throws IOException {
        FXMLLoader loginPaneLoader = new FXMLLoader(getClass().getResource("ManagerMenu.fxml"));
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
