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
    private String receipt = "";
    
    public Receipt(ICustomer customer){
        this.customer = customer;
        startReceipt(customer);
    }
    
    private void startReceipt(ICustomer customer){
        receipt = "Thank you for shopping at Kohl's\n";
        receipt += "Customer Id: " + customer.getCustId() + "\n";
        receipt += "Customer Name: " +  "\n";
    }
    
    public void writeReceipt(LineItem[] lineItems){
        
        for(LineItem item : lineItems){
          receipt += item.getProduct() + " " + item.getQty() + "\n";
                  
        }
        
        
        System.out.print(receipt);
    }
    
}
