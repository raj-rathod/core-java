
package oops.parking_system;
import java.time.LocalDateTime;

class ParkingSpot {
    protected Vehicle vehicle;
    protected LocalDateTime entryTime;

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.entryTime = LocalDateTime.now();
        System.out.println(vehicle.getNumber() + " parked at " + entryTime);
    }

    public double unpark() {
        LocalDateTime exitTime = LocalDateTime.now();
        int hours = (int) java.time.Duration.between(entryTime, exitTime).toHours();
        hours = Math.max(hours, 1); // minimum 1 hour

        double fee = vehicle.calculateFee(hours);

        System.out.println(vehicle.getNumber() + " exited at " + exitTime);
        System.out.println("Total Hours: " + hours + ", Fee: " + fee);

        vehicle = null;
        return fee;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }
}
