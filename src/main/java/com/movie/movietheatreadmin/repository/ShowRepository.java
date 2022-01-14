package com.movie.movietheatreadmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.movietheatreadmin.model.Show;
import com.movie.movietheatreadmin.model.Theatre;

public interface ShowRepository extends JpaRepository<Show, Long> {
	public List<Show> findAllByTheatre(Theatre t);
}
