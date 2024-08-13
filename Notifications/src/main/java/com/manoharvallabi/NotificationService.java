package com.manoharvallabi;

import com.manoharvallabi.clients.notifications.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationsRepository notificationsRepository;
    public void recordNotification(NotificationRequest notificationRequest) {
        notificationsRepository.save(
                                    Notifications.builder()
                                            .customerId(notificationRequest.id())
                                            .email(notificationRequest.email())
                                            .message(notificationRequest.message())
                                            .sender(notificationRequest.sender())
                                            .createdAt(LocalDateTime.now())
                                            .build());
    }
}
