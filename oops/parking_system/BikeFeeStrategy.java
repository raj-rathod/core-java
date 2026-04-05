package oops.parking_system;

public class BikeFeeStrategy implements FeeStrategy {

    @Override
    public double calculateFee(int hours) {
        return hours*10;
    }
    
}
