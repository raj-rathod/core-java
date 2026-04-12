package oops.vehicle_system;

public class PetrolCar extends Vehicle implements Fuel {

    @Override
    public void refuel() {
        System.out.println("Refuel Petrol"); 
    }


}
