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
public class Customer implements ICustomer{
    private String name;
    private String customerId;
    
    
    public Customer(String name, String customerId){
        this.name = name;
        this.customerId = customerId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustId() {
        return customerId;
    }

    public void setCustId(String customerId) {
        this.customerId = customerId;
    }
    
    
}
