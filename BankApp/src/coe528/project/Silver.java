/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author Rinay Shah
 */
//Sets purchase fee for Silver level changes the Level of customer to Silver
public class Silver implements Level {

    int fee = 20;
    
    @Override
    public void changeLevel(CustomerMenuController customer){
        double balance = customer.getBalance();
        if (balance < 10000){
            customer.setLevel(new Silver());
        } else if (balance >= 10000 && balance < 20000){
            customer.setLevel(new Gold());
        }
        else {
            customer.setLevel(new Platinum());
        }
        
    }
    
    //gets the fee
    @Override 
    public int getFee(){
    return fee;
    }
    
    //Returns the string
    @Override
    public String toString(){
        return "Silver";
    
    }
 
}
