package com.movie.movietheatreadmin.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.movietheatreadmin.model.Show;
import com.movie.movietheatreadmin.model.TicketBooked;

public interface TicketBookingRepository extends JpaRepository<TicketBooked, Long> {
	
	List<TicketBooked> findByShowAndSeatAndShowdate(Show show, int seat, Date showdate);
}
