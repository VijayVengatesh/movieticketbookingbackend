package com.vijay.movieticket.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.movieticket.model.Login;
import com.vijay.movieticket.model.UserDetails;
import com.vijay.movieticket.repositery.UserDetailsRepo;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserDetailsRepo userDetailsRepo;
	@PostMapping("/add")
	public ResponseEntity<?> addLoginDetails(@RequestBody Login login)
	{
		//		System.out.println(optionalUserDetails.isPresent());
		List<UserDetails> luser=userDetailsRepo.findByUserName(login.getUserName());
		
		if(luser.isEmpty())
		{
			ResponseEntity<?> u=ResponseEntity.status(HttpStatus.OK)
					.body("user name does not exists");
			return ResponseEntity.status(HttpStatus.OK)
			.body(u);
		}
		else
		{
			ResponseEntity<?> u=ResponseEntity.status(HttpStatus.OK)
					.body(luser);
			return ResponseEntity.status(HttpStatus.OK)
					.body(u);
		}
	}

}
