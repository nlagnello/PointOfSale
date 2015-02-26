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

    private SampleDatabase db;
    private Receipt receipt;
    private ICustomer customer;
    private LineItem[] lineItem;
    private Product product;
    private int lineItemCount = 0;
    
    public CashRegister(){
    receipt = new Receipt();
    db = new SampleDatabase();
    
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
    
    
    
    public void startNewSale(String custId){
        customer = db.findCustomer(custId);
        lineItem = new LineItem[5];
    }
    public void scanProduct(String prodId, int qty){
        lineItem[lineItemCount].addProduct(db.findProduct(prodId), qty);
        
    }
    public void endSale(){
        
    }
}
