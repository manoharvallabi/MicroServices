package com.manoharvallabi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Notifications {

    @Id
    @SequenceGenerator(name="notification_id_sequence", sequenceName = "notification_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "notification_id_sequence")
    private Integer notificationId;
    private LocalDateTime createdAt;
    private Integer customerId;
    private String email;
    private String message;
    private String sender;

}
