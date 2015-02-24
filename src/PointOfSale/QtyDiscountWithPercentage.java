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
public class QtyDiscountWithPercentage implements DiscountStrategy {
    private double discountRate = 0.10;
    private int minQty = 5;

    public QtyDiscountWithPercentage(double discountRate, int minQty) {
        this.discountRate = discountRate;
        this.minQty = minQty;
    }
    public QtyDiscountWithPercentage() {
        
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
        if(qty >= minQty){
           return price * qty * discountRate; 
        }else{
            return 0;
        }
        
    }
    
    @Override
    public double getDiscountedTotalAmt(double price, int qty){
        if(qty >= minQty){
            return price * qty  - getDiscountAmt(price, qty);
        }else{
            return price * qty;
        }
    }
    
    public static void main(String[] args) {
        QtyDiscountWithPercentage d = new QtyDiscountWithPercentage();
        double totalDiscounted = d.getDiscountAmt(100.00, 2);
        System.out.println(totalDiscounted);
         totalDiscounted = d.getDiscountedTotalAmt(100.00, 2);
        System.out.println(totalDiscounted);
    }
}
