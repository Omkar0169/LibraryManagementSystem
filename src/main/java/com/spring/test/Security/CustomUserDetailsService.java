package com.spring.test.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.test.Model.Users;
import com.spring.test.Repo.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private  UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Users u =   userRepo.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("username not found  " + email));
		
		return CustomUserDetails.build(u);
	}

}
