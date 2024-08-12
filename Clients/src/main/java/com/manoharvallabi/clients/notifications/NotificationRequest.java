package com.manoharvallabi.clients.notifications;

import lombok.Builder;

@Builder
public record NotificationRequest(
        Integer id,
        String message,
        String email,
        String sender
) {}

