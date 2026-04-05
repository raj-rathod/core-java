package oops.notification_system;

public class SmsNotification implements Notification {
   @Override
    public void send(String messsage) {
        System.out.println("Message " +messsage+ " Send by SMS");
    }
}
