/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
 * FXML Controller class
 *
 * @author Rinay Shah
 */

public class CustomerMenuController extends LoginController implements Initializable {

    @FXML
    private Label display;
    @FXML
    private TextField amount;
    private double transaction, balance;
    protected String displayLevel;
    private ArrayList<String> customerData;

    private FileWriter writer;
    private File file;
    
    private Level fee = new Silver();
    private Level level = new Silver();
    
    //sets the customer data in an arraylist, recieved from the login page
    public void setCustomerData(ArrayList<String> data) {
        customerData = data;
    }
    
    //returns the balance to the customer in a label
    public void getBalance(ActionEvent event) throws IOException {
        level.changeLevel(this);
        display.setText("Your balance is : $" + customerData.get(2) + "\nLevel : " + level);
    }
    //returns the balance as a double 
    public double getBalance() {
        balance = Double.parseDouble(customerData.get(2));
        return balance;
    }
    //withdraws the money from customer file's balance, and checks the state of the customer after withdrawing.
    public void withdrawMoney(ActionEvent event) throws IOException {
       
        try {
            transaction = Double.parseDouble(amount.getText());
        } catch (NumberFormatException nfe) {
            display.setText("Please enter a valid amount");
        }
        if (transaction > 0 && amount != null) {
            balance = Double.parseDouble(customerData.get(2));
            balance -= transaction;

            if (balance > 0) {
                customerData.set(2, Double.toString(balance));

                file = new File(customerData.get(0));
                writer = new FileWriter(file);

                writer.write(customerData.get(0));
                writer.write(System.getProperty("line.separator"));
                writer.write(customerData.get(1));
                writer.write(System.getProperty("line.separator"));
                writer.write(customerData.get(2));
                
                level.changeLevel(this);
                display.setText("You withdrew: $" + transaction + "\nBalance: $" + balance + "\nLevel : " + level);
            } else {
                display.setText("Insufficient Funds");
            }

        } else {
            display.setText("Please enter an amount greater than $0.00");
        }
        writer.close();
    }
    
    //deposits the money to customer file's balance, and checks the state of the customer after depositing.
    public void depositMoney(ActionEvent event) throws IOException {
        try {
            transaction = Double.parseDouble(amount.getText());
        } catch (NumberFormatException nfe) {
            display.setText("Please enter a valid amount");
        }
        if (transaction > 0 && transaction < 100000000 && amount != null ) {
            balance = Double.parseDouble(customerData.get(2));
            balance += transaction;
            customerData.set(2, Double.toString(balance));

            file = new File(customerData.get(0));
            writer = new FileWriter(file);

            writer.write(customerData.get(0));
            writer.write(System.getProperty("line.separator"));
            writer.write(customerData.get(1));
            writer.write(System.getProperty("line.separator"));
            writer.write(customerData.get(2));
            
            level.changeLevel(this);
            display.setText("You deposited: $" + transaction + "\nBalance: $" + balance + "\nLevel : " + level);
        } else {
            if(balance<0)
            display.setText("Please enter an amount greater than $0.00");
            else
                 display.setText("Please enter a lower amount");
        }
        writer.close();

    }
    
    //purchases made online and  withdraws from customer file's balance, and checks the state of the customer after withdrawing
    //fees for purchasing online are handled concrete state subclasses and customers cant make purchases less than 50 dollars
    public void purchaseOnline(ActionEvent event) throws IOException {
        
        try {
            transaction = Double.parseDouble(amount.getText());
        } catch (NumberFormatException nfe) {
          display.setText("Please enter a valid amount");
        }
        if (transaction > 50.00 && amount != null) {
            balance = Double.parseDouble(customerData.get(2));
            balance -= (transaction + level.getFee());
            if (balance > 0) {
                customerData.set(2, Double.toString(balance));

                file = new File(customerData.get(0));
                writer = new FileWriter(file);

                writer.write(customerData.get(0));
                writer.write(System.getProperty("line.separator"));
                writer.write(customerData.get(1));
                writer.write(System.getProperty("line.separator"));
                writer.write(customerData.get(2));
                
                level.changeLevel(this);
               display.setText("You purchased: $" + transaction + "\nBalance: $" + balance);
            } else {
                display.setText("Insufficient Funds");
            }
        } else {
            display.setText("The purchase needs to be higher than $50.00");
        }
        writer.close();

    }
    
    //returns the scene to the login page
    public void logout(ActionEvent event) throws IOException {
        FXMLLoader loginPaneLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loginPaneLoader.load();
        Scene login = new Scene(root);

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(login);
        primaryStage.show();

    }

    //sets the state
    public void setLevel(Level l) {
        level= l;
    }
    
    //gets the state
    public Level getLevel() {
        return level;
    }
    
    //sets the fee
   public void setFee(Level f) {
        fee= f;
    }
    
    //gets the fee
    public Level getFee() {
        return fee;
    }
    /**
     * Initializes the controller class.
     *
     */
    public void initialize() {
    }

}
