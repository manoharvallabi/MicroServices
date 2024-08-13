package com.manoharvallabi;


import com.manoharvallabi.clients.notifications.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/notification")
public class NotificationController {

    private NotificationService notificationService;
    @PostMapping("/send-notification")
    public void sendNotification(@RequestBody NotificationRequest notificationRequest)
    {
            notificationService.recordNotification(notificationRequest);
    }

}
