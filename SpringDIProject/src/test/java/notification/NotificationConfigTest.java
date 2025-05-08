package notification;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NotificationConfigTest {

    @Test
    public void notificationManagerTest() {
        // 스프링 컨테이너 생성
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(NotificationConfig.class);

        NotificationManager notificationManager = context.getBean(NotificationManager.class);

        assertNotNull(notificationManager);

        notificationManager.sendNotificationByEmail("Hello via Email!");
        notificationManager.sendNotificationBySms("Hello via SMS!");

        context.close();
    }
}