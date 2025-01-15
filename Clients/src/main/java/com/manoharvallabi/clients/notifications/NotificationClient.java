package com.manoharvallabi.clients.notifications;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "notifications", url = "${clients.notifications.url}")
public interface NotificationClient {
    @GetMapping("api/v1/notification/send-notification")
    void sendNotification(NotificationRequest notificationRequest);
}
