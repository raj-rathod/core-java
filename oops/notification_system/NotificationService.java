package oops.notification_system;

public class NotificationService {
    private Notification notification;

    public NotificationService(Notification notification){
        this.notification = notification;
    }

    public void sendNotification(String message){
        this.notification.send(message);
    }
}
