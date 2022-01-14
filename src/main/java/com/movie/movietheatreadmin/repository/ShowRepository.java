package com.movie.movietheatreadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.movietheatreadmin.model.Show;

public interface ShowRepository extends JpaRepository<Show, Long> {

}
