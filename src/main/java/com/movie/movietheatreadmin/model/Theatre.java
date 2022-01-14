package com.movie.movietheatreadmin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Theatre {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 
	
	private String name;
	
	//Can be a separate model but keeping the data here for simple implementation
	private String city; 
	
	private int seatCount;

}
