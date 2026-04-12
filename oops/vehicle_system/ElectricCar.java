package oops.vehicle_system;

public class ElectricCar extends Vehicle implements Electric {
    @Override
    public void charge(){
        System.out.println("Recharge the Car!");
    }
}
