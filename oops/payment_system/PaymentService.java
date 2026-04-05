package oops.payment_system;

public class PaymentService {
    private Payment payment;
    
    public PaymentService(Payment payment){
        this.payment = payment;
    }

    public void processPayment(double amount){
        this.payment.pay(amount);
    }
}
