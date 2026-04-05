package oops.notification_system;

public class PushNotification implements Notification {
   @Override
    public void send(String messsage) {
        System.out.println("Message " +messsage+ " Send by Push Notification");
    }
}
