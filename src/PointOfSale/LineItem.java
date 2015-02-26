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
public class LineItem {

    private Product product;
    private int qty;

    public LineItem() {

    }

    public LineItem(Product product, int qty) {
        this.product = product;
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void addProduct(Product product, int qty) {
        this.product = product;
        this.qty = qty;
    }

}
