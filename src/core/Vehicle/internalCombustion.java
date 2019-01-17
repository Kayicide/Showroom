/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.Vehicle;

import java.io.Serializable;

public class internalCombustion extends Vehicle implements Serializable{
    private double consumption;
    public internalCombustion(String manu, String mod, char TB, double c, String v, String manuDate, double consumption){
        super(manu, mod, TB, c, v, manuDate);
        this.consumption = consumption;
    }
    
    public void setConsumption(double con){
        this.consumption = con;
    }
    
    public double getConsumption(){
        
        return this.consumption;
    }
    
    @Override
    public String toString(){
        String returnString = "";
        if (super.isSold()) {
            //Customer information + sold date - cost
            returnString = "Infomation; SOLD" + "\nCustomer Name:  " + super.getCustomer().getName() + "\nDate Sold: " + super.getSoldDateAsString() + "\nType: Interal Combustion" + "\nVIN:  " + super.getVIN() + "\nManufacturer: " + super.getManu() + "\nManufactur Date " + super.getManuDateAsString() + "\nAge(weeks): " + getAgeOfVehicle() + "\nModel: " + super.getModel() + "\nTax Band; " + super.getTaxBand() + "\n"+ "\nCO2; " + super.getCO2() + "\n";
        } else {
            //Cost - customer information - sold date
            returnString = "Infomation;" + "\nType: Interal Combustion" + "\nVIN: " + super.getVIN() + "\nManufacturer: " + super.getManu() + "\nManufactur Date: " + super.getManuDateAsString() + "\nAge(weeks): " + getAgeOfVehicle() + "\nModel: " + super.getModel() + "\nTax Band: " + super.getTaxBand() + "\nCost: £" + super.getCost() + "\nCO2; " + super.getCO2() + "\n";
        }
        return returnString; 
    }
}
