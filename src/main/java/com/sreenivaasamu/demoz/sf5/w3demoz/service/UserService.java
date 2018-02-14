package com.sreenivaasamu.demoz.sf5.w3demoz.service;

import com.sreenivaasamu.demoz.sf5.w3demoz.domain.User;
import com.sreenivaasamu.demoz.sf5.w3demoz.domain.UserDto;

public interface UserService {

    public User registerNewUserAccount(UserDto accountDto) 
    	      throws EmailExistsException;
	
}
