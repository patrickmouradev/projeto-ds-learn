package com.devsuperior.dslearnbds.controllers;

import com.devsuperior.dslearnbds.dto.NotificationDTO;

import com.devsuperior.dslearnbds.services.AuthService;
import com.devsuperior.dslearnbds.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationController {

    @Autowired
    private NotificationService service;
    @Autowired
    private AuthService authService;

    @GetMapping
    public ResponseEntity<Page<NotificationDTO>> notificationForCurrentUser(
            @RequestParam(name="userReadOnly",defaultValue = "false") Boolean userReadOnly,
            Pageable pageable){

        return ResponseEntity.ok(service.notificationForCurrentUser(userReadOnly,pageable));
    }
}
