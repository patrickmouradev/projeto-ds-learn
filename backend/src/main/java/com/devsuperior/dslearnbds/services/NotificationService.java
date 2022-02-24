package com.devsuperior.dslearnbds.services;

import com.devsuperior.dslearnbds.dto.NotificationDTO;
import com.devsuperior.dslearnbds.entities.Notification;
import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private AuthService authService;

    public Page<NotificationDTO> notificationForCurrentUser(Pageable pageable){

        User user = authService.authenticated();

        Page<Notification> page = notificationRepository.findByUser(user,pageable);

        //return page.map( p -> new NotificationDTO(p)); metodo lambda

        return page.map(NotificationDTO::new); //metodo de referentica
    }

}
