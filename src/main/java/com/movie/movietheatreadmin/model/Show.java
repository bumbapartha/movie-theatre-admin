package com.movie.movietheatreadmin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Show {
	
	@Id
	@GeneratedValue
	public long id;
	
	//24 hour format
	public short startHour;
	
	//0 - 60 min
	public short startMin;
	
	@ManyToOne
    private Movie movie;
	
	@ManyToOne
    private Theatre theatre;
}
