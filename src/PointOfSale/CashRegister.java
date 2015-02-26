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

    
    private Receipt receipt;

    public CashRegister(){
    
    }
    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    
   
    public void startNewSale(String custId, ReceiptDataAccessStrategy db){
        receipt = new Receipt(custId, db);
        
        
        
    }
    
    //add product to lineItem array
    public void scanProduct(String prodId, int qty){
        receipt.addProduct(prodId, qty);
        
    }
    
    //add Line items to receipt
    //figure out discounts and savings, calculate total, print receipt
    public void endSale(){
        receipt.writeReceipt();
    }
}
