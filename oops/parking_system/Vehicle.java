package oops.parking_system;

abstract class Vehicle {
    private String number;
    protected FeeStrategy feeStrategy;

    public Vehicle(String number, FeeStrategy feeStrategy){
        this.number = number;
        this.feeStrategy = feeStrategy;
    }

    public String getNumber(){
        return number;
    }

    public double calculateFee(int hours){
        return feeStrategy.calculateFee(hours);
    }
}
