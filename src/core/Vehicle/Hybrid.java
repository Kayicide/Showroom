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
public class Hybrid extends Vehicle implements Serializable{
    private double consumption;
    private String drive;

    public Hybrid(String manu, String mod, char TB, double c, String v, String manuDate, double consumption, String drive) {
        super(manu, mod, TB, c, v, manuDate);
        this.consumption = consumption;
        this.drive = drive;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }
    
    public double getConsumption() {
        return consumption;
    }

    public String getDrive() {
        return drive;
    }
    
    @Override
    public String toString(){
        String returnString = "";
        if (super.isSold()) {
            //Customer information + sold date - cost
            returnString = "Infomation; SOLD" + "\nCustomer Name:  " + super.getCustomer().getName() + "\nDate Sold: " + super.getSoldDateAsString() + "\nType: Hybrid" + "\nVIN:  " + super.getVIN() + "\nManufacturer: " + super.getManu() + "\nManufactur Date " + super.getManuDateAsString() + "\nAge(weeks): " + getAgeOfVehicle() + "\nModel: " + super.getModel() + "\nTax Band; " + super.getTaxBand() + "\n"+ "\nCO2; " + super.getCO2() + "\n";
        } else {
            //Cost - customer information - sold date
            returnString = "Infomation;" + "\nType: Hybrid" + "\nVIN: " + super.getVIN() + "\nManufacturer: " + super.getManu() + "\nManufactur Date: " + super.getManuDateAsString() + "\nAge(weeks): " + getAgeOfVehicle() + "\nModel: " + super.getModel() + "\nTax Band: " + super.getTaxBand() + "\nCost: £" + super.getCost() + "\nCO2; " + super.getCO2() + "\n";
        }
        return returnString; 
    }
    
}
