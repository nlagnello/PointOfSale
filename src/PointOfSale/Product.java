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
public class Product {
    
    private String prodID;
    private String name;
    private double price;
    private DiscountStrategy discountStrategy;
    
    public Product(){
        
    }

    public Product(String prodID, String name, double price, DiscountStrategy discountStrategy) {
        this.prodID = prodID;
        this.name = name;
        this.price = price;
    }
    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
    
    public double getDiscountAmt(int qty){
        return discountStrategy.getDiscountAmt(price, qty);
    }
    

    public String getProdId() {
        return prodID;
    }

    public void setProdId(String prodID) {
        if(prodID == null || prodID.isEmpty()){
            //warning message needed
        }
        this.prodID = prodID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()) {
            this.name = "Not Provided";
        }else{
        this.name = name;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 0){
            this.price = 0.00;
        }else{
        this.price = price;
        }
    }
   
    
}
