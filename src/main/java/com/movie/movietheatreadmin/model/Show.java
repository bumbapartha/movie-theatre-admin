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
public class Show {
	
	@Id
	@GeneratedValue
	public long id;
	
	//24 hour format
	public int startHour;
	
	//0 - 60 min
	public int startMin;
	
	public Date startDate;
	
	public Date endDate;
	
	public double price;
	
	@ManyToOne
    private Movie movie;
	
	@ManyToOne
    private Theatre theatre;
}
