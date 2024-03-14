package com.vijay.movieticket.service;

import java.util.List;

import com.vijay.movieticket.model.MovieDetails;

public interface MovieDetilsService {
MovieDetails addMovieDetails(MovieDetails movieDetails);
List<MovieDetails> getAllMovies(MovieDetails movieDetails);
}
