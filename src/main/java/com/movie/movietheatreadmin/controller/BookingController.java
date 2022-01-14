package com.movie.movietheatreadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.movietheatreadmin.model.BookingRequest;
import com.movie.movietheatreadmin.model.BookingResponse;
import com.movie.movietheatreadmin.service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	
	@PostMapping("/booking")
	public BookingResponse bookShow(@RequestBody BookingRequest bookingRequest) {
		
		return bookingService.reserveSeat(bookingRequest);
		
	}

}
