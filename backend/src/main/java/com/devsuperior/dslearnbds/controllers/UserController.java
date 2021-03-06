package com.devsuperior.dslearnbds.controllers;

import com.devsuperior.dslearnbds.dto.UserDTO;
import com.devsuperior.dslearnbds.services.AuthService;
import com.devsuperior.dslearnbds.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private AuthService authService;

    @GetMapping(value = ("/{id}"))
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        authService.validateSelfOrAdmim(id);
        return ResponseEntity.ok(service.findById(id));
    }
}
