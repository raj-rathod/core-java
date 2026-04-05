package oops.parking_system;

import java.util.*;

public class ParkingLot {
    private List<ParkingSpot> spots = new ArrayList<>();

    public ParkingLot(int normalSpots, int vipSpots) {
        for (int i = 0; i < normalSpots; i++) {
            spots.add(new ParkingSpot());
        }
    }

    public void parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                spot.park(vehicle);
                return;
            }
        }
        System.out.println("No parking available");
    }

    public void unparkVehicle() {
        for (ParkingSpot spot : spots) {
            if (!spot.isAvailable()) {
                spot.unpark();
                return;
            }
        }
    }
}
