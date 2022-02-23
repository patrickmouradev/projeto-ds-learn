package com.devsuperior.dslearnbds.dto;

import com.devsuperior.dslearnbds.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO{

    private Long id;
    private String name;
    private String email;

    public UserDTO (User user){
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }
}
