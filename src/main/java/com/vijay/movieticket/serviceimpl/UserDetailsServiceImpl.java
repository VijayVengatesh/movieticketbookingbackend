package com.vijay.movieticket.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vijay.movieticket.model.UserDetails;
import com.vijay.movieticket.repositery.UserDetailsRepo;
import com.vijay.movieticket.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
@Autowired
private UserDetailsRepo userDetailsRepo;

@Override
public ResponseEntity<?> addUser(UserDetails userDetails) {
	Boolean name=userDetailsRepo.existsByUserName(userDetails.getUserName());
	if(name)
	{
		String data="username already exists";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(data);
	}
	UserDetails user=userDetailsRepo.saveAndFlush(userDetails);
	return ResponseEntity.ok(user);
}

}
