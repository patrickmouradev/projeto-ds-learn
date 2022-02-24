package com.devsuperior.dslearnbds.services;

import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.enuns.RolesEnum;
import com.devsuperior.dslearnbds.repositories.UserRepository;
import com.devsuperior.dslearnbds.services.exceptions.ForbiddenException;
import com.devsuperior.dslearnbds.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public User authenticated(){
        try{
            String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
            return userRepository.findByEmail(userEmail);

        } catch (Exception e){
            throw new UnauthorizedException("Invalid User");
        }
     }

     //Valida se é o proprio usuario autenticado ou admim
     public void validateSelfOrAdmim (Long userId){
        User user = authenticated();
         if(!user.getId().equals(userId)&& !user.hasHole(RolesEnum.ROLE_ADMIN.toString())){
             throw new ForbiddenException("Access denied");
         }
     }
}
