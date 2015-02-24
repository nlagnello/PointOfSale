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
public class NoDiscount implements DiscountStrategy{
    private double discountRate = 0;
    
    public NoDiscount(){
        
    }
    @Override
    public double getDiscountAmt(double price, int qty) {
        return price * qty;
                }

    @Override
    public double getDiscountRate() {
        return 0;
    }

    @Override
    public double getDiscountedTotalAmt(double price, int qty) {
        return price * qty;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        this.discountRate = 0;
    }
    
}
