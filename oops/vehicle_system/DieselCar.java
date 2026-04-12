package oops.vehicle_system;

public class DieselCar extends Vehicle implements Fuel {

    @Override
    public void refuel() {
       System.out.println("Refuel the diesel");
    }

}
