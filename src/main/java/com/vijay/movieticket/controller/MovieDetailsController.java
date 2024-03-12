package com.vijay.movieticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.movieticket.model.MovieDetails;
import com.vijay.movieticket.repositery.MovieDetailsRepo;
import com.vijay.movieticket.service.MovieDetilsService;


@RestController
@RequestMapping("/admin")
public class MovieDetailsController {
	@Autowired
	private MovieDetilsService movieDetailsService;
	@PostMapping("/addmoviedetails")
	public ResponseEntity<?> insertMovieDetails(@RequestBody MovieDetails movieDetails)
	{
		MovieDetails movie=movieDetailsService.addMovieDetails(movieDetails);
		return ResponseEntity.status(HttpStatus.OK)
				.body(movie);
	}
}
