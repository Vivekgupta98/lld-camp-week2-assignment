package Solution.Service.NotificationRepo;

import Solution.Models.User;

public interface INotificationChannel {
    public void sendNotification(User user, String message);
}
