package com.vijay.movieticket.serviceimpl;

import java.util.List;

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
		return (m);
	}

	@Override
	public List<MovieDetails> getAllMovies(MovieDetails movieDetails) {
		// TODO Auto-generated method stub
		List<MovieDetails> listmovie=movieDetailsRepo.findAll();
		return listmovie;
	}

}
