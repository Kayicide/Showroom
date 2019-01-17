/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import core.Customer;

/**
 *
 * @author kayde
 */
public class CustomerDriver {
    public static void Test(){
        Customer customer = new Customer("Test human", "testing@human.com", "219318203");
        System.out.println(customer);
        
        System.out.println();
        
        customer.setEmail("changedemail");
        System.out.println(customer);
        
        
        
        
    }
    
    
    
    
}
