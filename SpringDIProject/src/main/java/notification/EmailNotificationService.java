package notification;

public class EmailNotificationService implements NotificationService {
    private final String smtpServer;
    private final int port;

    public EmailNotificationService(String smtpServer, int port) {
        this.smtpServer = smtpServer;
        this.port = port;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("[Email] Sending: " + message + " via SMTP Server: " + smtpServer + ", Port: " + port);
    }
}