/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.Vehicle;

import java.io.Serializable;

/**
 *
 * @author kayde
 */
public class Electric extends Vehicle implements Serializable{
    private int range;
    private String batteryType;
    public Electric(String manu, String mod, char TB, double c, String v, String manuDate, int range, String batteryType){
        super(manu, mod, TB, c, v, manuDate);
        this.range = range;
        this.batteryType = batteryType;
    }
    
    public void setRange(int range){
        this.range = range;
    }
    
    public int getRange(){
        return this.range;
    }
    
    public void setBatteryType(String batteryType){
        this.batteryType = batteryType;
    }
    
    public String getBatteryType(){
        return this.batteryType;
    }
    
    @Override
    public String toString(){
        String returnString = "";
        if (super.isSold()) {
            //Customer information + sold date - cost
            returnString = "Infomation; SOLD" + "\nCustomer Name:  " + super.getCustomer().getName() + "\nDate Sold: " + super.getSoldDateAsString() + "\nType: Electic" + "\nVIN:  " + super.getVIN() + "\nManufacturer: " + super.getManu() + "\nManufactur Date " + super.getManuDateAsString() + "\nAge(weeks): " + getAgeOfVehicle() + "\nModel: " + super.getModel() + "\nTax Band; " + super.getTaxBand() + "\n"+ "\nCO2; " + super.getCO2() + "\n";
        } else {
            //Cost - customer information - sold date
            returnString = "Infomation;" + "\nType: Electric" + "\nVIN: " + super.getVIN() + "\nManufacturer: " + super.getManu() + "\nManufactur Date: " + super.getManuDateAsString() + "\nAge(weeks): " + getAgeOfVehicle() + "\nModel: " + super.getModel() + "\nTax Band: " + super.getTaxBand() + "\nCost: £" + super.getCost() + "\nCO2; " + super.getCO2() + "\n";
        }
        return returnString; 
    }
}
