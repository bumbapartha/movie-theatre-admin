package com.movie.movietheatreadmin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Theatre {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public long id; 
	
	public String name;
	
	//Can be a separate model but keeping the data here for simple implementation
	public String city; 

}
