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
public class StartUp {
    
    public static void main(String[] args) {
        
    
    //Start Sale
    
    //Add Products
    
    //End Sale
    CashRegister cr = new CashRegister();
    
    cr.startNewSale("100", new SampleDatabase(), new SystemPrintReceipt());
    cr.scanProduct("A101", 2);
    cr.scanProduct("B205", 1);
    cr.endSale();
    }
}
