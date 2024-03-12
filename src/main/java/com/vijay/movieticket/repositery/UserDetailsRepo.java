package com.vijay.movieticket.repositery;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.movieticket.model.UserDetails;

public interface UserDetailsRepo extends JpaRepository<UserDetails,Integer>{
	
	Boolean existsByUserName(String username);
	List<UserDetails> findByUserName(String userName);

}
