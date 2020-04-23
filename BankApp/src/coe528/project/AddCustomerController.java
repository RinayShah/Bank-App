/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Rinay Shah
 */
public class AddCustomerController extends ManagerMenuController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField balance;
    @FXML
    private Label balancetxt;
    
    private double balanceamount;

    //Creates a file for new customers  
    @FXML
    public void submit(ActionEvent event) throws IOException {
        
     balanceamount = Double.parseDouble(balance.getText());
     
     
     if (balanceamount >= 100 && (!username.getText().equals(password.getText())) && !username.getText().equals("test") && !username.getText().equals("Test")){
         
         StringBuilder sb = new StringBuilder();
         sb.append(username.getText()).append("\n");
         sb.append(password.getText()).append("\n");
         sb.append(balance.getText()).append("\n");
         
         File file = new File(username.getText());
         FileWriter W = new FileWriter(file);
         W.write(sb.toString());
         W.close();
         
     }
     else if (username.getText().equals("test") || username.getText().equals("Test")){
        balancetxt.setText("Username cannot be called test!");

     }
     else if (username.getText().equals(password.getText())){
         balancetxt.setText("Username cannot be same as password!");
     }
     else if (balanceamount < 100){
         balancetxt.setText("$100 dollar balance required!");
     }
     else {
         balancetxt.setText("Invalid Entry!");
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
