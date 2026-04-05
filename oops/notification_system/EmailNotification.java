package oops.notification_system;

public class EmailNotification implements Notification {

    @Override
    public void send(String messsage) {
        System.out.println("Message " +messsage+ " Send by Email");
    }

}
