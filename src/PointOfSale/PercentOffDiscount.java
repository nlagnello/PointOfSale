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
public class PercentOffDiscount implements DiscountStrategy {
    private double discountRate = 0.10;

    public PercentOffDiscount(double discountRate) {
        this.discountRate = discountRate;
    }
    public PercentOffDiscount() {
        
    }

    
    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    
    
    @Override
    public double getDiscountAmt(double price, int qty){
        return price * qty * discountRate;
    }
    
    @Override
    public double getDiscountedTotalAmt(double price, int qty){
        return price * qty  - getDiscountAmt(price, qty);
    }
    
    public static void main(String[] args) {
        PercentOffDiscount d = new PercentOffDiscount();
        double totalDiscounted = d.getDiscountAmt(100.00, 2);
        System.out.println(totalDiscounted);
         totalDiscounted = d.getDiscountedTotalAmt(100.00, 2);
        System.out.println(totalDiscounted);
    }
}
