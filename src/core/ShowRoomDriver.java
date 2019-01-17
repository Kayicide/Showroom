/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import core.Vehicle.Vehicle;

/**
 *
 * @author Kay
 */
public class ShowRoomDriver {
    public static void Test(ShowRoom garage){
        Customer person1 = new Customer("Scarlett", "Scarlett@gmail.com", "2312312313");
        Customer person2 = new Customer("Bob", "Bob@gmail.com", "239812831");
        
        garage.addCar("Ford", "Modle T", 'A', 20000, "1", "13-apr-1998", 24);
        garage.addCar("Nissan", "Fast", 'c', 10000, "2", "13-jun-2000", 44, "a big one");
        garage.addCar("ThisShouldBeHybrid", "Slow", 'D', 4500, "3", "13-feb-2005", (double)99.9, "drive?");
        System.out.println("Input = hisShouldBeHybrid, Slow, D, 4500, 3, 13-feb-2005, 99.9, drive? ");
        System.out.println("Output: ");
                    System.out.println(garage.findCar("3").toString());
        garage.addCar("LOL", "The Best", 'B', 50, "4", "13-mar-1970", 999.99);
        
        garage.purchaseCar("1", person1, "1-oct-2018");
        garage.purchaseCar("3", person2, "5-oct-2017");
        
        
        System.out.println("Testing Find");
        if(garage.findCar("2") == null){
            System.out.println("Not Found");
        }else{
            System.out.println(garage.findCar("2").toString());
        }
        
        System.out.println();
        System.out.println("Testing details");
        garage.allCarDetails();
        
        
        System.out.println("Testing set current interest");
        garage.showInterest("2");
        System.out.println(garage.getInterest().toString());
        
        System.out.println();
        System.out.println("Testing next");
        garage.nextInterest();
        System.out.println(garage.getInterest().toString());
        
        System.out.println();
        System.out.println("Testing previous");
        garage.previousInterest();
        System.out.println(garage.getInterest().toString());
        
        
        garage.addCar("x", "x", 'b', 50, "x", "13-jan-2005", 76);
        System.out.println();
        System.out.println();
        System.out.println("Testing adding after current");
        garage.allCarDetails();
        
        System.out.println();
        System.out.println("Testing sold recently: ");
        
        for(Vehicle car: garage.getVehiclesSoldRecently()){
            System.out.println(car);
        }   
        
        
        
        
        
    }
   
}
