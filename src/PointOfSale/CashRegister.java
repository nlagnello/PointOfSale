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
public class CashRegister {

    private final ReceiptDataAccessStrategy db = new SampleDatabase();
    private Receipt receipt;
    private ICustomer customer;
    private LineItem[] lineItem;
    private Product product;
    
    
    public CashRegister(){
    
    }
    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public ICustomer getCustomer() {
        return customer;
    }

    public void setCustomer(ICustomer customer) {
        this.customer = customer; 
    }
    
    
    //create receipt, add customer, create lineItem Array(empty)
    public void startNewSale(String custId){
        customer = db.findCustomer(custId);
        System.out.println("Cash" +customer.getCustId());
        receipt = new Receipt(customer);
        lineItem = new LineItem[0];
    }
    
    //add product to lineItem array
    public void scanProduct(String prodId, int qty){
        LineItem[] temp = new LineItem[lineItem.length + 1];
        
        for(int i = 0; i < lineItem.length; i++){
            temp[i] = lineItem[i];
        }
        
        lineItem = temp;
        temp = null;
        
        lineItem[lineItem.length-1].addProduct(db.findProduct(prodId), qty);
        
    }
    
    //add Line items to receipt
    //figure out discounts and savings, calculate total, print receipt
    public void endSale(){
        receipt.writeReceipt(lineItem);
    }
}
