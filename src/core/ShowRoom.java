/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import core.Vehicle.Vehicle;
import java.util.ArrayList;
import java.util.Date;
import core.Vehicle.internalCombustion;
import core.Vehicle.Electric;
import core.Vehicle.Hybrid;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ShowRoom {

    private ArrayList<Vehicle> vehicles;
    private int current = -1;
    private File file;

    public ShowRoom() {
        vehicles = new ArrayList<Vehicle>();
        file = new File("vehicles.txt");
    }

    //ADDING AND REMOVING
    public void addCar(String manu, String mod, char TB, double cost, String vin, String manuDate, double consumption) {
        Vehicle tempVehicle = new internalCombustion(manu, mod, Character.toUpperCase(TB), cost, vin, manuDate, consumption);
        if (current == vehicles.size() || current == -1) {
            vehicles.add(tempVehicle);
        } else {
            vehicles.add(current + 1, tempVehicle);
        }
    }

    public void addCar(String manu, String mod, char TB, double cost, String vin, String manuDate, int range, String batteryType) {
        Vehicle tempVehicle = new Electric(manu, mod, Character.toUpperCase(TB), cost, vin, manuDate, range, batteryType);
        if (current == vehicles.size() || current == -1) {
            vehicles.add(tempVehicle);
        } else {
            vehicles.add(current + 1, tempVehicle);
        }
    }

    public void addCar(String manu, String mod, char TB, double cost, String vin, String manuDate, double consumption, String drive) {
        Vehicle tempVehicle = new Hybrid(manu, mod, Character.toUpperCase(TB), cost, vin, manuDate, consumption, drive);
        if (current == vehicles.size() || current == -1) {
            vehicles.add(tempVehicle);
        } else {
            vehicles.add(current + 1, tempVehicle);
        }
    }

    public boolean deleteCar(String vin) {
        Vehicle temp = findCar(vin);
        if (temp != null) {
            vehicles.remove(temp);
            return true;
        }
        return false;
    }

    public boolean deleteCar(Vehicle toDelete) {
        if (vehicles.remove(toDelete) == true) {
            return true;
        }
        return false;
    }

    //FIND CAR IF GIVEN ONLY VIN
    public Vehicle findCar(String vin) {
        for (Vehicle car : vehicles) {
            if (car.getVIN().equalsIgnoreCase(vin)) {
                return car;
            }
        }
        return null;
    }

    //PURCHASING THE CAR
    public boolean purchaseCar(String vin, Customer customerName) {
        if (findCar(vin) != null) {
            Vehicle tempVehicle = findCar(vin);
            tempVehicle.sold(customerName);
            return true;
        } else {
            return false;
        }
    }

    public boolean purchaseCar(Vehicle temp, Customer customerName) {
        temp.sold(customerName);
        return true;
    }

    public boolean purchaseCar(String vin, Customer customerName, String soldDate) {
        if (findCar(vin) != null) {
            Vehicle tempVehicle = findCar(vin);
            tempVehicle.sold(customerName, new Date(soldDate));
            return true;
        } else {
            return false;
        }
    }

    //DATE STUFF
    public ArrayList<Vehicle> getVehiclesSoldRecently() {
        ArrayList<Vehicle> soldRecently = new ArrayList<Vehicle>();

        for (Vehicle car : vehicles) {
            if (car.getSoldAge() < 2) {
                soldRecently.add(car);
            }
        }
        return soldRecently;
    }

    public void reduceOld() {
        for (Vehicle car : vehicles) {
            if (car.isSold() == false) {
                if (car.getAgeOfVehicle() > 12) {
                    car.setCost(car.getCost() * 0.2);
                }
            }
        }
    }

    //INTEREST MANAGEMENT
    public boolean showInterest(String VIN) {
        if (vehicles.indexOf(findCar(VIN)) != -1) {
            current = vehicles.indexOf(findCar(VIN));
            return true;
        } else {
            return false;
        }
    }

    public boolean nextInterest() {
        if (current == vehicles.size() - 1) {
            return false;
        } else {
            current++;
            return true;
        }
    }

    public boolean previousInterest() {
        if (current == 0) {
            return false;
        } else {
            current--;
            return true;
        }
    }

    public Vehicle getInterest() {
        return vehicles.get(current);
    }

    //DUMP THE ARRAY
    public void allCarDetails() {
        for (Vehicle car : vehicles) {
            System.out.println(car.toString());
        }
    }

    public void saveAll() throws IOException {
        boolean error;
        do {
            error = false;
            try {
                ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file));
                writer.writeObject(vehicles);
            } catch (FileNotFoundException e) {
                if (file.createNewFile()) {
                    System.out.println("File has been created!");
                } else {
                    System.out.println("File has failed to create!");
                }
            }
        } while (error == true);
    }

}
