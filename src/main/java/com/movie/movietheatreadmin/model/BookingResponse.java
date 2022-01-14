package com.movie.movietheatreadmin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
	
	BookingRequest request;
	
	double actualPrice;
	
	double finalPrice;
	
	double discountPercentage;
}
