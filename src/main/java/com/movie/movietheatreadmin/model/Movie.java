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
public class Movie {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public long id; 
	
	
	public String name;
	

}
