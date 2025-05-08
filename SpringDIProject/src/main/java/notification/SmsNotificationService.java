package notification;

public class SmsNotificationService implements NotificationService {
    private final String provider;

    public SmsNotificationService(String provider) {
        this.provider = provider;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("[SMS] Sending: " + message + " via Provider: " + provider);
    }
}