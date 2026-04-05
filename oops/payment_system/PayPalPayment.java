package oops.payment_system;

public class PayPalPayment implements Payment {

    @Override
    public void pay(double amount) {
       System.out.println("Paid" +amount+ " Using Paypal");
    }

}
