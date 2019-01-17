/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.Vehicle;

import core.Customer;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author kayde
 */
public abstract class Vehicle implements Serializable{

    private String Manufacturer; //can't change
    private String Model; // can't change
    private Customer customer; //set when sold
    private String VIN; //can't change
    private Date manuDate; //can't change
    private Date soldDate; //set when sold
    private boolean sold; //set when sold
    private char taxBand;
    private double cost; // can change

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private ArrayList<String> co2 = new ArrayList<String>(Arrays.asList("0-100", "101-110", "111-120", "121-130", "131-140", "141-150", "151-160"));

    public Vehicle(String manu, String mod, char TB, double c, String v, String manuDate){
        this.Manufacturer = manu;
        this.Model = mod;

        this.cost = c;
        this.VIN = v;
        this.manuDate = new Date(manuDate); //no string validation, it's pointless.

        if (Character.toUpperCase(TB) >= 64 && TB <= 71) {
            this.taxBand = TB;
        } else {
            throw new IllegalArgumentException("Tax band must be between A and G ");
        }
    }
    
    
    public Vehicle(){}

    public void sold(Customer CustomerName) {
        this.customer = CustomerName;

        this.sold = true;
        this.soldDate = new Date();
    }
    
    
    public void sold(Customer CustomerName, Date soldDate) {
        this.customer = CustomerName;

        this.sold = true;
        this.soldDate = soldDate;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public char getTaxBand() {
        return taxBand;
    }
    
    public String getManu() {
        return Manufacturer;
    }
    
    public Date getManuDate() {
        return manuDate;
    }
    
    public String getManuDateAsString(){
        return dateFormat.format(manuDate);
    }
    
    
    public String getSoldDateAsString(){
        return dateFormat.format(soldDate);
    }
    
    public String getModel() {
        return Model;
    }
    
    public double getCost() {
        return cost;
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public String getCO2() {
        return co2.get(taxBand - 64);
    }

    public String getVIN() {
        return this.VIN;
    }

    public boolean isSold() {
        return this.sold;
    }

    public int getAgeOfVehicle() {
        Date today = new Date();
        long diff = today.getTime() - manuDate.getTime();
        return (int) (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) / 7);
    }
    
    public int getSoldAge(){
        if(sold == true){
            Date today = new Date();
            long diff = today.getTime() - soldDate.getTime();
            return (int) (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) / 7);
        }else{
            return 99;
        }
    }

    public Date getSoldDate() {
        if (sold == true) {
            return soldDate;
        } else {
            return null;
        }
    }

    @Override
    public abstract String toString();
}
