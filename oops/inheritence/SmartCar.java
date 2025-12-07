package oops.inheritence;

import oops.Interfaces.Autoparking;
import oops.Interfaces.ParkingAssitant;

public class SmartCar implements Autoparking, ParkingAssitant {

    @Override
    public void start(){
      Autoparking.super.start();
       System.out.println("Smart car start");
    }

    @Override
    public void autoDrive(String car) {
       System.out.println(car);
    }
    
}
