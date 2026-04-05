package oops.parking_system;

public class CarFeeStrategy implements FeeStrategy {

    @Override
    public double calculateFee(int hours) {
        return hours*20;
    }
    
}
