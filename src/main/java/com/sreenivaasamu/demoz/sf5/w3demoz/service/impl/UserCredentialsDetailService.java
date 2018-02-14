package com.sreenivaasamu.demoz.sf5.w3demoz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sreenivaasamu.demoz.sf5.w3demoz.domain.User;
import com.sreenivaasamu.demoz.sf5.w3demoz.repository.UserRepository;

@Service("userDetailsService")
@Transactional
public class UserCredentialsDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("No user found with username: " + email);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail()
				, user.getPassword().toLowerCase()
				, null);
	}
}