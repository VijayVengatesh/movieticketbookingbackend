package com.vijay.movieticket.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vijay.movieticket.model.MovieDetails;

@Repository
public interface MovieDetailsRepo extends JpaRepository<MovieDetails,Integer> {

}
