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
    private ReceiptDataAccessStrategy db;
    private ReceiptOutputStrategy print;
    private ICustomer customer;
    private String receipt = "";
    private LineItem[] lineItem = new LineItem[0];
    
    
    public Receipt(String custId, ReceiptDataAccessStrategy db, ReceiptOutputStrategy print){
        startReceipt();
        this.db = db;
        this.customer = db.findCustomer(custId);
        this.print = print;
        addCustomer();
        
    }
    
    private void startReceipt(){
        receipt = "Thank you for shopping at Kohl's\n";
    }
    
    private void addCustomer(){
        receipt += "Customer Id: " + customer.getCustId() + "\n";
        receipt += "Customer Name: " + customer.getName() +  "\n";
    }
    
    public void addProduct(String prodId, int qty){
        LineItem[] temp = new LineItem[lineItem.length + 1];
        
        System.arraycopy(lineItem, 0, temp, 0, lineItem.length);
        
        lineItem = temp;
        temp = null;
        
        lineItem[lineItem.length-1] = new LineItem(db.findProduct(prodId), qty);
        receipt += lineItem[lineItem.length-1].getProduct().getName() + " " + lineItem[lineItem.length-1].getQty() + " " + lineItem[lineItem.length-1].getProduct().getPrice()+ "\n";
    }
    
    public void writeReceipt(){
        print.print(receipt);
    }
    
}
