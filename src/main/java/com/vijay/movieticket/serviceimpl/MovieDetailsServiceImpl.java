package com.vijay.movieticket.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.movieticket.model.MovieDetails;
import com.vijay.movieticket.repositery.MovieDetailsRepo;
import com.vijay.movieticket.service.MovieDetilsService;

@Service
public class MovieDetailsServiceImpl implements MovieDetilsService {
	@Autowired
	private MovieDetailsRepo movieDetailsRepo;

	@Override
	public MovieDetails addMovieDetails(MovieDetails movieDetails) {
		MovieDetails m = movieDetailsRepo.saveAndFlush(movieDetails);
		System.out.print(m);
		return (m);
	}

}
