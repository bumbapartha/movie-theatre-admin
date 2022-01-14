package com.movie.movietheatreadmin.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.movie.movietheatreadmin.model.Theatre;

public interface TheatreRepository  extends PagingAndSortingRepository<Theatre, Long> {

}
