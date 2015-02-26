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
public class SystemPrintReceipt implements ReceiptOutputStrategy{

    @Override
    public void print(String receipt) {
        System.out.print(receipt);
        }
    
}
