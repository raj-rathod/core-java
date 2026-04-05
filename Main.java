
import oops.notification_system.*;

public class Main {
    public static void main(String[] arg) {
       Notification notification = new PushNotification();

       NotificationService notificationService = new NotificationService(notification);

       notificationService.sendNotification("Hello World!");
    }

  
}
