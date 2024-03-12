package com.vijay.movieticket.service;

import org.springframework.http.ResponseEntity;

import com.vijay.movieticket.model.UserDetails;

public interface UserDetailsService {
ResponseEntity<?> addUser(UserDetails userDetails);
}
