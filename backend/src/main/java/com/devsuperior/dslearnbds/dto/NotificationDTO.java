package com.devsuperior.dslearnbds.dto;

import com.devsuperior.dslearnbds.entities.Notification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class NotificationDTO {

    private Long id;
    private String text;
    private Instant moment;
    private boolean read;
    private String route;
    private Long userId;

    public NotificationDTO(Notification notification){
        id = notification.getId();
        text = notification.getText();
        moment = notification.getMoment();
        read = notification.isRead();
        route = notification.getRoute();
        userId = notification.getUser().getId();
    }
}
