package notification;

public class NotificationManager {
    private final NotificationService emailService;
    private final NotificationService smsService;

    public NotificationManager(NotificationService emailService, NotificationService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public void sendNotificationByEmail(String message) {
        emailService.sendNotification(message);
    }

    public void sendNotificationBySms(String message) {
        smsService.sendNotification(message);
    }
}