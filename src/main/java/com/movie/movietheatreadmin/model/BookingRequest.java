package com.movie.movietheatreadmin.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {
	
	long showId;
	
	Date date;
	
	int seatChoice;

}
