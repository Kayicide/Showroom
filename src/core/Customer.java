/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author kayde
 */
public class Customer {
    private String customerName;
    private String email;
    private String tele;
    
    
    Customer(String c){
       this.customerName = c;
    }
    
    Customer(String c, String email, String tele){
        this.customerName = c;
        this.email = email;
        this.tele = tele;
    }
    
    public void setName(String n){
        this.customerName = n;
    }
    
    public void setEmail(String e){
        this.email = e;
    }
    
    public void setTele(String t){
        this.tele = t;
    }
    
    public String getName(){
        return customerName;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getTele(){
        return tele;
    }
    
    @Override
    public String toString(){
        return ("Name: " + customerName + "\nEmail: " + email + "\nTelephone: " + tele);
    }
    
}
