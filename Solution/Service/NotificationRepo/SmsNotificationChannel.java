package Solution.Service.NotificationRepo;

import Solution.Models.User;

public class SmsNotificationChannel implements INotificationChannel{

    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Sending Notification to user : " + user.getName() + " with message : [" + message + "]");
    }
}
