package com.movie.movietheatreadmin.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.movie.movietheatreadmin.model.Movie;

public interface MovieRepository  extends PagingAndSortingRepository<Movie, Long> {

}
