package Solution.Service.NotificationRepo;

import Solution.Models.User;

public class EmailNotificationChannel implements INotificationChannel{
    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Sending an email notification to " + user.getEmail() + " with message " + message);
    }
}
