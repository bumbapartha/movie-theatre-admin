package com.movie.movietheatreadmin.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.movie.movietheatreadmin.model.Theatre;

public interface TheatreRepository  extends PagingAndSortingRepository<Theatre, Long> {
	public List<Theatre> findAllByCity(String city);
}
