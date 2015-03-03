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
public class Receipt {
    private ReceiptDataAccessStrategy db;
    private ReceiptOutputStrategy print;
    private ICustomer customer;
    private String receipt = "";
    private LineItem[] lineItem = new LineItem[0];
    private double total;
    private double discTotal;

    
    
    
    public Receipt(String custId, ReceiptDataAccessStrategy db, ReceiptOutputStrategy print){
        startReceipt();
        this.db = db;
        this.customer = db.findCustomer(custId);
        this.print = print;
        addCustomer();
        addItemHeader();
    }
    
    private void startReceipt(){
        receipt = "Thank you for shopping at Kohl's\n";
    }
    
    private void addCustomer(){
        receipt += "Customer Id: " + customer.getCustId() + "\n";
        receipt += "Customer Name: " + customer.getName() +  "\n";
    }
    
    private void addItemHeader(){
        receipt += "Item Name\t\tQty\t\tPrice\t\tDiscount\tSubtotal\n"
                +  "---------\t\t---\t\t-----\t\t--------\t--------\n";
    }
    
    public void addProduct(String prodId, int qty){
        LineItem[] temp = new LineItem[lineItem.length + 1];
        
        System.arraycopy(lineItem, 0, temp, 0, lineItem.length);
        
        lineItem = temp;
        temp = null;
        
        lineItem[lineItem.length-1] = new LineItem(db.findProduct(prodId), qty);
        receipt += lineItem[lineItem.length-1].getProduct().getName() + "\t" 
                + lineItem[lineItem.length-1].getQty() + "\t\t" 
                + String.format("%.02f",lineItem[lineItem.length-1].getProduct().getPrice())+ "\t\t"
                + String.format("%.02f",lineItem[lineItem.length-1].getProduct().getDiscountAmt(qty)) + "\t\t"
                + String.format("%.02f", getLineSubTotal(lineItem[lineItem.length-1])) + "\t\t"
                +"\n";
    }
    
    private double getLineSubTotal(LineItem lineItem){
        double sub = 0;
        double discount= lineItem.getProduct().getDiscountAmt(lineItem.getQty());
        
        sub = (lineItem.getProduct().getPrice() * lineItem.getQty()) - discount;
        calcTotal(sub);        
        calculateDiscounts(discount);
        return sub;
    }
    
    
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public double getDiscTotal() {
        return discTotal;
    }

    public void setDiscTotal(double discTotal) {
        this.discTotal = discTotal;
    }
    
    
    private void calcTotal(double lineSub){
        total += lineSub;
        
    }
    
    private double calculateDiscounts(double disc){
        discTotal += disc;
        
        
        return discTotal;
    }
    
    public void writeReceipt(){
        receipt += "\n_____________________________________________________________________________\n\n"
                + "\t\t\t\t\t\t\tSubTotal: \t" 
                + String.format("%.02f", getTotal() + getDiscTotal()) + "\n"
                + "\t\t\t\t\t\t\tYou Saved: \t" 
                + String.format("%.02f", getDiscTotal()) + "\n"
                + "\t\t\t\t\t\t\tTotal: \t\t" 
                + String.format("%.02f",getTotal()) + "\n";
        
        
        
        print.print(receipt);
    }
}
