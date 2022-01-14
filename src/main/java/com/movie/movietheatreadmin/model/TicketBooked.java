package com.movie.movietheatreadmin.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class TicketBooked {
	
	@Id
	@GeneratedValue
	public long id;
	
	@ManyToOne
	private Show show;
	
	private int seat;
	
	private Date showdate;
	
	//CONFIRMED, RESERVE(To book for temporary)
	private String status;
	
	private Date bookingTime;

}
