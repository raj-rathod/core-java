package oops.payment_system;

public class UPIPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid "+ amount + " Using UPI");
    }

}
