/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PointOfSale;

/**
 *
 * @author nagnello
 */
public class Receipt {
    private ICustomer customer;
    private Product product;
    private String receipt;
    
    public Receipt(ICustomer customer){
        this.customer = customer;
        startReceipt(customer);
    }
    
    private void startReceipt(ICustomer customer){
        receipt = "Thank you for shopping at Kohl's\n";
        receipt += "Customer Id: " + customer.getCustId() + "\n";
        receipt += "Customer Name: " + customer;
    }
    
    private void writeReceipt(){
        
    }
    private void printReceipt(){
        
    }
    
}
