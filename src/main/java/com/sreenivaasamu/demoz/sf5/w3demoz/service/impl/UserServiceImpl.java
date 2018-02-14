package com.sreenivaasamu.demoz.sf5.w3demoz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sreenivaasamu.demoz.sf5.w3demoz.domain.User;
import com.sreenivaasamu.demoz.sf5.w3demoz.domain.UserDto;
import com.sreenivaasamu.demoz.sf5.w3demoz.repository.UserRepository;
import com.sreenivaasamu.demoz.sf5.w3demoz.service.EmailExistsException;
import com.sreenivaasamu.demoz.sf5.w3demoz.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
     
    @Transactional
    @Override
    public User registerNewUserAccount(UserDto accountDto) 
      throws EmailExistsException {
         
        if (emailExist(accountDto.getEmail())) {   
            throw new EmailExistsException(
              "There is an account with that email address:"  + accountDto.getEmail());
        }
        User user = new User();    
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(accountDto.getPassword());
        user.setEmail(accountDto.getEmail());
        return repository.save(user);       
    }
    private boolean emailExist(String email) {
        User user = repository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }    
}