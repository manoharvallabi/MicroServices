package com.manoharvallabi.notification;


import com.manoharvallabi.clients.notifications.NotificationRequest;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/notification")
public class NotificationController {

    private static final Logger log = LoggerFactory.getLogger(NotificationController.class);
    private NotificationService notificationService;
    @PostMapping("/send-notification")
    public void sendNotification(@RequestBody NotificationRequest notificationRequest)
    {
        log.info("received notificaiton request {}:", notificationRequest);
            notificationService.recordNotification(notificationRequest);
    }

}
